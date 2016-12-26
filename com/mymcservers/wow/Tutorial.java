/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow;

import com.mymcservers.wow.sql.DatabaseConnection;
import com.mymcservers.wow.sql.Methods;
import com.mymcservers.wow.utils.MsgUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import java.util.Set;
import static com.mymcservers.wow.sql.Methods.containsPlayer;
import static com.mymcservers.wow.sql.Methods.getRank;
import static com.mymcservers.wow.sql.Methods.setInt;

public class Tutorial implements Listener {
    public static Location tutloc = new Location(Bukkit.getServer().getWorld("world"),0.55,70,0.55);
    private static int num = 0;
    @EventHandler
    public void setCheckPoint(PlayerJoinEvent e){
        Player p = e.getPlayer();
        int checkpoint = Methods.getInt("player_info", p, "checkpoint");
        if(!Methods.containsPlayer(p)){
            Methods.addPlayer(p);
            Methods.setInt("player_info", e.getPlayer(), "checkpoint", 1);
        }
        if(!Methods.containsPlayer(p)){
            Methods.setInt("player_info", e.getPlayer(), "checkpoint", 1);
        }
    }



    @EventHandler
    public void tutorial(PlayerJoinEvent e){
        Player p = e.getPlayer();
        int checkpoint = Methods.getInt("player_info", p, "checkpoint");
        if (!Methods.containsPlayer(p) || checkpoint == 1) {
            runTutorial(e.getPlayer());
        }
        if(checkpoint == 2)
        {
            zendrickQuest(e.getPlayer());
        }
    }


    @EventHandler
    public void removeChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        int checkpoint = Methods.getInt("player_info", p, "checkpoint");
        if(!Methods.containsPlayer(p)){
            Player sender = e.getPlayer();
            Set<Player> r = e.getRecipients();
            for (Player pls : Bukkit.getServer().getOnlinePlayers()) {
                r.remove(pls);
                return;
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();
        if (checkpoint(p) != 0)
        {
            e.setCancelled(true);
        }

    }


    @EventHandler
    public void cancelMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(checkpoint(p) == 1){
            if(e.getTo() != Tutorial.tutloc){
                p.teleport(Tutorial.tutloc);
            }
        }else{

        }
    }



    @EventHandler
    public void Checkpoint(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        Methods.setInt("player_info", e.getPlayer(), "checkpoint", checkpoint(p));
    }




    public static void runTutorial(Player p)
    {
        int checkpoint = Methods.getInt("player_info",p,"checkpoint");
        if(checkpoint == 1){
            p.teleport(new Location(p.getWorld(),0,70,0 ));
            String msg1 = getName() + ChatColor.GOLD + "Welcome to RPG War, " + ChatColor.GREEN + p.getName() + ChatColor.GOLD + "!";
            String msg2 = getName() + ChatColor.GOLD + "Before you are able to choose your path, you must survive through the tutorial.";
            String msg3 = getName() + ChatColor.GREEN + "Master Zendrick " + ChatColor.GOLD + "will see how tough you really are. ";
            String msg4 = getName() + ChatColor.GOLD + "Good luck, and I hope to see you make it through alive...";
            Tutorial.tutorialMsg(p, msg1, msg2, msg3, msg4);
            Methods.setInt("player_info",p,"checkpoint",2);
        }
    }

    public static void zendrickQuest(Player p)
    {
        MsgUtil.newObjective(p, "Speak with " + ChatColor.GREEN + "Master Zendrick" + ChatColor.GOLD + ".");
    }

    public static void completeTutorial(Player p)
    {
        p.sendMessage(/*header +*/ ChatColor.GOLD + "Congratulations " + ChatColor.GREEN + p.getName() + ChatColor.GOLD + " in completing the tutorial!");
        MsgUtil.newObjective(p, "Speak with " + ChatColor.GREEN + "Ravlik " + ChatColor.GOLD + "at " + ChatColor.RED + "Gwenline Creek" + ChatColor.GOLD + ".");
        setInt("table_info", p, "tutorial", 0);
    }


    public static String getName()
    {
        if(num == 0) {
            String name = "Lord Dionylik: ";
            return ChatColor.AQUA + name;
        }
        else
            return "undefined";
    }
    public static int timer;
    @SuppressWarnings("deprecation")
    public static void tutorialMsg(final Player p, final String msg1, final String msg2, final String msg3, final String msg4){
        timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
            int number = 5;
            public void run() {
                number--;
                if(number > -1){
                    if(number != 0){
                        if(number == 4){
                            p.sendMessage(msg1);
                            return;
                        }
                        if(number == 3){
                            p.sendMessage(msg2);
                            return;
                        }
                        if(number == 2){
                            p.sendMessage(msg3);
                            return;
                        }
                        if(number == 1){
                            p.sendMessage(msg4);
                            return;
                        }
                        if(number == 0){
                            Bukkit.getScheduler().cancelTask(timer);
                        }
                    }else{

                    }
                }else{

                }
            }
        }, 40L, 80L);
    }












    public int checkpoint(Player p){
        int cp = Methods.getInt("player_info", p, "checkpoint");
        return cp;
    }

}
