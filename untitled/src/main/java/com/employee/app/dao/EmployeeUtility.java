package com.employee.app.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeUtility {
    public static Connection getConnectionToMySQL() {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ford_exam_schema?" + "user=root&password=Elyonn2022!");
            System.out.println("Connection to MYSQL successful!");
        } catch (SQLException e) {
            System.out.println("Connect unsuccessful: " + e);
            e.printStackTrace();
        }

        return connection;
    }

}
