package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection connection = ServerConnection.getConnection();
            if (connection != null) {
                System.out.println("Connected to SQL Server successfully!");
                ServerConnection.closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
