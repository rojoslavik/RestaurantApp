package com.example.restaurantapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.models.FoodModel;
import com.example.restaurantapp.utils.Globalclass;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private Context context;
    private List<FoodModel> drinkList;
    private DrinkAdapter.ListItemClickListener onClick;


    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    public DrinkAdapter(Context context, List<FoodModel> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drink_recycler_layout, parent, false);

        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        FoodModel foodModel = drinkList.get(position);
        holder.drinkView.setText(foodModel.getDrink().get(position));

        holder.drinkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onListItemClick(position);
                drinkList.get(holder.getAdapterPosition());
                Globalclass.allChoices.add(foodModel.getDrink().get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }


    public static final class DrinkViewHolder extends RecyclerView.ViewHolder {

        TextView drinkView;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);

            drinkView = itemView.findViewById(R.id.drinkList);

        }

    }

    public void setOnClick(DrinkAdapter.ListItemClickListener onClick) {
        this.onClick = onClick;
    }
}