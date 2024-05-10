package com.yourdomain.booking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

class BookingManagerTest {
    @BeforeEach
    void setUp() {
        // Initialize the database before each test
        DBUtil.initializeDatabase();
    }

    @AfterEach
    void tearDown() {
        // Clean up the database after each test
        try (Connection conn = DBUtil.connect();
                Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM bookings";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error cleaning up database: " + e.getMessage());
        }
    }

    @Test
    void testAddBooking() {
        BookingManager.addBooking("Alice", "2023-10-12");
        assertNotEquals(0, BookingManager.getAllBookings().size());
    }

    @Test
    void testGetAllBookings() {
        BookingManager.addBooking("Bob", "2023-10-13");
        BookingManager.addBooking("Charlie", "2023-10-14");
        assertEquals(2, BookingManager.getAllBookings().size());
    }

    @Test
    void testDatabaseEntry() {
        BookingManager.addBooking("David", "2023-10-15");
        try (Connection conn = DBUtil.connect();
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM bookings WHERE name = 'David'");
            assertTrue(rs.next());
            assertEquals("David", rs.getString("name"));
            assertEquals("2023-10-15", rs.getString("date"));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
}
