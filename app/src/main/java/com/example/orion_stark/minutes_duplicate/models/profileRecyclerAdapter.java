package com.example.orion_stark.minutes_duplicate.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.profileRecyclerViewHolder;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.controllers.About;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evan on 11/12/17.
 */

public class profileRecyclerAdapter extends RecyclerView.Adapter<profileRecyclerViewHolder> {
    LayoutInflater inflater;
    View v;
    Context context;
    private List<profileData> dataProfile = new ArrayList<>();

    public void isiProfile(profileData profil) { this.dataProfile.add(profil);}
    public profileRecyclerAdapter(Context context) {inflater=LayoutInflater.from(context);
    }
    @Override
    public profileRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        v = inflater.inflate(R.layout.profile_fragment, parent, false);
        profileRecyclerViewHolder viewHolder = new profileRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(profileRecyclerViewHolder holder, int position) {
        holder.textProfile.setText(this.dataProfile.get(position).textProfileFrag);
        holder.imgIcon.setImageDrawable(v.getResources().getDrawable(R.drawable.barberbox_logo));
    }

    @Override
    public int getItemCount() {
        return this.dataProfile.size();
    }
}
