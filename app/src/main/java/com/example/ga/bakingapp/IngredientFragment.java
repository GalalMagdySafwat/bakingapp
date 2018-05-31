package com.example.ga.bakingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class IngredientFragment extends Fragment {
    private StepsRecyclerAdapter sAdapter;
    private RecyclerView StepListView;
    private static Dish dish;
    private List<Ingredients> mListOfIngredients;
    private List<Steps> mListOfSteps;
    private Context c;
    public IngredientFragment() {
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

        Bundle bundle =this.getArguments();
        dish = bundle.getParcelable("DISH");
        mListOfIngredients = dish.getIngredients();
        TextView textView = (TextView) rootView.findViewById(R.id.ingre);

        StringBuffer stringBuffer = new StringBuffer();
        for (int h = 0 ;h < mListOfIngredients.size();h++) {
            stringBuffer.append(mListOfIngredients.get(h).getQuantity()+" "+mListOfIngredients.get(h).getMeasure()+" "+mListOfIngredients.get(h).getIngredient() + "\n");

        }
        textView.setText(stringBuffer);
        c= getContext();

        mListOfSteps = dish.getSteps();
        StepListView =  rootView.findViewById(R.id.StepsRecycle);
        StepListView.setLayoutManager(new LinearLayoutManager(c));

        sAdapter = new StepsRecyclerAdapter( mListOfSteps,c);


        StepListView.setAdapter(sAdapter);

        return rootView;

    }

}
