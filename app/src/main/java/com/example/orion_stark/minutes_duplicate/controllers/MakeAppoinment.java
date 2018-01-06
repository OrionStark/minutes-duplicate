package com.example.orion_stark.minutes_duplicate.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.Home_Page;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.Appointment;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.example.orion_stark.minutes_duplicate.models.User;

public class MakeAppoinment extends AppCompatActivity {
    Spinner time_spinner, services_spinner;
    Button submit_appointment;
    ArrayAdapter<String> array_time_Adapter;
    ArrayAdapter<String> array_services_Adapter;
    TextView nama_pangkas;
    ImageView barber_image;
    User user;
    BarberShop barber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appoinment);
        viewInit();
        AfterViewInit();
    }

    private void viewInit() {

        // View Init
        this.time_spinner = findViewById(R.id.time_spinner);
        this.services_spinner = findViewById(R.id.services_spinner);
        this.submit_appointment = findViewById(R.id.appointment_submit);
        this.barber_image = findViewById(R.id.barber_img);
        this.nama_pangkas = findViewById(R.id.nama_pangkas);
    }

    private void AfterViewInit() {
        // Get User
        String user_email = getIntent().getStringExtra("user_data");
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).email.equals(user_email)) {
                this.user = User.users.get(i);
            }
        }

        // Get Barber
        String name = getIntent().getStringExtra("barber_data");
        for (int i = 0; i < BarberShop.barbers.size(); i++) {
            if ( BarberShop.barbers.get(i).nama.equals(name) ) {
                this.barber = BarberShop.barbers.get(i);
            }
        }

        // Set Nama Pangkas
        this.nama_pangkas.setText(this.barber.nama);

        // Set Spinner Adapter
        array_time_Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                Appointment.times_avail);
        array_services_Adapter = new ArrayAdapter<String>( this, R.layout.support_simple_spinner_dropdown_item,
                Appointment.default_services);
        this.time_spinner.setAdapter(this.array_time_Adapter);
        this.services_spinner.setAdapter(this.array_services_Adapter);

        this.submit_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Appointment.appointments.add( new Appointment(barber, Appointment.times_avail[time_spinner.getSelectedItemPosition()],
                        Appointment.default_services[services_spinner.getSelectedItemPosition()]));
                startActivity(new Intent(MakeAppoinment.this, Home_Page.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MakeAppoinment.this, Home_Page.class));
        finish();
    }
}
