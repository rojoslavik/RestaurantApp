package com.example.restaurantapp.utils;

import android.content.Context;
import android.util.Log;

import com.example.restaurantapp.models.FoodModel;
import com.example.restaurantapp.utils.Utils;
import com.google.gson.Gson;

import org.json.JSONException;


import java.util.ArrayList;


public class JsonParse {

    public static ArrayList<FoodModel> foodList = new ArrayList<>();
    public static ArrayList<FoodModel> drinkList = new ArrayList<>();
    public static ArrayList<FoodModel> sdishList = new ArrayList<>();

    public void jsonToModel(Context context) throws JSONException {

        context.getApplicationContext();
        String jsonFile = Utils.loadJsonFromAssets(context, "food.json");

        Gson gson = new Gson();
        FoodModel foodModel = gson.fromJson(jsonFile, FoodModel.class);

        for(int i = 0; i < foodModel.getFood().size(); i++) {
            foodList.add(foodModel);
        }

        for(int j = 0; j < foodModel.getDrink().size(); j++) {
            drinkList.add(foodModel);
        }

        for(int k = 0; k < foodModel.getSidedish().size(); k++) {
            sdishList.add(foodModel);
        }
    }
}
