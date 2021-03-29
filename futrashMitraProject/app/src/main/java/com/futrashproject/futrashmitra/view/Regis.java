package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class Regis extends AppCompatActivity {

    private EditText editText_name, editText_email, editText_phone, editText_password;
    private TextView textView_btn_submmit_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        editText_name=findViewById(R.id.et_regis_name);
        editText_email=findViewById(R.id.et_regis_email);
        editText_phone=findViewById(R.id.et_regis_phone);
        editText_password=findViewById(R.id.et_regis_password);

        textView_btn_submmit_regis=findViewById(R.id.tv_regis_btn_subbmit);

        textView_btn_submmit_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void subbmitRegis(){

    }
}