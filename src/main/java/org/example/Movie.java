package org.example;

public class Movie {

    private Integer id;
    private String name;

    public Movie() {

    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
