/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow.Commands;

import com.mymcservers.wow.utils.MsgUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

//MESSAGE COMMAND
            if (label.equalsIgnoreCase("message") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if (label.equalsIgnoreCase("message") && args.length == 1) {
                MsgUtil.nullArgs(p);
            }
            if (label.equalsIgnoreCase("message") && args.length > 1) {
                Player tp = Bukkit.getPlayer(args[0]);
                if (tp != null)
                {
                    if(tp != p){
                        String msg = "";
                        for (int a = 1; a < args.length; a++) {
                            msg = msg + args[a] + " ";
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        MsgUtil.messager(p, tp, msg);
                    }else {
                        MsgUtil.notYou(p);
                    }
                }else{
                    MsgUtil.nullP(p);
                }
            }





//MSG COMMAND
            if (cmd.getName().equalsIgnoreCase("msg") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("msg") && args.length == 1) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("msg") && args.length > 1) {
                Player tp = Bukkit.getPlayer(args[0]);
                if (tp != null)
                {
                    if(tp != p){
                        String msg = "";
                        for (int a = 1; a < args.length; a++) {
                            msg = msg + args[a] + " ";
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        MsgUtil.messager(p, tp, msg);
                    }else {
                        MsgUtil.notYou(p);
                    }
                }else{
                    MsgUtil.nullP(p);
                }
            }

//TELL COMMAND
            if (cmd.getName().equalsIgnoreCase("tell") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("tell") && args.length == 1) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("tell") && args.length > 1) {
                Player tp = Bukkit.getPlayer(args[0]);
                if (tp != null)
                {
                    if(tp != p){
                        String msg = "";
                        for (int a = 1; a < args.length; a++) {
                            msg = msg + args[a] + " ";
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        MsgUtil.messager(p, tp, msg);
                    }else {
                        MsgUtil.notYou(p);
                    }
                }else{
                    MsgUtil.nullP(p);
                }
            }

//T COMMAND
            if (cmd.getName().equalsIgnoreCase("t") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("t") && args.length == 1) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("t") && args.length > 1) {
                Player tp = Bukkit.getPlayer(args[0]);
                if (tp != null)
                {
                    if(tp != p){
                        String msg = "";
                        for (int a = 1; a < args.length; a++) {
                            msg = msg + args[a] + " ";
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        MsgUtil.messager(p, tp, msg);
                    }else {
                        MsgUtil.notYou(p);
                    }
                }else{
                    MsgUtil.nullP(p);
                }
            }

//M COMMAND
            if (cmd.getName().equalsIgnoreCase("m") && args.length == 0) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("m") && args.length == 1) {
                MsgUtil.nullArgs(p);
            }
            if (cmd.getName().equalsIgnoreCase("m") && args.length > 1) {
                Player tp = Bukkit.getPlayer(args[0]);
                if (tp != null)
                {
                    if(tp != p){
                        String msg = "";
                        for (int a = 1; a < args.length; a++) {
                            msg = msg + args[a] + " ";
                        }
                        msg = msg.substring(0, msg.length() - 1);
                        MsgUtil.messager(p, tp, msg);
                    }else {
                        MsgUtil.notYou(p);
                    }
                }else{
                    MsgUtil.nullP(p);
                }
            }
        }        
        return false;
    }
}
