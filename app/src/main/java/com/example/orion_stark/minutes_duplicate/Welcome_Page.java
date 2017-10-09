package com.example.orion_stark.minutes_duplicate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Welcome_Page extends AppCompatActivity {
    private TextView title_banner;
    private TextView description;
    private Button facebook_login_btn;
    private Button gmail_login_btn;
    private Button email_login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        fillProperties();
    }

    private void fillProperties()
    {
        // Declare Widget
        this.title_banner = (TextView)findViewById(R.id.title_text);
        this.description = (TextView)findViewById(R.id.description_text);
        this.facebook_login_btn = (Button)findViewById(R.id.facebook_login);
        this.gmail_login_btn = (Button)findViewById(R.id.google_login);
        this.email_login_btn = (Button)findViewById(R.id.email_login);

        // Font Assets
        this.title_banner.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.description.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));

        // Set eventlstnr on button
        this.facebook_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        this.gmail_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        this.email_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
