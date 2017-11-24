package com.example.orion_stark.minutes_duplicate.controllers;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orion_stark.minutes_duplicate.R;

public class Register extends AppCompatActivity {

    private Toolbar toolbar;
    private Button signup_btn;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private EditText phoneNumber;
    private EditText password_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setNavIcon();
        setProps();
    }

    private void setNavIcon(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.toolbar.setNavigationIcon(R.drawable.back_arrow);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
    private void setProps(){
        this.signup_btn = (Button)findViewById(R.id.signup_btn);
        this.firstName = (EditText)findViewById(R.id.first_name_field);
        this.lastName = (EditText)findViewById(R.id.last_name_field);
        this.email = (EditText)findViewById(R.id.email_field);
        this.phoneNumber = (EditText)findViewById(R.id.phone_number);
        this.password = (EditText)findViewById(R.id.password_field);
        this.password_confirm = (EditText)findViewById(R.id.retype_password_field);

        this.signup_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
