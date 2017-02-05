package com.epam.catalog.service.factory;


import com.epam.catalog.service.CatalogService;
import com.epam.catalog.service.impl.CatalogServiceImpl;

/**
 * Created by PC on 31.01.2017.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final CatalogService catalogService = new CatalogServiceImpl();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }
}
