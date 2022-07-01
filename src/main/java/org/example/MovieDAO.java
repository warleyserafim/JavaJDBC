package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private Connection connetion = null;
    private PreparedStatement statement = null;

    public MovieDAO() {
        connetion = new ConnectionFactory().getConnection();
    }

    public List<Movie> findAll() throws SQLException {
        String query = "SELECT * from movie";
        List<Movie> movies = new ArrayList<Movie>();

        statement = connetion.prepareStatement(query);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            movies.add(new Movie(res.getInt("id"), res.getString("name")));
        }

        return movies;
    }

    public Movie findById(Integer id) throws SQLException {
        String query = "SELECT * FROM movie WHERE id = ?";
        statement = connetion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();

        Movie movie = null;
        while (res.next()) {
            movie = new Movie(res.getInt("id"), res.getString("name"));
        }
        return movie;
    }

    public void insert(Movie movie) throws SQLException {

        String query = "INSERT INTO movie (name) VALUES(?)";

        statement = connetion.prepareStatement(query);
        statement.setString(1, movie.getName());
        statement.execute();

    }

    public void update(Movie movieOld, Movie movieNew) throws SQLException {

        String query = "UPDATE movie SET name = ? WHERE id = ?";
        statement = connetion.prepareStatement(query);
        statement.setString(1, movieNew.getName());
        statement.setInt(2, movieNew.getId());

        statement.execute();
    }

    public void delete(Movie movie) throws SQLException {

        String query = "DELETE FROM movie WHERE id = ?";

        statement = connetion.prepareStatement(query);
        statement.setInt(1, movie.getId());
        statement.execute();

    }
}
