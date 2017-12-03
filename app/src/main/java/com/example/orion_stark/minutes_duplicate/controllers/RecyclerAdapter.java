package com.example.orion_stark.minutes_duplicate.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by evan on 28/11/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list_home_page, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {

    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            final int position = vholder.getPosition();

        }
    };

    @Override
    public int getItemCount() {
        //code dibawah hapus aja. ini supaya tidak error
        int a = 1;
        return a ;
    }
}
