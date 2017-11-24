package com.example.orion_stark.minutes_duplicate;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;

import static com.example.orion_stark.minutes_duplicate.R.layout.welcome_page;

public class Splash_Screen extends AppCompatActivity {
    TextView title_text;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        this.title_text = (TextView)findViewById(R.id.title_text);
        this.description = (TextView)findViewById(R.id.description_text);
        this.title_text.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.description.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen.this,Welcome_Page.class));
                finish();
            }
        }, 3000);
    }
}
