package com.example.orion_stark.minutes_duplicate.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.Appointment;
import com.example.orion_stark.minutes_duplicate.utils.Session;

public class Splash_Screen extends AppCompatActivity {
    TextView title_text;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        this.title_text = findViewById(R.id.title_text);
        this.description = findViewById(R.id.description_text);
        this.title_text.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.description.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Session.getInstance(Splash_Screen.this).isUserLoggedIn()) {
                    if ( Session.getInstance(Splash_Screen.this).getUserData().appointments != null ) {
                        Appointment.appointments = Session.getInstance(Splash_Screen.this).getUserData().appointments;
                    }
                    startActivity(new Intent(Splash_Screen.this, Home_Page.class));
                    finish();
                } else {
                    startActivity(new Intent(Splash_Screen.this,Welcome_Page.class));
                    finish();
                }
            }
        }, 3000);
    }
}