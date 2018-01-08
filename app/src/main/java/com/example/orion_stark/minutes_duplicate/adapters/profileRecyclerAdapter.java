package com.example.orion_stark.minutes_duplicate.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.Home_Page;
import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.profileRecyclerViewHolder;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.controllers.About;
import com.example.orion_stark.minutes_duplicate.models.User;

import java.util.ArrayList;
import java.util.List;

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
        String user_email = ((Activity) context).getIntent().getStringExtra("user_data");
        User user = new User();
        for ( int i = 0; i < User.users.size(); i++ ) {
            if ( User.users.get(i).email.equals(user_email) ) {
                user = User.users.get(i);
                break;
            }
        }
        if ( position == 0 ) {
            holder.textProfile.setText(user.email);
        } else if ( position == 1 ) {
            holder.textProfile.setText(user.notelp);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
