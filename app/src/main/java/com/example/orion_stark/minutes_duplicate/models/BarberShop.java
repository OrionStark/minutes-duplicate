package com.example.orion_stark.minutes_duplicate.models;

import java.util.Date;

/**
 * Created by orionstark on 11/24/17.
 */

public class BarberShop {
    public String nama;
    public Date jamBuka;
    private String lat, lon;
    public String desc;
    private int imgID;
    private int love;
    public String locationText;

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
    }

    public int getImgID() {
        return this.imgID;
    }

    public int getLove() {
        return this.love;
    }
}
