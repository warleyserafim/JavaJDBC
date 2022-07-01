package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "wsa", "root");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
        if ((connection == null)) {
            System.out.println("failed");
            return;
        }
//        Statement serve para acessar o banco de dados enviar comandos para interaçao com BD
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY(id))";

//        String sql = "DROP TABLE movie";
        statement.executeUpdate(sql);
    }
}
