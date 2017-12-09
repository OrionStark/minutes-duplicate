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
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.example.orion_stark.minutes_duplicate.models.RecyclerAdapter;

import java.util.Date;

public class barber_fragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    SwipeRefreshLayout refresh;
    RecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.barber_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(this.recyclerView.getContext());
        adapter.isiPangkas(new BarberShop("Next BarberShop", new Date(), "3.58752275", "98.6906318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
        adapter.isiPangkas(new BarberShop("Barber Box", new Date(), "3.58752945", "98.69074378",
                "Hanya raja Salman yang boleh pangkas disini", R.drawable.barberbox, "Medan Mikroskil"));
        adapter.isiPangkas(new BarberShop("Next BarberShop", new Date(), "3.58752275", "98.6906318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
        adapter.isiPangkas(new BarberShop("Next BarberShop", new Date(), "3.58752275", "98.6906318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        setComponents();
        return view;
    }

    private void setComponents() {
        refresh = view.findViewById(R.id.swipeRefresh);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.isiPangkas(new BarberShop("Next BarberShop", new Date(), "3.58752275", "98.6906318",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
            }
        });
    }
}
