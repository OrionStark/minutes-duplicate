package com.example.orion_stark.minutes_duplicate.models;

import com.example.orion_stark.minutes_duplicate.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by orionstark on 11/24/17.
 */

public class BarberShop {
    public String nama;
    public Date jamBuka;
    public String lat, lon;
    public String desc;
    private int imgID;
    private int love;
    public String locationText;
    public String city;
    public static ArrayList<BarberShop> barbers = new ArrayList<BarberShop>() {{
        add(new BarberShop("Next BarberShop", new Date(), "3.585664", "98.689321",
                "Pangkas disini gratis seumur hidup lo", R.drawable.next_salon, "Medan Mikroskil"));
        add(new BarberShop("Prev BarberShop", new Date(), "3.58752075", "98.6906378",
                "Pangkas disini gratis seumur hidup lo", R.drawable.cut_express, "Medan Amplas"));
        add(new BarberShop("Far Away BarberShop", new Date(), "3.58792275", "98.6606318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.cut_prima, "Medan Kiamat"));
        add(new BarberShop("Man's not hot BarberShop", new Date(), "3.58772275", "95.6906318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.hunky_dory, "Medan Tengah"));
        add(new BarberShop("Big Shaq BarberShop", new Date(), "3.58752278", "98.6907318",
                "Pangkas disini gratis seumur hidup lo", R.drawable.cut_prima, "Medan Jauh"));
        add(new BarberShop("Mantpa Pangkas", new Date(), "3.549567", "98.698522",
                "Pangkas tidak gratis", R.drawable.hunky_dory, "Medan Amplas"));
    }};

    public BarberShop(String nama, Date jamBuka, String lat, String lon,
                      String desc, int locationImg, String locationText){
        this.love = 0;
        this.nama = nama;
        this.jamBuka = jamBuka;
        this.lat = lat;
        this.lon = lon;
        this.desc = desc;
        this.imgID = locationImg;
        this.locationText = locationText;
        this.city = "Medan";
    }

    public int getImgID() {
        return this.imgID;
    }

    public int getLove() {
        return this.love;
    }
}
