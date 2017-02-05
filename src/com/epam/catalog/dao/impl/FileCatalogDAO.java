package com.epam.catalog.dao.impl;

import com.epam.catalog.bean.Type;
import com.epam.catalog.bean.Catalog;
import com.epam.catalog.dao.ProductDAO;
import com.epam.catalog.dao.exception.DAOException;

import java.io.*;
import java.util.*;

/**
 * Created by PC on 30.01.2017.
 */
public class FileCatalogDAO implements ProductDAO {
    private String path = "C:\\Users\\PC\\IdeaProjects\\Task_3\\input.txt";


    public FileCatalogDAO() {
    }

    @Override
    public ArrayList<String> readFile() throws DAOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new DAOException(e.getMessage(), e);
        }
        ArrayList<String> listFile = new ArrayList<>();
        String s;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                if (!s.trim().isEmpty()) {
                    listFile.add(s);
                }

            }
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e);
        }
        if (listFile.isEmpty()) {
            throw new DAOException("Input file is empty! Fill it up.");
        }
        return listFile;
    }

    @Override
    public HashMap contentCatalog(ArrayList<String> arrayList) throws DAOException {
        HashMap<Type, HashSet> hashMap = new HashMap<>();
        HashSet<Catalog> listFilms = new HashSet<>();
        HashSet<Catalog> listDisks = new HashSet<>();
        HashSet<Catalog> listBooks = new HashSet<>();
        String[] string;
        String[][] stringGoods = new String[arrayList.size()][3];
        try {
            for (int i = 0; i < arrayList.size(); i++) {
                string = arrayList.get(i).split(",");
                for (int j = 0; j < 3; j++) {
                    stringGoods[i][j] = string[j].trim();
                }
            }
            for (int i = 0; i < stringGoods.length; i++) {
                if (stringGoods[i][0].toLowerCase().equals("фильм")) {
                    listFilms.add(new Catalog(stringGoods[i][1].trim(), stringGoods[i][2].trim()));
                    hashMap.put(new Type(stringGoods[i][0].toLowerCase().trim()), listFilms);
                }
                if (stringGoods[i][0].toLowerCase().equals("диск")) {
                    listDisks.add(new Catalog(stringGoods[i][1].trim(), stringGoods[i][2].trim()));
                    hashMap.put(new Type(stringGoods[i][0].toLowerCase().trim()), listDisks);
                }
                if (stringGoods[i][0].toLowerCase().equals("книга")) {
                    listBooks.add(new Catalog(stringGoods[i][1].trim(), stringGoods[i][2].trim()));
                    hashMap.put(new Type(stringGoods[i][0].toLowerCase().trim()), listBooks);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DAOException("Incorrect input file, check the file!", e);
        }
        if (hashMap.isEmpty()) {
            throw new DAOException("Check input file.Type of news may be only: фильм, книга or диск");
        }
        return hashMap;
    }

    @Override
    public void addProduct(String type, String name, String genre) throws DAOException {
        HashMap<Type, HashSet<Catalog>> hashMap = contentCatalog(readFile());
        for (Map.Entry<Type, HashSet<Catalog>> entry : hashMap.entrySet()) {
            HashSet<Catalog> hashSet = entry.getValue();
            for (Catalog catalog : hashSet) {
                if ((entry.getKey().getType().toLowerCase().equals(type.toLowerCase())) & (catalog.getName().toLowerCase().equals(name.toLowerCase())) & (catalog.getGenre().toLowerCase().equals(genre.toLowerCase()))) {
                    throw new DAOException("This news is already  in catalog");
                }
            }
        }
        File file = new File(path);
        FileWriter fr;
        try {
            fr = new FileWriter(file, true);
            fr.write("\n");
            fr.write(type.toLowerCase() + "," + name + "," + genre);
            fr.close();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<String> findByName(String name) throws DAOException {
        HashMap<Type, HashSet<Catalog>> hashMap = contentCatalog(readFile());
        ArrayList<String> findByNameList = new ArrayList<>();
        for (Map.Entry<Type, HashSet<Catalog>> entry : hashMap.entrySet()) {
            HashSet<Catalog> list = entry.getValue();
            if (list != null) {
                for (Catalog catalog : list) {
                    if (catalog.getName().toLowerCase().equals(name.toLowerCase())) {
                        findByNameList.add(entry.getKey().getType() + "," + catalog.getName() + "," + catalog.getGenre());
                    }
                }
            }
        }
        if (findByNameList.isEmpty()) {
            throw new DAOException("Error, this name didn't find in catalog");
        }
        return findByNameList;
    }

    @Override
    public ArrayList<String> findByGenre(String genre) throws DAOException {
        HashMap<Type, HashSet<Catalog>> hashMap = contentCatalog(readFile());
        ArrayList<String> findByGenreList = new ArrayList<>();
        for (Map.Entry<Type, HashSet<Catalog>> entry : hashMap.entrySet()) {
            HashSet<Catalog> list = entry.getValue();
            if (list != null) {
                for (Catalog catalog : list) {
                    if (catalog.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                        findByGenreList.add(entry.getKey().getType() + "," + catalog.getName() + "," + catalog.getGenre());
                    }
                }
            }
        }
        if (findByGenreList.isEmpty()) {
            throw new DAOException("Error, this genre didn't find in catalog");
        }
        return findByGenreList;
    }

    @Override
    public ArrayList findByType(String type) throws DAOException {
        HashMap<Type, HashSet<Catalog>> hashMap = contentCatalog(readFile());
        ArrayList<String> findByTypeList = new ArrayList<>();
        for (Map.Entry<Type, HashSet<Catalog>> entry : hashMap.entrySet()) {
            if (entry.getKey().getType().toLowerCase().equals(type.toLowerCase())) {
                HashSet<Catalog> list = entry.getValue();
                if (list != null) {
                    for (Catalog catalog : list) {
                        findByTypeList.add(entry.getKey().getType() + "," + catalog.getName() + "," + catalog.getGenre());
                    }
                }
            }
        }
        if (findByTypeList.isEmpty()) {
            throw new DAOException("Error, this type didn't find in catalog. You can add it.");
        }
        return findByTypeList;
    }

    @Override
    public HashMap getCatalog() throws DAOException {
        HashMap<Type, HashSet<Catalog>> hashMap = contentCatalog(readFile());
        return hashMap;
    }
}
