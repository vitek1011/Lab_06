package com.udacity.sandwichclub.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.sandwichclub.model.Sandwich;

import java.util.Arrays;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        System.out.println(json);

        Sandwich sandwich = gson.fromJson(json, Sandwich.class);

        return sandwich;
    }
}
