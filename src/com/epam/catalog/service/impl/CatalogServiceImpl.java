package com.epam.catalog.service.impl;

import com.epam.catalog.bean.Catalog;
import com.epam.catalog.bean.Type;
import com.epam.catalog.dao.ProductDAO;
import com.epam.catalog.dao.exception.DAOException;
import com.epam.catalog.dao.factory.DAOFactory;
import com.epam.catalog.service.CatalogService;
import com.epam.catalog.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PC on 31.01.2017.
 */
public class CatalogServiceImpl implements CatalogService {
    @Override
    public void contentCatalog() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            ProductDAO productDAO = daoFactory.getProductDAO();
            ArrayList<String> listFile = new ArrayList<>(productDAO.readFile());
            productDAO.contentCatalog(listFile);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void addNewProduct(String type, String name, String genre) throws ServiceException {
        if ((type.toLowerCase().equals("фильм")) | (type.toLowerCase().equals("книга")) | (type.toLowerCase().equals("диск"))) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                ProductDAO productDAO = daoFactory.getProductDAO();
                productDAO.addProduct(type, name, genre);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        } else {
            throw new ServiceException("Type may be only : фильм, книга or диск");
        }
    }

    @Override
    public HashMap getCatalog() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        ProductDAO productDAO = daoFactory.getProductDAO();
        HashMap<Type, ArrayList<Catalog>> catalog;
        try {
            catalog = productDAO.getCatalog();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return catalog;

    }

    @Override
    public ArrayList findByGenre(String genre) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        ProductDAO productDAO = daoFactory.getProductDAO();
        ArrayList<String> genreList;
        try {
            genreList = productDAO.findByGenre(genre);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return genreList;
    }

    @Override
    public ArrayList findByName(String name) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        ProductDAO productDAO = daoFactory.getProductDAO();
        ArrayList<String> nameList;
        try {
            nameList = productDAO.findByName(name);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return nameList;
    }

    @Override
    public ArrayList findByType(String type) throws ServiceException {
        ArrayList<String> typeList;
        if ((type.toLowerCase().equals("фильм")) | (type.toLowerCase().equals("книга")) | (type.toLowerCase().equals("диск"))) {
            DAOFactory daoFactory = DAOFactory.getInstance();
            ProductDAO productDAO = daoFactory.getProductDAO();
            try {
                typeList = productDAO.findByType(type);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        } else {
            throw new ServiceException("Type may be only : фильм, книга or диск");
        }
        return typeList;
    }
}
