/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow;

import com.mymcservers.wow.Commands.Kick;
import com.mymcservers.wow.Commands.Messages;
import com.mymcservers.wow.Commands.SetRank;
import com.mymcservers.wow.listeners.Chat;
import com.mymcservers.wow.sql.DatabaseConnection;
import com.mymcservers.wow.sql.Methods;
import com.mymcservers.wow.utils.MOTD;
import com.mymcservers.wow.utils.MsgUtil;
import com.mymcservers.wow.utils.Titles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.SQLException;

public class Main extends JavaPlugin implements CommandExecutor
{
    public static String errorpc = (ChatColor.RED + "" + ChatColor.BOLD + "ERROR > " + ChatColor.GOLD);
    public static String staffpc = (ChatColor.DARK_RED + "" + ChatColor.BOLD + "STAFF > " + ChatColor.RED);
    public static String objpc = (ChatColor.GREEN + "" + ChatColor.MAGIC + ChatColor.BOLD + "::" + ChatColor.AQUA + "" + ChatColor.BOLD + "NEW OBJECTIVE > " + ChatColor.GOLD);

    public static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    @Override
    public void onEnable()
    {
        getCommand("message").setExecutor(new Messages());
        getCommand("msg").setExecutor(new Messages());
        getCommand("m").setExecutor(new Messages());
        getCommand("tell").setExecutor(new Messages());
        getCommand("t").setExecutor(new Messages());
        getCommand("kick").setExecutor(new Kick());
        getCommand("setrank").setExecutor(new SetRank());

        DatabaseConnection.creatConnection("hidden url", "hidden username", "hidden password");
        if (DatabaseConnection.getConnection() != null) {
            Main.console.sendMessage("[RPGWAR] " + ChatColor.AQUA + "Database Connection Successful!");
        }
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SpawnVillagers(), this);
        pm.registerEvents(new Tutorial(), this);
        pm.registerEvents(new MOTD(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Chat(), this);
        this.getLogger().info("RPGWAR Enabled!");
    }
    @Override
    public void onDisable()
    {
        try {
            if (DatabaseConnection.getConnection() == null && DatabaseConnection.getConnection().isClosed()) {
                DatabaseConnection.closeConnection();
            }
        }catch(SQLException e) {
        }
        this.getLogger().info("RPGWAR Disabled!");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof  Player){
            Player p = (Player) sender;
            if(label.equalsIgnoreCase("test")){
                Titles.sendTitle(p, "TEST", "T", 5, 10, 5);
            }
        }
        return false;
    }

    public static Plugin getPlugin()
    {
        return Bukkit.getPluginManager().getPlugin("RPGWAR");
    }
}
