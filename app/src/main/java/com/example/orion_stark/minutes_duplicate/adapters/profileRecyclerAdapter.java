package com.example.orion_stark.minutes_duplicate.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.profileRecyclerViewHolder;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.User;
import com.example.orion_stark.minutes_duplicate.utils.Session;


/**
 * Created by evan on 11/12/17.
 */

public class profileRecyclerAdapter extends RecyclerView.Adapter<profileRecyclerViewHolder> {
    View v;
    Context context;
    public profileRecyclerAdapter() {
    }
    @Override
    public profileRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        profileRecyclerViewHolder viewHolder = new profileRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(profileRecyclerViewHolder holder, final int position) {
        User user = Session.getInstance(context).getUserData();
        if ( position == 0 ) {
            holder.imgIcon.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_email));
            holder.textProfile.setText(user.email);
        } else if ( position == 1 ) {
            holder.imgIcon.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_phone));
            holder.textProfile.setText(user.notelp);
        } else if ( position == 2) {
            holder.imgIcon.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_exclamation));
            holder.textProfile.setText("Terms and Privacy Policy");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}