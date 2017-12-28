package com.example.orion_stark.minutes_duplicate.fragmentControllers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.example.orion_stark.minutes_duplicate.models.RecyclerAdapter;
import com.example.orion_stark.minutes_duplicate.models.profileRecyclerAdapter;

import java.util.Date;

public class profile_fragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    SwipeRefreshLayout refresh;
    profileRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment, container, false);
        recyclerView = view.findViewById(R.id.profile_recycler);
        adapter = new profileRecyclerAdapter(this.recyclerView.getContext());

        return view;
    }
}
