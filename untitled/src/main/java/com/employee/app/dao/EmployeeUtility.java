package com.employee.app.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUtility {
    public static Connection getConnectionToMySQL() {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ford_schema?" + "user=root&password=Elyonn2022!");
            System.out.println("Connection to MYSQL successful!");
            Statement stmt = connection.createStatement();
            System.out.println("Drop employee table if exists");
            stmt.executeUpdate("DROP TABLE IF EXISTS employee");

            String sql = "CREATE TABLE employee " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50), " +
                    " salary FLOAT, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created employee table");

        } catch (SQLException e) {
            System.out.println("Connect unsuccessful: " + e);
            e.printStackTrace();
        }

        return connection;
    }

}
