package com.mymcservers.wow.Commands;

import com.mymcservers.wow.Main;
import com.mymcservers.wow.sql.Methods;
import com.mymcservers.wow.utils.MsgUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetRank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            //PLAYER CMD
            Player p = (Player) sender;
            if(Methods.getRankN(p) == 8 || p.isOp()) {
                if (label.equalsIgnoreCase("setrank") && args.length == 0) {
                    MsgUtil.nullArgs(p);
                }
                if (label.equalsIgnoreCase("setrank") && args.length == 1) {
                    MsgUtil.nullArgs(p);
                }
                if (label.equalsIgnoreCase("setrank") && args.length == 2) { //1
                    Player tp = Bukkit.getServer().getPlayer(args[0]);
                    if(Methods.containsPlayer(tp) == false){
                        Methods.addPlayer(tp);
                        try { //5
                            int theInt = Integer.parseInt(args[1]);
                            Methods.setInt("player_info", tp, "rank", theInt);
                            p.sendMessage(Main.staffpc + "Player " + ChatColor.GOLD + tp.getName() + ChatColor.RED + " has been changed to rank " + Methods.getRank(tp));

                     /*5*/
                        } catch (NumberFormatException e) { //3
                            MsgUtil.consoleMsg(sender, "Please set rank as an integer.");
                            return false;
                        }
                    }else{
                        try { //5
                            int theInt = Integer.parseInt(args[1]);
                            Methods.setInt("player_info", tp, "rank", theInt);
                            p.sendMessage(Main.staffpc + "Player " + ChatColor.GOLD + tp.getName() + ChatColor.RED + " has been changed to rank " + Methods.getRank(tp));

                     /*5*/
                        } catch (NumberFormatException e) { //3
                            MsgUtil.consoleMsg(sender, "Please set rank as an integer.");
                            return false;
                        } //3
                    }
                } //1

            }else{
                MsgUtil.noPermission(p);
            }
        }else{

            //CONSOLE CMD
            if(label.equalsIgnoreCase("setrank") && args.length == 0){
                MsgUtil.consoleMsg(sender, "Choose a person.");
            }
            if(label.equalsIgnoreCase("setrank") && args.length == 1){
                MsgUtil.consoleMsg(sender, "Choose a rank.");
            }
            if(label.equalsIgnoreCase("setrank") && args.length == 2){
                try{
                    int theInt = Integer.parseInt(args[1]);
                    Player tp = Bukkit.getPlayer(args[0]);
                    Methods.setInt("player_info", tp, "rank", theInt);
                    MsgUtil.consoleMsg(sender, "Player " + tp.getName() + " was set to rank " + Methods.getRank(tp));
                    tp.sendMessage("You have been set to " + Methods.getRank(tp));
                }catch(NumberFormatException e) {
                    MsgUtil.consoleMsg(sender, "Please set rank as an integer.");
                    return false;
                }
            }
        }
    return false;
}
}