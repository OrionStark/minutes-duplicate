package com.example.orion_stark.minutes_duplicate.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.User;

public class Edit_Username extends AppCompatActivity {
    /*EditText firstNameUpdate,lastNameUpdate;
    Button submit;
    private String user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_username);
        user_email = getIntent().getStringExtra("user_data");
        setComponent();
    }
    private void setComponent() {
        int count = null;
        User user = new User();
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).email.equals(user_email)) {
                user = User.users.get(i);
                count = i;
                break;
            }
        }
        firstNameUpdate = findViewById(R.id.first_name_update);
        lastNameUpdate = findViewById(R.id.last_name_update);

        this.submit = findViewById(R.id.btn_submit_updateProfile);
        final int finalCount = count;
        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.users.get(finalCount)
                startActivity(new Intent(Edit_Username.this, Profile_Page.class));
            }
        });
    }*/

}