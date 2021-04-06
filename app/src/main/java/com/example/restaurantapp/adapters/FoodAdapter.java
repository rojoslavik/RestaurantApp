package com.example.restaurantapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.utils.Globalclass;
import com.example.restaurantapp.R;
import com.example.restaurantapp.models.FoodModel;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context context;
    private List<FoodModel> foodList;
    private FoodAdapter.ListItemClickListener onClick;


    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    public FoodAdapter(Context context, List<FoodModel> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.foodrecycler_layout, parent, false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodModel foodModel = foodList.get(position);
        holder.foodView.setText(foodModel.getFood().get(position));

        holder.foodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onListItemClick(position);
                foodList.get(holder.getAdapterPosition());
                Globalclass.allChoices.add(foodModel.getFood().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public static final class FoodViewHolder extends RecyclerView.ViewHolder{

        TextView foodView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodView = itemView.findViewById(R.id.foodList);

        }

    }

    public void setOnClick(ListItemClickListener onClick) {
        this.onClick = onClick;
    }
}
