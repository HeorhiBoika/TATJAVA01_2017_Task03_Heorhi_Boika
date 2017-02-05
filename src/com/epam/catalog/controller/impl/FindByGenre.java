package com.epam.catalog.controller.impl;

import com.epam.catalog.bean.Request;
import com.epam.catalog.bean.Response;
import com.epam.catalog.bean.catalog.RequestCatalog;
import com.epam.catalog.bean.catalog.ResponseCatalog;
import com.epam.catalog.controller.Command;
import com.epam.catalog.controller.exception.ControllerException;
import com.epam.catalog.service.CatalogService;
import com.epam.catalog.service.exception.ServiceException;
import com.epam.catalog.service.factory.ServiceFactory;

import java.util.ArrayList;

/**
 * Created by PC on 31.01.2017.
 */
public class FindByGenre implements Command {
    @Override
    public Response execute(Request request) throws ControllerException {
        ResponseCatalog response = new ResponseCatalog();
        RequestCatalog requestCatalog = (RequestCatalog) request;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        ArrayList<String> genreList;
        try {
            genreList = catalogService.findByGenre(requestCatalog.getGenre());
            response.setArrayList(genreList);
            response.setSuccessMessage("Find by genre!");
            response.setStatus(1);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatus(-1);
        }
        return response;
    }
}
