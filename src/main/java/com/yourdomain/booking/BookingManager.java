package com.yourdomain.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
  public static void addBooking(String name, String date) {
    String sql = "INSERT INTO bookings(name, date) VALUES(?, ?)";
    try (Connection conn = DBUtil.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, name);
      pstmt.setString(2, date);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static List<String> getAllBookings() {
    List<String> bookings = new ArrayList<>();
    String sql = "SELECT * FROM bookings";
    try (Connection conn = DBUtil.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {
      while (rs.next()) {
        bookings.add(rs.getInt("id") + " - " + rs.getString("name") + " on " + rs.getString("date"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return bookings;
  }
}
