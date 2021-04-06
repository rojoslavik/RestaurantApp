package com.example.restaurantapp.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.restaurantapp.adapters.FoodAdapter;
import com.example.restaurantapp.utils.JsonParse;
import com.example.restaurantapp.R;
import com.example.restaurantapp.models.FoodModel;

import org.json.JSONException;
import java.util.ArrayList;

import static com.example.restaurantapp.utils.JsonParse.foodList;

public class FoodActivity extends AppCompatActivity implements FoodAdapter.ListItemClickListener {

    RecyclerView foodViewRecycler;
    FoodAdapter foodAdapter;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        nextButton = findViewById(R.id.nextFood);

        setRecView(foodList);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, DrinkActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(foodList.isEmpty()) {
            try {
                JsonParse jsonParse = new JsonParse();
                jsonParse.jsonToModel(FoodActivity.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void setRecView(ArrayList<FoodModel> foodList) {
        foodViewRecycler = findViewById(R.id.FoodView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        foodViewRecycler.setLayoutManager(layoutManager);
        foodAdapter = new FoodAdapter(this, foodList);
        foodAdapter.setOnClick(FoodActivity.this);
        foodViewRecycler.setAdapter(foodAdapter);
    }

    @Override
    public void onListItemClick(int position) {

    }
}

