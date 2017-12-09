package com.example.orion_stark.minutes_duplicate.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.controllers.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evan on 28/11/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    LayoutInflater inflater;
    View v;
    private List<BarberShop> dataPangkas = new ArrayList<>();

    public void isiPangkas(BarberShop pangkasnya) {
        this.dataPangkas.add(pangkasnya);
    }
    public RecyclerAdapter(Context context) {
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = inflater.inflate(R.layout.item_list_home_page, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.imgView.setBackground(v.getResources().getDrawable(this.dataPangkas.get(position).getImgID()));
        holder.tvName.setText(this.dataPangkas.get(position).nama);
        holder.tvStreet.setText(this.dataPangkas.get(position).locationText);
        holder.iconView.setImageDrawable(v.getResources().getDrawable(R.drawable.barberbox_logo));
        holder.tvTime.setText(this.dataPangkas.get(position).jamBuka.toString());
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
        return this.dataPangkas.size();
    }
}
