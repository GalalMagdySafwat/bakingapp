package com.example.ga.bakingapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StepsRecyclerAdapter extends RecyclerView.Adapter<StepsRecyclerAdapter.ViewHolder> {
    private List<Steps> stepsList;
    private Context context ;


    public StepsRecyclerAdapter(List<Steps> stepsList, Context context) {
        this.stepsList = stepsList;
        this.context = context;
    }

    @Override
    public StepsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.steps_list,parent,false);
        return new StepsRecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final StepsRecyclerAdapter.ViewHolder holder, final int position) {
        final Steps step = stepsList.get(position);
        String dName = step.getShortDescription();
        holder.StepName.setText(dName);
/*       holder.StepLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = holder.getAdapterPosition();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return stepsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView StepName;
        public LinearLayout StepLinearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            StepName = (TextView)itemView.findViewById(R.id.Step);
            StepLinearLayout = (LinearLayout)itemView.findViewById(R.id.Step_linearLayout);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Toast.makeText(context,"clicked "+i,Toast.LENGTH_LONG).show();

        }
    }

    public void clear() {
        int size = getItemCount();
        this.stepsList.clear();
        notifyItemRangeRemoved(0, size);
    }

}
