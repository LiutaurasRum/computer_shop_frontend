package com.computer.shop.generators;


import com.computer.shop.MainApp;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.interfaces.TestInterface;
import com.computer.shop.models.Info;
import com.google.gson.Gson;

import java.util.*;

public class InfoTableGenerator implements TestInterface{
    private final HttpRequests http;
    private final String[] manufacturersAsString = {"HP", "Dell", "Lenovo", "Apple", "Asus", "Acer", "Origin", "Razer", "Xiaomi", "VAIO"};
    private final String[] typesAsString = {"Stationary", "Laptop", "Tablet", "Desktop", "Workstation"};
    private final String[] modelAsString = {"EliteBook", "AlienWare", "ThinkPad", "Mac Book Air", "ZenBook", "Predator", "Titan", "Blade", "MiAir", "Z"};
    private final Map<Integer, String> manufacturers;
    private final List<String> types;
    private final Set<String> models;

    public InfoTableGenerator() {
        http = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
        manufacturers = getManufacturers();
        types = getTypes();
        models = getModels();
        InsertRandomInfoRecord(getGenerateMinimum(), getGenerateMaximum());
    }

    private void InsertRandomInfoRecord(final int min, final int max) {
        for (int i = 0; i < getRandomNumberInRange(min, max); i++) {
            Gson gson = new Gson();
            Info info = generateInfoModel();
            http.post("api/info", gson.toJson(info));
            System.out.println("Generated new record:" + (i + 1));
        }

    }

    private Info generateInfoModel() {
        return new Info(manufacturers.get(getRandomNumberInRange(0, manufacturers.size() - 1)),
                             getModelById(getRandomNumberInRange(0, models.size() - 1)),
                             getRandomNumberInRange(1, 1000),
                             types.get(getRandomNumberInRange(0, getTypes().size() - 1)));
    }

    private String getModelById(final int id) {
        int i = 0;
        for (String s : models) {
            i++;
            if (i == id) {
                return s;
            }
        }

        return null;
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private Map<Integer, String> getManufacturers() {
        Map<Integer, String> manufacturer = new HashMap<>();
        for (int i = 0; i < manufacturersAsString.length; i++) {
            manufacturer.put(i, manufacturersAsString[i]);
        }

        return manufacturer;
    }

    private List<String> getTypes() {
        List<String> types = new LinkedList<>();
        types.addAll(Arrays.asList(typesAsString));

        return types;
    }

    private Set<String> getModels() {
        Set<String> models = new HashSet<>();
        for (int i = 0; i < modelAsString.length; i++) {
            models.add(modelAsString[i]);
        }

        return models;
    }
}
