/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow.sql;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Methods {

    public synchronized static void addPlayer(Player player) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO player_info values(?, 0, 0, 0, 1, 1);");
            ps.setString(1, player.getUniqueId().toString());
            ps.execute();
            ps.close();
        }catch (SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
        }
    }

    public synchronized static boolean containsPlayer(Player player) {
        try {
            if(player == null){
                return false;
            }else{
                PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM player_info WHERE uuid=?;");
                ps.setString(1, player.getUniqueId().toString());
                ResultSet set = ps.executeQuery();
                boolean containsPlayer = set.next();
                ps.close();
                set.close();
                return containsPlayer;
            }
        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
            return false;
        }
    }
    public synchronized static String getRank(Player p) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT rank FROM player_info WHERE uuid=?;");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet set = ps.executeQuery();
            set.next();
            int rank = set.getInt("rank");
            ps.close();
            set.close();

            if(rank == 8){
                return ChatColor.RED + "[Owner]" + ChatColor.RESET;
            } else if (rank == 7) {
                return ChatColor.DARK_RED + "[Admin]" + ChatColor.RESET;
            } else if (rank == 6) {
                return ChatColor.DARK_AQUA + "[Mod]" + ChatColor.RESET;
            } else if (rank == 5) {
                return ChatColor.LIGHT_PURPLE + "[Ultra]" + ChatColor.RESET;
            } else if (rank == 4) {
                return ChatColor.GREEN + "[Legend]" + ChatColor.RESET;
            } else if (rank == 3) {
                return ChatColor.YELLOW + "[Hero]" + ChatColor.RESET;
            } else if (rank == 2) {
                return ChatColor.DARK_GREEN + "[Supporter]" + ChatColor.RESET;
            } else if (rank == 1) {
                return ChatColor.AQUA + "[Donator]" + ChatColor.RESET;
            } else {
                return ChatColor.DARK_GRAY + "" + ChatColor.RESET;
            }

        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
            return null;
        }
    }
    public synchronized static int getRankN(Player p) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT rank FROM player_info WHERE uuid=?;");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet set = ps.executeQuery();
            set.next();
            int rank = set.getInt("rank");
            ps.close();
            set.close();
            return rank;

        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
            return Integer.parseInt(null);
        }
    }
    public synchronized static void setInt(String section, Player player, String stat, int number) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("UPDATE "+section+" SET "+stat+"=? WHERE uuid=?;");
            ps.setInt(1, number);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
        }
    }

    public synchronized static Integer getInt(String section, Player player, String stat) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT "+stat+" FROM "+section+" WHERE uuid=?;");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet set = ps.executeQuery();
            set.next();
            int number = set.getInt(stat);
            ps.close();
            set.close();
            return number;
        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static void setBoolean(String section, Player player, String setting, boolean bool) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("UPDATE "+section+" SET "+setting+"=? WHERE uuid=?;");
            ps.setBoolean(1, bool);
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
        }
    }

    public synchronized static Boolean getBoolean(String section, Player player, String setting) {
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT "+setting+" FROM "+section+" WHERE uuid=?;");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet set = ps.executeQuery();
            set.next();
            int bool = set.getInt(setting);
            ps.close();
            set.close();
            if (bool == 1) {
                return true;
            } else {
                return false;
            }
        } catch(SQLException e) {
            Bukkit.getLogger().severe("An error has occured.");
            Bukkit.getLogger().severe("Exception: ");
            e.printStackTrace();
            return null;
        }
    }

}
