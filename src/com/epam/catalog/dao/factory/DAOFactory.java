package com.epam.catalog.dao.factory;

import com.epam.catalog.dao.ProductDAO;
import com.epam.catalog.dao.impl.FileCatalogDAO;

/**
 * Created by PC on 30.01.2017.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ProductDAO filProductDAO = new FileCatalogDAO();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ProductDAO getProductDAO() {
        return filProductDAO;
    }
}
