package project.jdbc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {
    public static void createTasksTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id SERIAL PRIMARY KEY," +
                "title VARCHAR(255) NOT NULL," +
                "description TEXT," +
                "due TIMESTAMP," +
                "priority VARCHAR(10)," +
                "status VARCHAR(15)" +
                ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tasks table checked/created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}