package com.echoes;

import org.bukkit.plugin.java.JavaPlugin;
import com.echoes.commands.*;
import com.echoes.managers.*;
import com.echoes.storage.DataManager;

public class EchoesPlugin extends JavaPlugin {

    private DataManager data;
    private EmpireManager empires;
    private OathManager oaths;

    @Override
    public void onEnable() {
        data = new DataManager(this);
        data.load();

        empires = new EmpireManager(data);
        oaths = new OathManager(data);

        getCommand("empire").setExecutor(new EmpireCommand(this));
        getCommand("oath").setExecutor(new OathCommand(this));
    }

    @Override
    public void onDisable() {
        data.save();
    }

    public EmpireManager empires() { return empires; }
    public OathManager oaths() { return oaths; }
}
