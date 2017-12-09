package com.example.orion_stark.minutes_duplicate.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by evan on 28/11/17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView tvName,tvOpen,tvTime,tvStreet,tvRange;
    public ImageView iconView,fav;
    public RelativeLayout imgView;
    public Button more,book;
    public RecyclerViewHolder(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.list_Barbershop);
        tvOpen = (TextView) itemView.findViewById(R.id.open_close);
        tvRange = (TextView) itemView.findViewById(R.id.range);
        tvTime = (TextView) itemView.findViewById(R.id.time);
        tvStreet = (TextView) itemView.findViewById(R.id.list_street);
        imgView = itemView.findViewById(R.id.list_img);
        iconView = (ImageView) itemView.findViewById(R.id.list_icon);
        fav = (ImageView) itemView.findViewById(R.id.btn_fav);
        more = (Button) itemView.findViewById(R.id.btn_more);
        book = (Button) itemView.findViewById(R.id.btn_book);
    }
}
