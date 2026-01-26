package com.echoes.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import com.echoes.EchoesPlugin;

public class EmpireCommand implements CommandExecutor {

    private final EchoesPlugin pl;
    public EmpireCommand(EchoesPlugin pl){this.pl=pl;}

    public boolean onCommand(CommandSender s, Command c, String l, String[] a){
        if(!(s instanceof Player p)) return true;

        if(a.length==0) return false;

        switch(a[0]) {
            case "create" -> {
                if(!p.hasPermission("echoes.empire.create")) return true;
                if(a.length<2) return true;
                if(pl.empires().empireOf(p.getUniqueId())!=null) return true;
                pl.empires().create(a[1], p.getUniqueId());
                p.sendMessage("Empire created.");
            }
            case "disband" -> {
                String e = pl.empires().empireOf(p.getUniqueId());
                if(e!=null) pl.empires().disband(e);
                p.sendMessage("Empire disbanded.");
            }
            case "info" -> {
                String e = pl.empires().empireOf(p.getUniqueId());
                p.sendMessage(e==null?"No empire.":"Empire: "+e);
            }
        }
        return true;
    }
}