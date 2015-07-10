package com.mymcservers.wow.Commands;

import com.mymcservers.wow.utils.MsgUtil;
import com.mymcservers.wow.utils.Titles;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(label.equalsIgnoreCase("kick") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if(label.equalsIgnoreCase("kick") && args.length == 1) {
                MsgUtil.nullReason(p);
            }
            if(label.equalsIgnoreCase("kick") && args.length > 1) {
                String msg = "";
                for (int a = 1; a < args.length; a++) {
                    msg = msg + args[a] + " ";
                }
                msg = msg.substring(0, msg.length() - 1);
                MsgUtil.kick(p, msg);
            }
        }
        return false;
    }
    }



