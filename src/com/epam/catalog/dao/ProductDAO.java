package com.epam.catalog.dao;

import com.epam.catalog.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PC on 30.01.2017.
 */
public interface ProductDAO {
    ArrayList readFile() throws DAOException;

    HashMap contentCatalog(ArrayList<String> arrayList) throws DAOException;

    void addProduct(String type, String name, String genre) throws DAOException;

    ArrayList findByType(String type) throws DAOException;

    ArrayList findByName(String name) throws DAOException;

    ArrayList findByGenre(String genre) throws DAOException;

    HashMap getCatalog() throws DAOException;
}
