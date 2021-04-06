package com.example.restaurantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantapp.R;
import com.example.restaurantapp.adapters.CheckoutAdapter;

import java.util.List;

import static com.example.restaurantapp.utils.Globalclass.allChoices;

public class CheckoutActivity extends AppCompatActivity {
    RecyclerView checkoutRecycler;
    CheckoutAdapter checkoutAdapter;
    Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        finishButton = findViewById(R.id.finishButton);

        setRecView(allChoices);


        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allChoices.clear();
                Intent intent = new Intent(CheckoutActivity.this, FoodActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void setRecView(List<String> allChoices) {
        checkoutRecycler = findViewById(R.id.checkoutView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        checkoutRecycler.setLayoutManager(layoutManager);
        checkoutAdapter = new CheckoutAdapter(this, allChoices);
        checkoutRecycler.setAdapter(checkoutAdapter);
    }
}
