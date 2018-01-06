package com.example.orion_stark.minutes_duplicate.controllers;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.aboutUs_fragment_items;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.example.orion_stark.minutes_duplicate.models.VpAdapter;

public class About extends AppCompatActivity {
    VpAdapter adapter;
    Toolbar toolbar;
    TabLayout tl;
    ViewPager vp;
    ImageView img_pangkas;
    AppBarLayout bar_Layout;
    BarberShop barber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
        setComponents();
    }

    private void setComponents() {
        vp = findViewById(R.id.viewpager);
        adapter = new VpAdapter(getSupportFragmentManager());
        toolbar = findViewById(R.id.toolbar);
        this.img_pangkas = findViewById(R.id.img_pangkasnya);
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

    public void initView() {
        this.img_pangkas = findViewById(R.id.img_pangkasnya);
        this.bar_Layout = findViewById(R.id.bar_layout);
        afterViewInit();
    }

    private void afterViewInit(){
        for ( int i = 0; i < BarberShop.barbers.size(); i++ ) {
            if (BarberShop.barbers.get(i).nama.equals(getIntent().getStringExtra("barber_data_about"))) {
                this.barber = BarberShop.barbers.get(i);
                break;
            }
        }
        setTitle(this.barber.nama);
        this.img_pangkas.setImageDrawable(getResources().getDrawable(barber.getImgID()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
