package project.jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection instance;

    public static void disconnect() {
        System.out.println("Database disconnected");
        instance = null;
    }

    public static Connection getConnection() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection(DBConfig.getUrl(), DBConfig.getUser(), DBConfig.getPassword());
                DBInit.createTasksTableIfNotExists(instance); // pass connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
