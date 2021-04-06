package com.example.restaurantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.adapters.DrinkAdapter;
import com.example.restaurantapp.utils.JsonParse;
import com.example.restaurantapp.R;
import com.example.restaurantapp.models.FoodModel;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity implements DrinkAdapter.ListItemClickListener {
    RecyclerView drinkViewRecycler;
    DrinkAdapter drinkAdapter;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        nextButton = findViewById(R.id.drinkNext);

        setRecView(JsonParse.drinkList);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkActivity.this, SideDishActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setRecView(ArrayList<FoodModel> drinkList) {
        drinkViewRecycler = findViewById(R.id.drinkView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        drinkViewRecycler.setLayoutManager(layoutManager);
        drinkAdapter = new DrinkAdapter(this, drinkList);
        drinkAdapter.setOnClick(DrinkActivity.this);
        drinkViewRecycler.setAdapter(drinkAdapter);
    }

    @Override
    public void onListItemClick(int position) {

    }
}

