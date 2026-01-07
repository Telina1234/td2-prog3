

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    private DBConnection() {}

    public static Connection getDBConnection() {
        if (connection == null) {
            try {
                String jdbcUrl = System.getenv("JDBC_URL");
                String username = System.getenv("USERNAME");
                String password = System.getenv("PASSWORD");

                connection = DriverManager.getConnection(jdbcUrl, username, password);
                System.out.println("Connexion réussie");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
