package com.echoes.managers;

import com.echoes.storage.DataManager;
import java.util.UUID;

public class EmpireManager {

    private final DataManager data;

    public EmpireManager(DataManager data) {
        this.data = data;
    }

    public boolean exists(String name) {
        return data.owners.containsKey(name);
    }

    public String empireOf(UUID owner) {
        return data.owners.entrySet().stream()
                .filter(e -> e.getValue().equals(owner))
                .map(e -> e.getKey()).findFirst().orElse(null);
    }

    public void create(String name, UUID owner) {
        data.owners.put(name, owner);
    }

    public void disband(String name) {
        data.owners.remove(name);
        data.oaths.entrySet().removeIf(e -> e.getValue().equals(name));
    }
}