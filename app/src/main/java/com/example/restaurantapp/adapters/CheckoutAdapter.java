package com.example.restaurantapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.utils.Globalclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {

    private Context context;

    private List<String> allChoices;

    public CheckoutAdapter(Context context, List<String> allChoices) {
        this.context = context;
        this.allChoices = allChoices;
    }

    @NonNull
    @Override
    public CheckoutAdapter.CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.checkout_recycler_layout, parent, false);

        return new CheckoutAdapter.CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutAdapter.CheckoutViewHolder holder, int position) {
        String userChoices = allChoices.get(position);
        holder.foodChoiceView.setText(userChoices);
    }

    @Override
    public int getItemCount() {
        return Globalclass.allChoices.size();
    }


    public static final class CheckoutViewHolder extends RecyclerView.ViewHolder {

        TextView foodChoiceView;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);

            foodChoiceView =  itemView.findViewById(R.id.checkoutList);


        }

    }
}
