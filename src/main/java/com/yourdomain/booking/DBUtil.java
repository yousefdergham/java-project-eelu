package com.yourdomain.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUtil {
  private static final String URL = "jdbc:sqlite:booking.db";

  public static void initializeDatabase() {
    try (Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement()) {
      // Create table if not exists
      String sql = "CREATE TABLE IF NOT EXISTS bookings (" +
          "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
          "name TEXT NOT NULL, " +
          "date TEXT NOT NULL)";
      stmt.execute(sql);
      System.out.println("Database has been initialized.");
    } catch (Exception e) {
      System.out.println("Error initializing database: " + e.getMessage());
    }
  }

  public static Connection connect() {
    try {
      return DriverManager.getConnection(URL);
    } catch (Exception e) {
      System.out.println("Error connecting to database: " + e.getMessage());
      return null;
    }
  }
}
