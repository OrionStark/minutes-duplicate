package com.example.orion_stark.minutes_duplicate.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orionstark on 11/24/17.
 * User Class
 */
public class User {
    public String email;
    private String password;
    public String firstname;
    public String lastname;
    public String notelp;
    public List<Appointment> appointments = new ArrayList<>();

    public static ArrayList<User> users = new ArrayList<User>() {{
        add(new User("Robby", "Muhammad", "robby@gmail.com", "klasifikasi", "085275061998"));
    }};

    public  User(){
    }
    public User(String firstname,String lastname,String email,String password,String notelp){
        this.firstname=firstname;
        this.lastname=lastname;
        this.password=password;
        this.email= email;
        this.notelp=notelp;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        Appointment.appointments = this.appointments;
    }

    public String getPassword(){
        return password;
    }

}