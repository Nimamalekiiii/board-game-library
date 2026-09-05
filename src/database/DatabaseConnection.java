package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Endre passordet hvis du bruker et annet i MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/BoardGameLibraryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Nima2002";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kunne ikke koble til databasen.");
            e.printStackTrace();
            return null;
        }

    }

}