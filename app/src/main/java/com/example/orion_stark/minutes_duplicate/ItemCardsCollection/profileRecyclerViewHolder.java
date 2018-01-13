package com.example.orion_stark.minutes_duplicate.ItemCardsCollection;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by evan on 12/12/17.
 */

public class profileRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textProfile;
    public ImageView imgIcon;
    public profileRecyclerViewHolder(View itemView){
        super(itemView);
        textProfile = itemView.findViewById(R.id.list_text_profile_frag);
        imgIcon = itemView.findViewById(R.id.list_icon_profile_frag);
    }
}