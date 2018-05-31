package com.example.ga.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DishRecyclerAdapter extends RecyclerView.Adapter<DishRecyclerAdapter.ViewHolder> {
    private List<Dish> dishList;
    private Context context;

    public DishRecyclerAdapter(List<Dish> dishList, Context context) {
        this.dishList = dishList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Dish dish = dishList.get(position);
        String dName = dish.getName();
        holder.dishName.setText(dName);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DishDetails.class);
                intent.putExtra("selectedDish",dish);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView dishName;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            dishName = itemView.findViewById(R.id.DishName);
            linearLayout = itemView.findViewById(R.id.LinearLayout);
        }
    }
    public void clear() {
        int size = getItemCount();
        this.dishList.clear();
        notifyItemRangeRemoved(0, size);
    }


    public void addAll(List<Dish> dishes) {
        this.dishList.addAll(dishes);
        notifyDataSetChanged();
    }

    public Dish getItem(int position) {
        return dishList.get(position);
    }
}
