package com.example.restaurantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.utils.JsonParse;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapters.SideDishAdapter;
import com.example.restaurantapp.models.FoodModel;

import java.util.ArrayList;

public class SideDishActivity extends AppCompatActivity implements SideDishAdapter.ListItemClickListener {
        RecyclerView sDishViewRecycler;
        SideDishAdapter SideDishAdapter;
        Button nextButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sidedish);
            nextButton = findViewById(R.id.sDishNext);

            setRecView(JsonParse.sdishList);

            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SideDishActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        }

        private void setRecView(ArrayList<FoodModel> sDishList) {
            sDishViewRecycler = findViewById(R.id.sDishView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            sDishViewRecycler.setLayoutManager(layoutManager);
            SideDishAdapter = new SideDishAdapter(this, sDishList);
            SideDishAdapter.setOnClick(SideDishActivity.this);
            sDishViewRecycler.setAdapter(SideDishAdapter);
        }

        @Override
        public void onListItemClick(int position) {

        }
    }


