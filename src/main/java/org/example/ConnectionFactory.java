package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String Url = "jdbc:mysql://localhost:3306/movies?serverTimezone=UTC";
    private final String User = "wsa";
    private final String Senha = "root";
    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";


    private Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(Url, User, Senha);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public Connection getConnection() {
        return createConnection();
    }
}
