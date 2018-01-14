package com.example.orion_stark.minutes_duplicate.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.fragmentControllers.profile_fragment;
import com.example.orion_stark.minutes_duplicate.models.Appointment;
import com.example.orion_stark.minutes_duplicate.models.User;
import com.example.orion_stark.minutes_duplicate.adapters.VpAdapter;
import com.example.orion_stark.minutes_duplicate.utils.Session;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile_Page extends AppCompatActivity {
    ViewPager viewPager;
    VpAdapter adapter;
    TabLayout tblay;
    TextView username;
    CircleImageView iconProfile;
    ImageView iconEdit;
    Button signOut;
    ImageView editUsername;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        setComponent();
    }
    private void setComponent() {

        user = Session.getInstance(Profile_Page.this).getUserData();
        this.signOut = findViewById(R.id.btn_sign_out);
        this.editUsername = findViewById(R.id.icon_edit);
        username = findViewById(R.id.list_name_profile);
        username.setText(user.firstname + " " + user.lastname);
        iconProfile = findViewById(R.id.list_icon_profile);
        iconEdit = findViewById(R.id.icon_edit);

        viewPager = findViewById(R.id.viewpager1);
        tblay = findViewById(R.id.tablayOut);
        adapter = new VpAdapter(getSupportFragmentManager());
        adapter.setFragment(new profile_fragment(), "Profile");
        viewPager.setAdapter(adapter);
        tblay.setupWithViewPager(viewPager);

        this.signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getInstance(Profile_Page.this).clearSession();
                Appointment.appointments.clear();
                startActivity(new Intent(Profile_Page.this, Login_Email.class));
                finish();
            }
        });
        this.editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile_Page.this, Edit_Username.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Profile_Page.this, Home_Page.class));
        finish();
    }
}