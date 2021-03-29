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

                if(editText_name.getText().toString().isEmpty() && editText_name.getText().toString().isEmpty()&&editText_email.getText().toString().isEmpty()&& editText_phone.getText().toString().isEmpty()&&editText_password.getText().toString().isEmpty()){
                    editText_name.setError("nama belum diisi");
                    editText_email.setError("email belum diisi");
                    editText_phone.setError("nomor telepon belum diisi");
                    editText_password.setError("password belum diisi");


                }else {
                    subbmitRegis();


                }

            }
        });
    }

    public void subbmitRegis(){

    }
}