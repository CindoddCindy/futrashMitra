package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_regis.FoodTrashRegisMitraRespon;
import com.futrashproject.futrashmitra.servis.MethodsFactory;
import com.futrashproject.futrashmitra.servis.RetrofitHandle;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Regis extends AppCompatActivity {

    private EditText editText_name, editText_email, editText_phone, editText_password;
    private TextView textView_btn_submmit_regis;
    private  SpHandle spHandle;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        editText_name=findViewById(R.id.et_regis_name);
        editText_email=findViewById(R.id.et_regis_email);
        editText_phone=findViewById(R.id.et_regis_phone);
        editText_password=findViewById(R.id.et_regis_password);

        spHandle= new SpHandle(Regis.this);

        if (spHandle.getHaveLogin()){
            startActivity(new Intent(Regis.this, Login.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        textView_btn_submmit_regis=findViewById(R.id.tv_regis_btn_subbmit);



        textView_btn_submmit_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_name.getText().toString().isEmpty()&&editText_email.getText().toString().isEmpty()&& editText_phone.getText().toString().isEmpty()&&editText_password.getText().toString().isEmpty()){
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

       String name = editText_name.getText().toString();
       String email = editText_email.getText().toString();
       String phone = editText_phone.getText().toString();
       String password = editText_password.getText().toString();

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("seller");
        jsonArray.add("user");

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("email",email );
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("password", password);
        jsonObject.add("role", jsonArray);



        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<FoodTrashRegisMitraRespon> call= methodsFactory.isRegistration(jsonObject);
        call.enqueue(new Callback<FoodTrashRegisMitraRespon>() {
            @Override
            public void onResponse(Call<FoodTrashRegisMitraRespon> call, Response<FoodTrashRegisMitraRespon> response) {
                if(response.isSuccessful()){
                    FoodTrashRegisMitraRespon foodTrashRegisMitraRespon=response.body();
                    foodTrashRegisMitraRespon.getMessage();
                    spHandle.saveSPBoolean(SpHandle.SP_HAVE_LOGIN, true);
                    startActivity(new Intent(context, Login.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(Regis.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(Regis.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(Regis.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(Regis.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<FoodTrashRegisMitraRespon> call, Throwable t) {
                Toast.makeText(Regis.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }


}