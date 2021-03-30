package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class MyAccount extends AppCompatActivity {

    private TextView textView_name, textView_email, textView_phone, textView_password;
    private  TextView textView_edit, textView_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        textView_name=findViewById(R.id.tv_profile_name);
        textView_email=findViewById(R.id.tv_profile_email);
        textView_phone=findViewById(R.id.tv_profile_phone);
        textView_password=findViewById(R.id.tv_profile_password);
        textView_edit=findViewById(R.id.tv_profile_edit);
        textView_logout=findViewById(R.id.tv_profile_logout);

        textView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public  void getDataUser(){

    }
}