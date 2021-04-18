package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_confirm.edit_confirm.EditConfirmRespon;
import com.futrashproject.futrashmitra.model.pojo_confirm.post_confirm.MitraPostConfirmRespon;
import com.futrashproject.futrashmitra.servis.MethodsFactory;
import com.futrashproject.futrashmitra.servis.RetrofitHandle;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditConfrimActivity extends AppCompatActivity {

    private TextView textView_tanggal_order, textView_nama_makanan, textView_tanggal_makanan_post, textView_lokasi_customer, textView_nama_customer,
            textView_phone_customer, textView_shipping_type, textView_confirmation_btn_order;

    private EditText editText_nama_penjual, editText_lokasi_makanan, editText_nomor_telepon, editText_terima_tolak, editText_catatan_mitra;

    private SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_confrim);

        spHandle = new SpHandle(EditConfrimActivity.this);

        textView_tanggal_order=findViewById(R.id.tv_confirm_activity_edit_date_order);
        textView_nama_makanan=findViewById(R.id.tv_confirm_activity_edit_jenis_makanan);
        textView_tanggal_makanan_post=findViewById(R.id.tv_confirm_activity_edit_date_item);
        textView_lokasi_customer=findViewById(R.id.tv_confirm_activity_edit_customer_location);
        textView_nama_customer=findViewById(R.id.tv_confirm_activity_edit_cutomer_name);
        textView_phone_customer=findViewById(R.id.tv_confirm_activity_edit_cust_phone);
        textView_shipping_type=findViewById(R.id.tv_confirm_activity_edit_jenis_pengiriman);
        textView_confirmation_btn_order=findViewById(R.id.tv_confirm_activity_edit_btn_konfirm_order);

        editText_nama_penjual=findViewById(R.id.et_confirm_activity_edit_nama_penjual);
        editText_lokasi_makanan=findViewById(R.id.et_confirm_activity_edit_lokasi_makanan);
        editText_nomor_telepon=findViewById(R.id.et_confirm_activity_edit_phone_mitra);
        editText_terima_tolak=findViewById(R.id.et_confirm_activity_edit_terima_tolak);
        editText_catatan_mitra=findViewById(R.id.et_confirm_activity_edit_catatan_mitra);

        textView_confirmation_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_nama_penjual.getText().toString().isEmpty()&&editText_lokasi_makanan.getText().toString().isEmpty()&& editText_nomor_telepon.getText().toString().isEmpty()&&editText_terima_tolak.getText().toString().isEmpty()&& editText_catatan_mitra.getText().toString().isEmpty()){
                    editText_nama_penjual.setError("field kosong");
                    editText_lokasi_makanan.setError("field kosong");
                    editText_nomor_telepon.setError("field kosong");
                    editText_terima_tolak.setError("field kosong");
                    editText_catatan_mitra.setError("field kosong");


                }else {
                    metodKirim();


                }

            }
        });

        getDataEdit();

    }

    public void getDataEdit(){
        getConfirmDetail();

    }

    public void getConfirmDetail(){

        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();

            editText_nama_penjual.setText(bundle.getString("nm"));
            editText_terima_tolak.setText(bundle.getString("tt"));
            editText_catatan_mitra.setText(bundle.getString("ca"));
            textView_tanggal_order.setText(bundle.getString("od"));
            textView_nama_makanan.setText(bundle.getString("jm"));
            textView_lokasi_customer.setText(bundle.getString("cl"));
            textView_nama_customer.setText(bundle.getString("cn"));
            textView_phone_customer.setText(bundle.getString("ct"));
            textView_tanggal_makanan_post.setText(bundle.getString("cd"));
            textView_shipping_type.setText(bundle.getString("st"));




        }
    }


    public  void sendDataConfirmEditToOwnSelf(){

        String imageUrl= "imageUrl";
        String orderDate=textView_tanggal_order.getText().toString();
        String namaFood=textView_nama_makanan.getText().toString();
        String itemDate=textView_tanggal_makanan_post.getText().toString();
        String lokasiCustomer=textView_lokasi_customer.getText().toString();
        String namaCustomer=textView_nama_customer.getText().toString();
        String phoneCustomer=textView_phone_customer.getText().toString();
        String shippingType=textView_shipping_type.getText().toString();
        String namaPenjuala=editText_nama_penjual.getText().toString();
        String lokasiMakanan=editText_lokasi_makanan.getText().toString();
        String phonePenjual=editText_nomor_telepon.getText().toString();
        String terimaTolak=editText_terima_tolak.getText().toString();
        String catatanAlasan=editText_catatan_mitra.getText().toString();



        JsonObject jsonObject = new JsonObject();
        /*JsonArray jsonArray = new JsonArray();
        jsonArray.add("seller");
        jsonArray.add("user");

         */

        jsonObject.addProperty("image_url", imageUrl);
        jsonObject.addProperty("terima_tolak", terimaTolak);
        jsonObject.addProperty("catatan_alasan", catatanAlasan);
        jsonObject.addProperty("jenis_makanan", namaFood);
        jsonObject.addProperty("lokasi_customer", lokasiCustomer);
        jsonObject.addProperty("nama_customer", namaCustomer);
        jsonObject.addProperty("phone_customer", phoneCustomer);
        jsonObject.addProperty("lokasi_mitra", lokasiMakanan);
        jsonObject.addProperty("nama_mitra", namaPenjuala);
        jsonObject.addProperty("phone_mitra", phonePenjual);
        jsonObject.addProperty("item_date", itemDate);
        jsonObject.addProperty("order_date", orderDate);
        jsonObject.addProperty("shipping_type", shippingType);


        Long id = spHandle.getSpIdUser();
        Long idConfirmOwnSelf= spHandle.getSpIdConfirm();

        String tokenUser = spHandle.getSpTokenUser();

        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);



        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<EditConfirmRespon> call= methodsFactory.editConfirmToOwnSelf(id,idConfirmOwnSelf, token,jsonObject);
        call.enqueue(new Callback<EditConfirmRespon>() {
            @Override
            public void onResponse(Call<EditConfirmRespon> call, Response<EditConfirmRespon> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(EditConfrimActivity.this,BottomNav.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(EditConfrimActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(EditConfrimActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(EditConfrimActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(EditConfrimActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<EditConfirmRespon> call, Throwable t) {
                Toast.makeText(EditConfrimActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });

    }



    public void confirmOderToBuyerEdit(){

        String imageUrl= "imageUrl";
        String orderDate=textView_tanggal_order.getText().toString();
        String namaFood=textView_nama_makanan.getText().toString();
        String itemDate=textView_tanggal_makanan_post.getText().toString();
        String lokasiCustomer=textView_lokasi_customer.getText().toString();
        String namaCustomer=textView_nama_customer.getText().toString();
        String phoneCustomer=textView_phone_customer.getText().toString();
        String shippingType=textView_shipping_type.getText().toString();
        String namaPenjuala=editText_nama_penjual.getText().toString();
        String lokasiMakanan=editText_lokasi_makanan.getText().toString();
        String phonePenjual=editText_nomor_telepon.getText().toString();
        String terimaTolak=editText_terima_tolak.getText().toString();
        String catatanAlasan=editText_catatan_mitra.getText().toString();



        JsonObject jsonObject = new JsonObject();
        /*JsonArray jsonArray = new JsonArray();
        jsonArray.add("seller");
        jsonArray.add("user");

         */

        jsonObject.addProperty("image_url", imageUrl);
        jsonObject.addProperty("terima_tolak", terimaTolak);
        jsonObject.addProperty("catatan_alasan", catatanAlasan);
        jsonObject.addProperty("jenis_makanan", namaFood);
        jsonObject.addProperty("lokasi_customer", lokasiCustomer);
        jsonObject.addProperty("nama_customer", namaCustomer);
        jsonObject.addProperty("phone_customer", phoneCustomer);
        jsonObject.addProperty("lokasi_mitra", lokasiMakanan);
        jsonObject.addProperty("nama_mitra", namaPenjuala);
        jsonObject.addProperty("phone_mitra", phonePenjual);
        jsonObject.addProperty("item_date", itemDate);
        jsonObject.addProperty("order_date", orderDate);
        jsonObject.addProperty("shipping_type", shippingType);


        Long id = spHandle.getSpIdBuyerDua();
        Long idConfirmToBuyer=spHandle.getSpIdConfirm();

        String tokenUser = spHandle.getSpTokenUser();

        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);



        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<EditConfirmRespon> call= methodsFactory.editConfirm(id, idConfirmToBuyer,token,jsonObject);
        call.enqueue(new Callback<EditConfirmRespon>() {
            @Override
            public void onResponse(Call<EditConfirmRespon> call, Response<EditConfirmRespon> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(EditConfrimActivity.this,BottomNav.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(EditConfrimActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(EditConfrimActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(EditConfrimActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(EditConfrimActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<EditConfirmRespon> call, Throwable t) {
                Toast.makeText(EditConfrimActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });






    }


    public  void metodKirim(){
        confirmOderToBuyerEdit();
        sendDataConfirmEditToOwnSelf();
    }
}