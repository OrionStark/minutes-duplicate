package com.example.orion_stark.minutes_duplicate.models;

import java.util.ArrayList;

/**
 * Created by orionstark on 11/24/17.
 */
public class User {
    public int id;
    public String email;
    public String password;
    private String firstname;
    private String lastname;
    private String notelp;

    public static ArrayList<User> users = new ArrayList<>();

    public  User()
    {}
    public User(String firstname,String lastname,String email,String password,String notelp){
        this.firstname=firstname;
        this.lastname=lastname;
        this.password=password;
        this.email= email;
        this.notelp=notelp;
    }

    public String getPassword(){
        return password;
    }

}