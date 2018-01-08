package com.example.orion_stark.minutes_duplicate;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.orion_stark.minutes_duplicate.controllers.Profile_Page;
import com.example.orion_stark.minutes_duplicate.controllers.SearchBarber;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.appointment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.barber_fragment;
import com.example.orion_stark.minutes_duplicate.adapters.VpAdapter;

public class Home_Page extends AppCompatActivity {
    Toolbar myToolBar;
    ViewPager viewPager;
    VpAdapter adapter;
    TabLayout tblay;
    Button profile_btn;
    Button  search;
    private String user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        user_email = getIntent().getStringExtra("user_data");
        setComponent();
    }

    private void setComponent() {
        myToolBar = findViewById(R.id.toolbar);
        this.profile_btn = findViewById(R.id.profile_btn);
        this.search = findViewById(R.id.search_btn);
        setSupportActionBar(myToolBar);
        viewPager = findViewById(R.id.viewPager);
        tblay = findViewById(R.id.tablayOut);
        adapter = new VpAdapter(getSupportFragmentManager());
        adapter.setFragment(new barber_fragment(), "Barbers");
        adapter.setFragment(new appointment(), "Appoinment");
        viewPager.setAdapter(adapter);
        viewPager.getAdapter().notifyDataSetChanged();
        tblay.setupWithViewPager(viewPager);

        this.profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Page.this, Profile_Page.class).putExtra("user_data", user_email));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( Home_Page.this, SearchBarber.class ));
            }
        });
    }
}
