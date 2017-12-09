package com.example.orion_stark.minutes_duplicate.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.Home_Page;
import com.example.orion_stark.minutes_duplicate.R;

import java.util.regex.Pattern;

public class Login_Email extends AppCompatActivity {

    private TextView title_apps;
    private TextView desc_app;
    private EditText email_field;
    private EditText password_field;
    private Button login_btn;
    private Button register_email_btn;
    private TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_email);
        this.setprops();
    }
    private void setprops()
    {
        this.title_apps = (TextView)findViewById(R.id.title_txt);
        this.desc_app = (TextView)findViewById(R.id.desc_txt);
        this.email_field = (EditText)findViewById(R.id.email_field_login);
        this.password_field = (EditText)findViewById(R.id.password_field_login);
        this.login_btn = (Button)findViewById(R.id.login_btn);
        this.register_email_btn = (Button)findViewById(R.id.register_btn);
        this.forgot_password = (TextView)findViewById(R.id.forgot_password);

        this.forgot_password.setPaintFlags(forgot_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        this.title_apps.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/BreeSerif-Regular.ttf"));
        this.desc_app.setTypeface(Typeface.createFromAsset(getAssets(), "Font_Pack/Poppins-Medium.ttf"));
        //

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
                /*
                if(!checkField(password_field.getText().toString()))
                {
                    AlertDialog.Builder a = new AlertDialog.Builder(Login_Email.this);
                    a.setMessage("Some filed are empty, try tocheck it again");
                    a.setTitle("Something went wrong");
                    a.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    });
                    a.create();
                    a.show();
                }
                */
                startActivity(new Intent(Login_Email.this, Home_Page.class));
                finish();
            }
        });
    }

    private boolean  checkField(String password)
    {
        Pattern sec_pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,}");
        return sec_pattern.matcher(password).matches();
    }
}
