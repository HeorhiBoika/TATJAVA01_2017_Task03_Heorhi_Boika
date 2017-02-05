package com.epam.catalog.controller.impl;

import com.epam.catalog.bean.Catalog;
import com.epam.catalog.bean.Request;
import com.epam.catalog.bean.Response;
import com.epam.catalog.bean.catalog.ResponseCatalog;
import com.epam.catalog.bean.Type;
import com.epam.catalog.controller.Command;
import com.epam.catalog.controller.exception.ControllerException;
import com.epam.catalog.service.CatalogService;
import com.epam.catalog.service.exception.ServiceException;
import com.epam.catalog.service.factory.ServiceFactory;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by PC on 31.01.2017.
 */
public class GetCatalog implements Command {
    @Override
    public Response execute(Request request) throws ControllerException {
        ResponseCatalog response = new ResponseCatalog();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        HashMap<Type, HashSet<Catalog>> catalog;
        try {
            catalog = catalogService.getCatalog();
            response.setHashMap(catalog);
            response.setSuccessMessage("Сatalog is found!");
            response.setStatus(1);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatus(-1);
        }
        return response;
    }
}
