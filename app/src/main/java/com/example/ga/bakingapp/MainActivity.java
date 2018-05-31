package com.example.ga.bakingapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Dish>> {
    private DishRecyclerAdapter aAdapter;
    private RecyclerView DishListView;
    private Dish mDish;
    private static final String REQUEST_URL =
            "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    private static final int Movie_LOADER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DishListView = (RecyclerView) findViewById(R.id.List);
        DishListView.setLayoutManager(new LinearLayoutManager(this));

        aAdapter = new DishRecyclerAdapter( new ArrayList<Dish>(),this);


        DishListView.setAdapter(aAdapter);

        LoaderManager loaderManager=getLoaderManager();
        loaderManager.initLoader(Movie_LOADER_ID,null,this);

    }

    @Override
    public Loader<List<Dish>> onCreateLoader(int id, Bundle args) {
        DishLoader dishLoader = new DishLoader(this,REQUEST_URL);

        return dishLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<Dish>> loader, List<Dish> dishes) {
        aAdapter.clear();
        if (dishes != null && !dishes.isEmpty()) {
            aAdapter.addAll(dishes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Dish>> loader) {
        aAdapter.clear();

    }


}
