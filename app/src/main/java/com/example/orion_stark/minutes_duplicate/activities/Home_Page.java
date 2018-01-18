package com.example.orion_stark.minutes_duplicate.activities;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.appointment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.barber_fragment;
import com.example.orion_stark.minutes_duplicate.adapters.VpAdapter;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.barber_salon;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.favorite_fragment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.notifikasi;
import com.example.orion_stark.minutes_duplicate.utils.CircularAnimation;

public class Home_Page extends AppCompatActivity {
    Toolbar myToolBar;
    ViewPager viewPager;
    VpAdapter adapter;
    TabLayout tblay;
    Button profile_btn;
    Button  search;
    TabItem barbers_item, appointments_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        setComponent();
    }

    private void setComponent() {
        myToolBar = findViewById(R.id.toolbar);
        this.profile_btn = findViewById(R.id.profile_btn);
        this.search = findViewById(R.id.search_btn);
        this.barbers_item = findViewById(R.id.barbersList);
        this.appointments_item = findViewById(R.id.appoinment_list);
        setSupportActionBar(myToolBar);
        viewPager = findViewById(R.id.viewPager);
        tblay = findViewById(R.id.tablayOut);
        adapter = new VpAdapter(getSupportFragmentManager());

        // Kalau halaman love dan yang lain untuk ViewPagernya
        // Perhatikan urutan penambahannya sesuai yang ada di Minutes
        adapter.setFragment(new barber_fragment(), null);
        adapter.setFragment(new favorite_fragment(), null);
        adapter.setFragment(new appointment(), null);
        adapter.setFragment(new barber_salon(), null);
        adapter.setFragment(new notifikasi(), null);
        viewPager.setAdapter(adapter);
        viewPager.getAdapter().notifyDataSetChanged();
        tblay.setupWithViewPager(viewPager);

        // Set icon disini
        tblay.getTabAt(0).setIcon(R.drawable.home_icon_barber);
        tblay.getTabAt(1).setIcon(R.drawable.heart_white);
        tblay.getTabAt(2).setIcon(R.drawable.calendar_icon);
        tblay.getTabAt(3).setIcon(R.drawable.folder_icon);
        tblay.getTabAt(4).setIcon(R.drawable.bell_icon);

        this.profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Page.this, Profile_Page.class) );
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRevealActivity(view);
            }
        });
    }
    private void startRevealActivity(View view) {
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(Home_Page.this, SearchBarber.class);
        intent.putExtra(CircularAnimation.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(CircularAnimation.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, null);

        overridePendingTransition(0, 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
