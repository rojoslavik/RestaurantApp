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

public class SideDishAdapter extends RecyclerView.Adapter<SideDishAdapter.sDishViewHolder> {

    private Context context;
    private List<FoodModel> sdishList;
    private SideDishAdapter.ListItemClickListener onClick;


    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    public SideDishAdapter(Context context, List<FoodModel> sdishList) {
        this.context = context;
        this.sdishList = sdishList;
    }

    @NonNull
    @Override
    public SideDishAdapter.sDishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sdish_recycler_layout, parent, false);

        return new SideDishAdapter.sDishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sDishViewHolder holder, int position) {
        FoodModel foodModel = sdishList.get(position);
        holder.sdishView.setText(foodModel.getSidedish().get(position));

        holder.sdishView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onListItemClick(position);
                sdishList.get(holder.getAdapterPosition());
                Globalclass.allChoices.add(foodModel.getSidedish().get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return sdishList.size();
    }


    public static final class sDishViewHolder extends RecyclerView.ViewHolder{

        TextView sdishView;

        public sDishViewHolder(@NonNull View itemView) {
            super(itemView);

            sdishView = itemView.findViewById(R.id.sidedishList);

        }

    }

    public void setOnClick(SideDishAdapter.ListItemClickListener onClick) {
        this.onClick = onClick;
    }
}