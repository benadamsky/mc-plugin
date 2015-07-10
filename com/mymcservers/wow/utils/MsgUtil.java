package com.mymcservers.wow.utils;

import com.mymcservers.wow.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MsgUtil {
    public static Main m;

    public static void noPermission(Player p) {
        p.sendMessage(Main.errorpc + " You do not have permission for that action!");
    }

    public static void onTeleport(Player p) {
        p.sendMessage(Main.errorpc + " You have been teleported!");
    }

    public static void kick(Player p, String reason) {
        p.kickPlayer(ChatColor.RED + "" + ChatColor.BOLD + "[RPGWAR]" + ChatColor.DARK_RED + "\n\nKicked: " + ChatColor.GOLD + reason);
    }
    public static void messager(Player p, Player tp, String msg){
        tp.sendMessage(ChatColor.RED + "> " + ChatColor.GOLD +  p.getName() + ChatColor.WHITE + ": " + msg);
        p.sendMessage(ChatColor.GREEN + "> " + ChatColor.GOLD + tp.getName() + ChatColor.WHITE + ": " + msg);

    }
    public static void consoleMsg(CommandSender s, String msg){
        s.sendMessage(msg);
    }
    public static void nullArgs(Player p){
        p.sendMessage(Main.errorpc + " Not enough arguments!");
    }
    public static void nullP(Player p){
        p.sendMessage(Main.errorpc + " Could not find target player!");
    }
    public static  void notYou(Player p){
        p.sendMessage(Main.errorpc + " Talking to yourself again?");
    }
    public static void nullReason(Player p){
        p.sendMessage(Main.errorpc + " Please give a reason.");
    }
    public static  void newObjective(Player p, String msg){
        p.sendMessage(Main.objpc + msg);
    }
}

/*





 */