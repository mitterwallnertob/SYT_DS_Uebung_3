/*
* Derzeit noch nicht funktionsfähig!
*
 */

/*
package com.example.uebunug_3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAO {
    private final String url = "jdbc:mysql://localhost:3306/todolist";
    private final String user = "root";
    private final String password = "uebung_3";

    public List<String> getTodoItems() {
        List<String> todoList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT todo FROM todo_items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoList.add(resultSet.getString("todo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    public void addTodoItem(String todo) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO todo_items (todo) VALUES (?)");
            statement.setString(1, todo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/