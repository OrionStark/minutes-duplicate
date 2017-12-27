package com.example.orion_stark.minutes_duplicate;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.fragmentControllers.appointment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.barber_fragment;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.profile_fragment;
import com.example.orion_stark.minutes_duplicate.models.VpAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile_Page extends AppCompatActivity {
    ViewPager viewPager;
    VpAdapter adapter;
    TabLayout tblay;
    TextView username;
    CircleImageView iconProfile;
    ImageView iconEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        setComponent();
    }
    private void setComponent() {
        username = findViewById(R.id.list_name_profile);
        iconProfile = findViewById(R.id.list_icon_profile);
        iconEdit = findViewById(R.id.icon_edit);

        viewPager = findViewById(R.id.viewpager1);
        tblay = findViewById(R.id.tablayOut);
        adapter = new VpAdapter(getSupportFragmentManager());
        adapter.setFragment(new profile_fragment(), "Profile");
        adapter.setFragment(new appointment(), "Appoinment");
        viewPager.setAdapter(adapter);
        tblay.setupWithViewPager(viewPager);
    }
}
