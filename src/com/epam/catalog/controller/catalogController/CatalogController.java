package com.epam.catalog.controller.catalogController;

import com.epam.catalog.bean.Catalog;
import com.epam.catalog.bean.Type;
import com.epam.catalog.bean.catalog.RequestCatalog;
import com.epam.catalog.bean.catalog.ResponseCatalog;
import com.epam.catalog.controller.Controller;
import com.epam.catalog.view.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by PC on 01.02.2017.
 */
public class CatalogController extends Controller {

    public void contentCatalogFromFile() {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("CONTENT_CATALOG");
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        if (responseCatalog.getStatus() == 1) {
            Console console = Console.getInstance();
            console.showCatalogAction();
        }
    }

    public void addNewProduct(String type, String name, String genre) {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("ADD_PRODUCT");
        requestCatalog.setType(type);
        requestCatalog.setName(name);
        requestCatalog.setGenre(genre);
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        Console console = Console.getInstance();
        console.showCatalogAction();
    }

    public void findByType(String type) {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("FIND_BY_TYPE");
        requestCatalog.setType(type);
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        if (responseCatalog.getStatus() == 1) {
            printCatalogByGroup(responseCatalog);
        }
        Console console = Console.getInstance();
        console.showCatalogAction();
    }

    public void findByName(String name) {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("FIND_BY_NAME");
        requestCatalog.setName(name);
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        if (responseCatalog.getStatus() == 1) {
            printCatalogByGroup(responseCatalog);
        }
        Console console = Console.getInstance();
        console.showCatalogAction();
    }

    public void findByGenre(String genre) {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("FIND_BY_GENRE");
        requestCatalog.setGenre(genre);
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        if (responseCatalog.getStatus() == 1) {
            printCatalogByGroup(responseCatalog);
        }
        Console console = Console.getInstance();
        console.showCatalogAction();
    }

    public void getCatalog() {
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setCommand("GET_CATALOG");
        ResponseCatalog responseCatalog = (ResponseCatalog) executeTask(requestCatalog);
        render(responseCatalog);
        if(responseCatalog.getStatus()==1) {
            printCatalog(responseCatalog);
        }
        Console console = Console.getInstance();
        console.showCatalogAction();
    }

    public void printCatalogByGroup(ResponseCatalog responseCatalog) {
        ArrayList<String> arrayList = responseCatalog.getArrayList();
        System.out.println("-------------------");
        for (String string : arrayList) {
            System.out.println(string);
        }
        System.out.println("-------------------");
    }

    public void printCatalog(ResponseCatalog responseCatalog) {
        HashMap<Type, HashSet<Catalog>> hashMap = responseCatalog.getHashMap();
        System.out.println("-------------------");
        for (Map.Entry<Type, HashSet<Catalog>> entry : hashMap.entrySet()) {
            HashSet<Catalog> hashSet = entry.getValue();
            if (hashSet != null) {
                for (Catalog catalog : hashSet) {
                    System.out.println(entry.getKey().getType() + "," + catalog.getName() + "," + catalog.getGenre());
                }
            }
        }
        System.out.println("-------------------");
    }


}
