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
import com.futrashproject.futrashmitra.model.pojo_login.FoodTrashLoginMitraRespon;
import com.futrashproject.futrashmitra.model.pojo_regis.FoodTrashRegisMitraRespon;
import com.futrashproject.futrashmitra.servis.MethodsFactory;
import com.futrashproject.futrashmitra.servis.RetrofitHandle;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText editText_nama, editText_password;
    private TextView textView_btn_subbmit;
    private SpHandle spHandle;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_nama=findViewById(R.id.et_login_name);
        editText_password=findViewById(R.id.et_login_password);


        textView_btn_subbmit=findViewById(R.id.tv_login_btn_subbmit);

        spHandle = new SpHandle(Login.this);

        if (spHandle.getHaveLogin()){
            startActivity(new Intent(Login.this, BottomNav.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

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

        String name = editText_nama.getText().toString();
        String password = editText_password.getText().toString();

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("password", password);



        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<FoodTrashLoginMitraRespon> call= methodsFactory.isLoginValid(jsonObject);
        call.enqueue(new Callback<FoodTrashLoginMitraRespon>() {
            @Override
            public void onResponse(Call<FoodTrashLoginMitraRespon> call, Response<FoodTrashLoginMitraRespon> response) {
                if(response.isSuccessful()){

                    FoodTrashLoginMitraRespon foodTrashLoginMitraRespon= response.body();


                    spHandle.setSpIdUser(SpHandle.SP_ID_USER, foodTrashLoginMitraRespon.getId());
                    spHandle.setSpTokenUser(SpHandle.SP_TOKEN_USER,foodTrashLoginMitraRespon.getAccessToken());
                    spHandle.setSpNamaMitra(SpHandle.SP_NAMA_MITRA,editText_nama.getText().toString());
                    spHandle.setSpEmailMitra(SpHandle.SP_EMAIL_MITRA,foodTrashLoginMitraRespon.getEmail());
                    spHandle.setSpPhoneMitra(SpHandle.SP_PHONE_MITRA,foodTrashLoginMitraRespon.getPhone());
                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                    spHandle.saveSPBoolean(SpHandle.SP_HAVE_LOGIN, true);
                    startActivity(new Intent(Login.this, BottomNav.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();


                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(Login.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(Login.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(Login.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(Login.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<FoodTrashLoginMitraRespon> call, Throwable t) {
                Toast.makeText(Login.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });




    }
}