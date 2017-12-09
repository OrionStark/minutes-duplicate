package com.example.orion_stark.minutes_duplicate.ItemCardsCollection;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by evan on 28/11/17.
 *
 * Edited by orionstark
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView tvName,tvOpen,tvTime,tvStreet,tvRange;
    public ImageView iconView,fav;
    public RelativeLayout imgView;
    public Button more,book;
    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.list_Barbershop);
        tvOpen = itemView.findViewById(R.id.open_close);
        tvRange = itemView.findViewById(R.id.range);
        tvTime = itemView.findViewById(R.id.time);
        tvStreet = itemView.findViewById(R.id.list_street);
        imgView = itemView.findViewById(R.id.list_img);
        iconView = itemView.findViewById(R.id.list_icon);
        fav = itemView.findViewById(R.id.btn_fav);
        more = itemView.findViewById(R.id.btn_more);
        book = itemView.findViewById(R.id.btn_book);
    }
}
