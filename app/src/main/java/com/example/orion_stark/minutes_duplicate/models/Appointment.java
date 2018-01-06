package com.example.orion_stark.minutes_duplicate.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orionstark on 1/6/18.
 */

public class Appointment {
    public static final String[] times_avail = { "10:00", "11:00", "12:00", "13:00", "16:00" };
    public static final String[] default_services = { "Cukur Jembut", "Pangkas Normal", "Cuci Kemaluan", "Cuci Rambut", "Plus-plus Cukur"};
    public BarberShop barberShop;
    public String time;
    public String service;
    public static List<Appointment> appointments = new ArrayList<>();

    public Appointment( BarberShop barber, String time, String service ){
        this.barberShop = barber;
        this.time = time;
        this.service = service;
    }
}
