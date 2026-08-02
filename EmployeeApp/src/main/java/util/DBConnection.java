package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String URL =
        "jdbc:oracle:thin:@//database-1.c1cqwa8isnnr.ap-south-1.rds.amazonaws.com:1521/DATABASE";

    private static final String USER = "admin";
    private static final String PASSWORD = "varma123";

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);

            // Native Network Encryption
            props.setProperty("oracle.net.encryption_client", "REQUIRED");
            props.setProperty("oracle.net.encryption_types_client", "(AES256)");

            props.setProperty("oracle.net.crypto_checksum_client", "REQUIRED");
            props.setProperty("oracle.net.crypto_checksum_types_client", "(SHA512)");

            // Enable JDBC Oracle Net tracing
            props.setProperty("oracle.net.trace_level", "ADMIN");
            props.setProperty("oracle.net.trace_directory", "/tmp");
            props.setProperty("oracle.net.trace_file", "jdbc_nne.trc");

            Connection con = DriverManager.getConnection(URL, props);

            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
