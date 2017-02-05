package com.epam.catalog.bean.catalog;

import com.epam.catalog.bean.Request;

/**
 * Created by PC on 01.02.2017.
 */
public class RequestCatalog extends Request {
    private String type;
    private String name;
    private String genre;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
