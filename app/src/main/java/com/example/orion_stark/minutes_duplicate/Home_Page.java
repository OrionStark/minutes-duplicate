package com.example.orion_stark.minutes_duplicate;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.orion_stark.minutes_duplicate.fragmentControllers.appointment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.barber_fragment;
import com.example.orion_stark.minutes_duplicate.models.VpAdapter;

public class Home_Page extends AppCompatActivity {
    Toolbar myToolBar;
    ViewPager viewPager;
    VpAdapter adapter;
    TabLayout tblay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        setComponent();
    }

    private void setComponent() {
        myToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);
        viewPager = findViewById(R.id.viewPager);
        tblay = findViewById(R.id.tablayOut);
        adapter = new VpAdapter(getSupportFragmentManager());
        adapter.setFragment(new barber_fragment(), "Barbers");
        adapter.setFragment(new appointment(), "Appoinment");
        viewPager.setAdapter(adapter);
        tblay.setupWithViewPager(viewPager);
    }
}
