package project.jdbc;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import project.jdbc.database.DBConnection;
import project.jdbc.database.dao.TaskDao;
import project.jdbc.database.models.Task;
import project.jdbc.database.models.Task.Priority;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Successful");
        } else {
            System.out.println("Failed");
            return;
        }
    }
}
