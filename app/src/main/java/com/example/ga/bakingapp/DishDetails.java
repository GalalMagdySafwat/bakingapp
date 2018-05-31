package com.example.ga.bakingapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DishDetails extends AppCompatActivity {
    private Dish selectedDish;
    private Bundle iBundle;
    private int mIngredientIndex = 0;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);
        Intent intent = getIntent();
        selectedDish=intent.getParcelableExtra("selectedDish");
        iBundle = createBundle(selectedDish);
        IngredientFragment ingredientFragment = new IngredientFragment();
        ingredientFragment.setArguments(iBundle);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.ingredient_container, ingredientFragment)
                .commit();






    }
    public Bundle createBundle(Dish dish) {
        Bundle thisBundle = new Bundle();
        thisBundle.putParcelable("DISH", dish);
        //thisBundle.putInt("INDEX", Index);
        return thisBundle;
    }
}
