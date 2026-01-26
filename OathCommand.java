package com.echoes.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import com.echoes.EchoesPlugin;

public class OathCommand implements CommandExecutor {

    private final EchoesPlugin pl;
    public OathCommand(EchoesPlugin pl){this.pl=pl;}

    public boolean onCommand(CommandSender s, Command c, String l, String[] a){
        if(!(s instanceof Player p)) return true;

        if(a.length==0) return false;

        switch(a[0]) {
            case "swear" -> {
                if(a.length<2) return true;
                pl.oaths().swear(p.getUniqueId(), a[1]);
                p.sendMessage("Oath sworn.");
            }
            case "leave" -> {
                pl.oaths().leave(p.getUniqueId());
                p.sendMessage("Oath left.");
            }
        }
        return true;
    }
}