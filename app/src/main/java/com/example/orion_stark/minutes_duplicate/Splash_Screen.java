package com.example.orion_stark.minutes_duplicate;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;

import com.example.orion_stark.minutes_duplicate.models.BarberShop;

import java.util.Date;

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
                BarberShop.barbers.add(new BarberShop("Next BarberShop", new Date(), "3.585664", "98.689321",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
                BarberShop.barbers.add(new BarberShop("Prev BarberShop", new Date(), "3.58752075", "98.6906378",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.cut_express, "Medan Amplas"));
                BarberShop.barbers.add(new BarberShop("Far Away BarberShop", new Date(), "3.58792275", "98.6606318",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.cut_prima, "Medan Kiamat"));
                BarberShop.barbers.add(new BarberShop("Man's not hot BarberShop", new Date(), "3.58772275", "95.6906318",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.hunky_dory, "Medan Tengah"));
                BarberShop.barbers.add(new BarberShop("Big Shaq BarberShop", new Date(), "3.58752278", "98.6907318",
                        "Pangkas disini gratis seumur hidup lo", R.drawable.cut_prima, "Medan Jauh"));
                BarberShop.barbers.add(new BarberShop("Mantpa Pangkas", new Date(), "3.549567", "98.698522",
                        "Pangkas tidak gratis", R.drawable.hunky_dory, "Medan Amplas"));
                startActivity(new Intent(Splash_Screen.this,Welcome_Page.class));
                finish();
            }
        }, 3000);
    }
}