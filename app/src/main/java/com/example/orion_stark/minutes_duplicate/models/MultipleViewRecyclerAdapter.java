package com.example.orion_stark.minutes_duplicate.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.InformationHolder;
import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.LocationHolder;
import com.example.orion_stark.minutes_duplicate.R;
import com.squareup.picasso.Picasso;

/**
 * Created by orionstark on 12/9/17.
 */

public class MultipleViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboutus_item_type1, parent, false);
            return new LocationHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboutus_item_type2, parent, false);
            return new InformationHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof LocationHolder) {
            ((LocationHolder) holder).nameLocation_space.setText("Medan, Indonesia");
            ((LocationHolder) holder).fullLocationText.setText("Jl.Thamrin, Mikroskil, Medan");
        } else if (holder instanceof InformationHolder) {
            ((InformationHolder) holder).name.setText("Pangkas Ramboo");
            ((InformationHolder) holder).phoneNumber.setText("085275061339");
            ((InformationHolder) holder).openTime.setText("10:00 AM - 10:00 PM");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
