package com.example.restaurantapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodModel {

    @SerializedName("food")
    @Expose
    private List<String> food = null;
    @SerializedName("sidedish")
    @Expose
    private List<String> sidedish = null;
    @SerializedName("drink")
    @Expose
    private List<String> drink = null;


    public FoodModel() {
    }

    /**
     *
     * @param sidedish
     * @param food
     * @param drink
     */
    public FoodModel(List<String> food, List<String> sidedish, List<String> drink) {
        super();
        this.food = food;
        this.sidedish = sidedish;
        this.drink = drink;
    }

    public List<String> getFood() {
        return food;
    }

    public void setFood(List<String> food) {
        this.food = food;
    }

    public List<String> getSidedish() {
        return sidedish;
    }

    public void setSidedish(List<String> sidedish) {
        this.sidedish = sidedish;
    }

    public List<String> getDrink() {
        return drink;
    }

    public void setDrink(List<String> drink) {
        this.drink = drink;
    }

}