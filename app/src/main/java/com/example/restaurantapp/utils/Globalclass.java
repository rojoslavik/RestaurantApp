package com.example.restaurantapp.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Globalclass {
    public static List<String> allChoices = new ArrayList<>();

    public Globalclass(List<String> allChoices) {
        this.allChoices = allChoices;

    }
}
