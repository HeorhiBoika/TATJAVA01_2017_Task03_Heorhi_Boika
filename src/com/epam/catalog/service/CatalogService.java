package com.epam.catalog.service;

import com.epam.catalog.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PC on 30.01.2017.
 */
public interface CatalogService {
    void contentCatalog() throws ServiceException;

    void addNewProduct(String type, String name, String genre) throws ServiceException;

    HashMap getCatalog() throws ServiceException;

    ArrayList findByType(String type) throws ServiceException;

    ArrayList findByName(String name) throws ServiceException;

    ArrayList findByGenre(String genre) throws ServiceException;
}
