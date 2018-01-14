package com.example.orion_stark.minutes_duplicate.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.activities.MakeAppoinment;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.RecyclerViewHolder;
import com.example.orion_stark.minutes_duplicate.activities.About;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;

/**
 * Created by evan on 28/11/17.
 *
 * Edited by orionstark
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    LayoutInflater inflater;
    View v;
    Context context;
    public RecyclerAdapter(Context context) {
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        v = inflater.inflate(R.layout.item_list_home_page, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.imgView.setBackground(v.getResources().getDrawable(BarberShop.barbers.get(position).getImgID()));
        holder.tvName.setText(BarberShop.barbers.get(position).nama);
        holder.tvStreet.setText(BarberShop.barbers.get(position).locationText);
        holder.iconView.setImageDrawable(v.getResources().getDrawable(R.drawable.barberbox_logo));
        holder.tvTime.setText(BarberShop.barbers.get(position).jamBuka.toString());
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, About.class).putExtra("barber_data_about", BarberShop.barbers.get(position).nama));
            }
        });
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity( new Intent(context, MakeAppoinment.class).putExtra("barber_data", BarberShop.barbers.get(position).nama) );
            }
        });
    }

    @Override
    public int getItemCount() {
        return BarberShop.barbers.size();
    }
}
