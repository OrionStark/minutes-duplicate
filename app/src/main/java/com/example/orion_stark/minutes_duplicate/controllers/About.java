package com.example.orion_stark.minutes_duplicate.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.aboutUs_fragment_items;
import com.example.orion_stark.minutes_duplicate.models.VpAdapter;

public class About extends AppCompatActivity {
    VpAdapter adapter;
    Toolbar toolbar;
    TabLayout tl;
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setComponents();
    }

    private void setComponents() {
        vp = findViewById(R.id.viewpager);
        adapter = new VpAdapter(getSupportFragmentManager());
        toolbar = findViewById(R.id.toolbar);
        tl = findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter.setFragment(new aboutUs_fragment_items(), "About Us");
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
