package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class App 
{

    public static void main( String[] args ) throws SQLException {
        Scanner scaner = new Scanner(System.in);

        MovieDAO movieDAO = new MovieDAO();

        System.out.println("----------------Menu---------------");
        System.out.println("1 - List Movies");
        System.out.println("2 - Create Movie");
        System.out.println("3 - Update Movie");
        System.out.println("4 - Delete Movie");
        System.out.println("----------------Menu---------------");

        int choice = scaner.nextInt();

        switch (choice) {
            case 1:
                ArrayList<Movie> data = (ArrayList<Movie>) movieDAO.findAll();

                if (data.size() > 0) {
                    for (Movie movie : data) {
                        System.out.println("Id: " + movie.getId());
                        System.out.println("Nome: " + movie.getName());
                        System.out.println("----------------###----------------");
                    }
                } else {
                    System.out.println("Does Not Exists");
                }
                break;
            case 2:
                System.out.println("Enter Name: ");
                String name = scaner.next();
                movieDAO.insert(new Movie(name));
                break;
            case 3:
                System.out.println("Enter Movie Id: ");
                Integer id = scaner.nextInt();

                Movie movieExist = movieDAO.findById(id);

                if (movieExist != null) {
                    System.out.println("Enter new movie name: ");
                    String movieName = scaner.next();

                    Movie movieNew = new Movie(movieExist.getId(), movieName);
                    movieDAO.update(movieExist, movieNew);
                } else {
                    System.out.println("Does Not Exists");
                }
                break;
            case 4:
                System.out.println("Enter Movie Id: ");
                Integer idDelete = scaner.nextInt();

                Movie movieExistDelete = movieDAO.findById(idDelete);

                if (movieExistDelete != null) {
                    movieDAO.delete(movieExistDelete);
                } else {
                    System.out.println("Does Not Exists");
                }
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
}
