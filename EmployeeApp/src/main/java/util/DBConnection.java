package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Update with your RDS details
    private static final String URL =
            "jdbc:oracle:thin:@//database-1.c1cqwa8isnnr.ap-south-1.rds.amazonaws.com:1521/DATABASE";

    private static final String USER = "admin";
    private static final String PASSWORD = "varma123";

    public static Connection getConnection() {

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            System.out.println("Connecting to Oracle RDS...");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Oracle Database Connected Successfully!");

            return con;

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return null;
    }
}
