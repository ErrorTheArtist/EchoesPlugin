package com.echoes.managers;

import com.echoes.storage.DataManager;
import java.util.UUID;

public class OathManager {

    private final DataManager data;

    public OathManager(DataManager data) {
        this.data = data;
    }

    public boolean has(UUID p) {
        return data.oaths.containsKey(p);
    }

    public void swear(UUID p, String empire) {
        data.oaths.put(p, empire);
    }

    public void leave(UUID p) {
        data.oaths.remove(p);
    }
}
