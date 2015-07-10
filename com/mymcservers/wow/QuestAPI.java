package com.mymcservers.wow;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class QuestAPI
{
    public static void gatherQuest(String name, String item, int size, Player p) {
        List<String> notif = new ArrayList<String>();
        notif.add(ChatColor.GOLD + "Quest " + ChatColor.GREEN + name + ChatColor.GOLD + " has been started!");
        notif.add(ChatColor.GOLD + "You can leave this quest at any time by typing " + ChatColor.GREEN + "/quest leave");
        notif.add(ChatColor.GOLD + "Objective: ");
        notif.add(ChatColor.GREEN + "Gather " + ChatColor.RED + size + " " + ChatColor.GREEN + item);
        notif.forEach(p::sendMessage);
    }
}
