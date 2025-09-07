package project.jdbc.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import project.jdbc.database.DBConnection;
import project.jdbc.database.models.Task;
import project.jdbc.database.models.Task.*;

public class TaskDao {

    private Connection connection;

    public TaskDao() {
        this.connection = DBConnection.getConnection();
    }

    public void insertTask(Task task) {
        String sqlQuery = "Insert into tasks (title,description,due,priority,status) values (?,?,?,?,?)";
        PreparedStatement query;
        try {
            query = connection.prepareStatement(sqlQuery);

            // set parameters
            query.setString(1, task.getTitle());
            query.setString(2, task.getDescription());
            query.setTimestamp(3, Timestamp.valueOf(task.getDueDateTime()));
            query.setString(4, task.getPriority().name());
            query.setString(5, task.getStatus().name());

            // execute
            query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Task> getAllTasks() {
        String sqlQuery = "select * from tasks";
        List<Task> tasks = new ArrayList<>();
        PreparedStatement query;
        try {
            query = connection.prepareStatement(sqlQuery);
            // execute
            ResultSet result = query.executeQuery();
            while (result.next()) {
                Task tmp;
                tmp = getTaskFromResults(result);
                tasks.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private Task getTaskFromResults(ResultSet result) throws SQLException {
        return new Task(
                result.getInt("id"),
                result.getString("title"),
                result.getString("description"),
                result.getTimestamp("due").toLocalDateTime(),
                Priority.valueOf(result.getString("priority")),
                Status.valueOf(result.getString("status")));
    }

}
