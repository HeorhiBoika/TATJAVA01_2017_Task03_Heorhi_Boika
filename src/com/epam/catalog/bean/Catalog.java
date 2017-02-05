package com.epam.catalog.bean;

import java.util.HashMap;

/**
 * Created by PC on 30.01.2017.
 */
public class Catalog {
    private String name;
    private String genre;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", genre='" + genre + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (name != null ? !name.equals(catalog.name) : catalog.name != null) return false;
        return genre != null ? genre.equals(catalog.genre) : catalog.genre == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    public Catalog(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
