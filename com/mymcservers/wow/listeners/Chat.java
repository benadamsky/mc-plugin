package com.mymcservers.wow.listeners;

import com.mymcservers.wow.sql.Methods;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class Chat implements Listener {
    @EventHandler
    public void setFormat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String pname = p.getName();
        p.setDisplayName(Methods.getRank(p) + " " + pname + ": " + e.getMessage());
        e.setFormat(p.getDisplayName());
    }

}
