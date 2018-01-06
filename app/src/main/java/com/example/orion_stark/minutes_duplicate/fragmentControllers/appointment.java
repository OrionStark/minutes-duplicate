package com.example.orion_stark.minutes_duplicate.fragmentControllers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.AppointmentsRecycleAdapter;


public class appointment extends Fragment {
    View view;
    RecyclerView rec_view;
    AppointmentsRecycleAdapter adapter;
    SwipeRefreshLayout refresh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appointment, container, false);
        this.refresh = view.findViewById(R.id.swipeRefresh_appointment);
        this.rec_view = view.findViewById(R.id.recycler_view_apppointment);
        adapter = new AppointmentsRecycleAdapter();
        rec_view.setAdapter(adapter);
        rec_view.setHasFixedSize(true);
        rec_view.setLayoutManager(new LinearLayoutManager( view.getContext() ));
        return view;
    }
}
