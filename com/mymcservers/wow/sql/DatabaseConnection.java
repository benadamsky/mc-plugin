/* Copyright (c) 2016, Ben Adamsky */

package com.mymcservers.wow.sql;

import org.bukkit.Bukkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public synchronized static void creatConnection(String url, String user, String pass) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch(SQLException e) {
            Bukkit.getLogger().severe("Error, could not connect to database.");
            Bukkit.getLogger().severe("Exception: ");
            e.getStackTrace();
        }
    }

    public synchronized static void closeConnection() {
        try {
            connection.close();
        } catch(SQLException e) {
            Bukkit.getLogger().severe("Error, could not close the database connection!");
            Bukkit.getLogger().severe("Exception:");
            e.getStackTrace();
        }
    }
}
