package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class Login extends AppCompatActivity {

    private EditText editText_nama, editText_password;
    private TextView textView_btn_subbmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_nama=findViewById(R.id.et_login_name);
        editText_password=findViewById(R.id.et_login_password);

        textView_btn_subbmit=findViewById(R.id.tv_login_btn_subbmit);

        textView_btn_subbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_nama.getText().toString().isEmpty() && editText_password.getText().toString().isEmpty()){
                    editText_nama.setError("nama belum diisi");
                    editText_password.setError("password belum diisi");


                }else {
                    loginMitra();


                }

            }
        });
    }

    public void loginMitra(){

    }
}