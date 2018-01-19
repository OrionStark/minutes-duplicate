package com.example.orion_stark.minutes_duplicate.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.User;
import com.example.orion_stark.minutes_duplicate.utils.Session;

public class Edit_Username extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    Button submit;
    User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_username);
        this.init();
    }
    private void init(){
        user = Session.getInstance(Edit_Username.this).getUserData();
        firstname = (EditText) findViewById(R.id.first_name_update);
        lastname= (EditText) findViewById(R.id.last_name_update);
        submit= (Button) findViewById(R.id.btn_submit_updateProfile);
        this.firstname.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.lastname.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));
        firstname.setText(user.firstname);
        lastname.setText(user.lastname);


        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.firstname= firstname.getText().toString();
                user.lastname=lastname.getText().toString();
                Session.getInstance(Edit_Username.this).createSession(user);
                startActivity(new Intent(Edit_Username.this, Profile_Page.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Edit_Username.this, Profile_Page.class));
        finish();
    }
}