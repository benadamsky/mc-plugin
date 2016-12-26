/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow.utils;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import java.util.Random;

public class MOTD implements Listener {
    @EventHandler
    public void onPing(ServerListPingEvent e)
    {
        Random r = new Random();
        int next = r.nextInt(4)+1;
        String motd = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "RPG" + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "WAR" + ChatColor.YELLOW + "  " + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + " --" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[-  " + ChatColor.GREEN + "" + ChatColor.BOLD + "Your Adventure Awaits..." + "\n";
        if (next == 1) {
            e.setMotd(motd+ChatColor.AQUA+"Visit our website at "+ ChatColor.DARK_AQUA +  "" + ChatColor.BOLD + "rpgwar.com");
        } else if (next == 2) {
            e.setMotd(motd+ChatColor.AQUA+"Donate at "+ ChatColor.DARK_AQUA +  "" + ChatColor.BOLD + "store.rpgwar.com");
        } else if (next == 3) {
            e.setMotd(motd+ChatColor.AQUA+"Chat with us on TeamSpeak at "+ ChatColor.DARK_AQUA +  "" + ChatColor.BOLD + "ts.rpgwar.com");

    }
}
}
