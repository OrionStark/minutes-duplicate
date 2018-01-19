package com.example.orion_stark.minutes_duplicate.activities;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;
import android.text.TextUtils;

import com.example.orion_stark.minutes_duplicate.models.Appointment;
import com.example.orion_stark.minutes_duplicate.models.User;
import com.example.orion_stark.minutes_duplicate.utils.Session;


public class Login_Email extends AppCompatActivity {

    TextView title_apps;
    TextView desc_app;
    EditText email_field;
    EditText password_field;
    Button login_btn;
    Button register_email_btn;
    TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_email);
        this.init();
    }
    private void init()
    {
        this.title_apps = findViewById(R.id.title_txt);
        this.desc_app = findViewById(R.id.desc_txt);
        this.email_field = findViewById(R.id.email_field_login);
        this.password_field = findViewById(R.id.password_field_login);
        this.login_btn = findViewById(R.id.login_btn);
        this.register_email_btn = findViewById(R.id.register_btn);
        this.forgot_password = findViewById(R.id.forgot_password);

        this.forgot_password.setPaintFlags(forgot_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        this.title_apps.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.desc_app.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));

        this.forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Email.this, ForgotPassword.class));
            }
        });
        this.register_email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Email.this, Register.class));
            }
        });
        this.login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user= new User();
                boolean isEmailExist = false;
                for (int i=0;i<User.users.size();i++) {
                    if (User.users.get(i).email.equals(email_field.getText().toString())) {
                        isEmailExist = true;
                        user = User.users.get(i);
                        break;
                    }
                }
                if (TextUtils.isEmpty(email_field.getText())) {
                    email_field.setError("Email is required");
                } else if (!isEmailExist) {
                    email_field.setError("Email is not registered.");
                } else if (TextUtils.isEmpty(password_field.getText())) {
                    password_field.setError("Password is required");
                }
                else if (!user.getPassword().equals(password_field.getText().toString())) {
                    password_field.setError("Password is incorrect.");
                } else {
                    Session.getInstance(Login_Email.this).createSession(user);
                    if (Appointment.appointments.size() > 0 || Appointment.appointments != null) {
                        Appointment.appointments.clear();
                        Appointment.appointments = user.appointments;
                    } else {
                        Appointment.appointments = user.appointments;
                    }
                    startActivity(new Intent(Login_Email.this, Home_Page.class));
                    finish();
                }

            }
        });
    }
}