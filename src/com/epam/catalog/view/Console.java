package com.epam.catalog.view;

import com.epam.catalog.controller.catalogController.CatalogController;

import java.util.Scanner;

/**
 * Created by PC on 31.01.2017.
 */
public class Console {
    private static final Console instance = new Console();
    private CatalogController catalogController = new CatalogController();

    private Console() {
    }

    public static Console getInstance() {
        return instance;
    }

    public void start() {
        catalogController.contentCatalogFromFile();
    }

    public void showCatalogAction() {
        System.out.println("Add news: 1");
        System.out.println("find news by type: 2");
        System.out.println("find news by name: 3");
        System.out.println("find news by genre: 4");
        System.out.println("Show catalog: 5");
        Scanner scanner = new Scanner(System.in);
        String request = scanner.next();
        request.trim();
        if (request.equals("1")) {
            addProductInCatalog();
        } else {
            if (request.equals("2")) {
                findProductByType();
            } else {
                if (request.equals("3")) {
                    findProductByName();
                } else {
                    if (request.equals("4")) {
                        findProductByGenre();
                    } else {
                        if (request.equals("5")) {
                            showCatalog();
                        } else {
                            System.out.println("Finish");
                        }
                    }
                }
            }
        }
    }

    public void addProductInCatalog() {
        System.out.println("Type:");
        String type = "";
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            type = scanner.next();
        }

        System.out.println("Name:");
        String name = "";
        scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            name = scanner.nextLine();
        }
        System.out.println("Genre:");
        String genre = "";
        scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            genre = scanner.nextLine();
        }
        catalogController.addNewProduct(type.trim(), name.trim(), genre.trim());
    }

    public void findProductByType() {
        System.out.println("Type:");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();

        catalogController.findByType(type.trim());
    }

    public void findProductByName() {
        System.out.println("Name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        catalogController.findByName(name.trim());
    }

    public void findProductByGenre() {
        System.out.println("Genre:");
        Scanner scanner = new Scanner(System.in);
        String genre = scanner.nextLine();

        catalogController.findByGenre(genre.trim());
    }

    public void showCatalog() {
        catalogController.getCatalog();
    }

    public void printSuccessMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
