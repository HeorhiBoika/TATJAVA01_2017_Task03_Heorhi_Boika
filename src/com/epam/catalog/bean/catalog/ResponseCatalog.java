package com.epam.catalog.bean.catalog;

import com.epam.catalog.bean.Catalog;
import com.epam.catalog.bean.Response;
import com.epam.catalog.bean.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by PC on 31.01.2017.
 */
public class ResponseCatalog extends Response {

    private HashMap<Type, HashSet<Catalog>> hashMap;
    private ArrayList<String> arrayList;


    public HashMap<Type, HashSet<Catalog>> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Type, HashSet<Catalog>> hashMap) {
        this.hashMap = hashMap;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}
