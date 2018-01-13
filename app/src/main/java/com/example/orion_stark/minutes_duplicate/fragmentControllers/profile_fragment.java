package com.example.orion_stark.minutes_duplicate.fragmentControllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.adapters.profileRecyclerAdapter;

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
        adapter = new profileRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}