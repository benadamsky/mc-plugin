/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow;

import com.mymcservers.wow.sql.DatabaseConnection;
import com.mymcservers.wow.sql.Methods;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static com.mymcservers.wow.sql.Methods.getRank;

public class Join implements Listener {

    @EventHandler
    public void dataCheck(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!Methods.containsPlayer(p)){
            Methods.addPlayer(p);
        }
    }

    @EventHandler
    public void rankCheck(PlayerJoinEvent e)
    {
        final Player p = e.getPlayer();
        if (Methods.containsPlayer(p)) {
            if (Methods.getInt("player_info", p, "rank") >= 3) {
                e.setJoinMessage(getRank(p) + " " +  p.getDisplayName() + ChatColor.AQUA + " has joined the lobby!");
            } else {
                e.setJoinMessage("");
                p.setGameMode(GameMode.ADVENTURE);
            }
        }else{
            Methods.addPlayer(p);
        }
    }

    @EventHandler
    public void tpCP(PlayerJoinEvent e){
        Player p = e.getPlayer();
        int checkpoint = Methods.getInt("player_info", p, "checkpoint");
        if(checkpoint == 1){
            p.teleport(Tutorial.tutloc);
        }
    }

}
