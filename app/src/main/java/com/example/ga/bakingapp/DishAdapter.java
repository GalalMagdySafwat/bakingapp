package com.example.ga.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DishAdapter /*extends ArrayAdapter<Dish>*/ {
 /*   private Context context;

    public DishAdapter(Context context, List<Dish> dishes) {
        super(context, 0, dishes);
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.dish_list, parent, false);
        }
        Dish currentDish = getItem(position);

        TextView n =(TextView) listItemView.findViewById(R.id.DishName);
        n.setText(currentDish.getName());
        TextView serving =(TextView) listItemView.findViewById(R.id.servings);
        serving.setText(currentDish.getServings());

        TextView ingrediant =(TextView) listItemView.findViewById(R.id.ingrediant);

        //ingrediant.setText(currentDish.getIngredients().get(position).getIngredient());
        List<Ingredients> ingredients = currentDish.getIngredients();
        StringBuffer stringBuffer = new StringBuffer();
        for (int h = 0 ;h < ingredients.size();h++) {
            stringBuffer.append(ingredients.get(h).getIngredient() + "\n");

        }
        ingrediant.setText(stringBuffer);

        TextView video =(TextView) listItemView.findViewById(R.id.VideoUrl);
        List<Steps> steps = currentDish.getSteps();
        StringBuffer sB = new StringBuffer();
        for (int g = 0 ;g < steps.size();g++) {
            sB.append(steps.get(g).getVideoURL() + "\n");

        }
        video.setText(sB);

        return listItemView;

    }*/
}