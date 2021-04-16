package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_post_item.FoodTrashMitraPostItemRespon;
import com.futrashproject.futrashmitra.servis.MethodsFactory;
import com.futrashproject.futrashmitra.servis.RetrofitHandle;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProductActivity extends AppCompatActivity {

    private EditText editText_jenis_makanan, editText_tidak_dikonsumsi_sejak,
            editText_dijual_karena, editText_berat_makanan, editText_nama_toko,
            editText_nama_penjual, editText_lokasi_makanan, editText_harga_makanan,
            editText_saran_penggunaan, editText_kandungan_kimia, editText_phone_number;

    private TextView textView_btn_post_item;

    private SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        editText_jenis_makanan=findViewById(R.id.et_add_item_edit_jenis_makanan);
        editText_tidak_dikonsumsi_sejak=findViewById(R.id.et_add_item_edit_tidak_dikonsumsi_sejak);
        editText_dijual_karena=findViewById(R.id.et_add_item_edit_di_posting_karena);
        editText_berat_makanan=findViewById(R.id.et_add_item_edit_berat_makanan);
        editText_nama_toko=findViewById(R.id.et_add_item_edit_nama_toko);
        editText_nama_penjual=findViewById(R.id.et_add_item_edit_nama_penjual);
        editText_lokasi_makanan=findViewById(R.id.et_add_item_edit_lokasi_makanan);
        editText_harga_makanan=findViewById(R.id.et_add_item_edit_harga_makanan);
        editText_saran_penggunaan=findViewById(R.id.et_add_item_edit_saran_penggunaan);
        editText_kandungan_kimia=findViewById(R.id.et_add_item_edit_kandungan_kimia);
        editText_phone_number=findViewById(R.id.et_add_item_edit_phone_number);

        spHandle= new SpHandle(EditProductActivity.this);

        textView_btn_post_item=findViewById(R.id.tv_add_item_edit_btn_subbmit_makanan);

        textView_btn_post_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_jenis_makanan.getText().toString().isEmpty()&&editText_tidak_dikonsumsi_sejak.getText().toString().isEmpty()&& editText_dijual_karena.getText().toString().isEmpty()&&editText_berat_makanan.getText().toString().isEmpty() && editText_nama_toko.getText().toString().isEmpty()&&editText_nama_penjual.getText().toString().isEmpty()&&editText_lokasi_makanan.getText().toString().isEmpty()&& editText_harga_makanan.getText().toString().isEmpty()&&editText_saran_penggunaan.getText().toString().isEmpty()&&editText_kandungan_kimia.getText().toString().isEmpty()&&editText_phone_number.getText().toString().isEmpty()){
                    editText_jenis_makanan.setError("Field Kosong");
                    editText_tidak_dikonsumsi_sejak.setError("Field Kosong");
                    editText_dijual_karena.setError("Field Kosong");
                    editText_berat_makanan.setError("Field Kosong");
                    editText_nama_toko.setError("Field Kosong");
                    editText_nama_penjual.setError("Field Kosong");
                    editText_lokasi_makanan.setError("Field Kosong");
                    editText_harga_makanan.setError("Field Kosong");
                    editText_saran_penggunaan.setError("Field Kosong");
                    editText_kandungan_kimia.setError("Field Kosong");
                    editText_phone_number.setError("Field Kosong");


                }else {
                    postItem();


                }
            }
        });

    }

    public void postItem(){
        String jenisMakanan= editText_jenis_makanan.getText().toString();
        String tidakDikonsumsi=editText_tidak_dikonsumsi_sejak.getText().toString();
        String dijualKarena=editText_dijual_karena.getText().toString();
        String beratMakanan=editText_berat_makanan.getText().toString();
        String namaToko=editText_nama_toko.getText().toString();
        String namaPenjual=editText_nama_penjual.getText().toString();
        String lokasiMakanan=editText_lokasi_makanan.getText().toString();
        String hargaMakanan=editText_harga_makanan.getText().toString();
        String saranPenggunaan=editText_saran_penggunaan.getText().toString();
        String kandunganKimia=editText_kandungan_kimia.getText().toString();
        String phoneNumber=editText_phone_number.getText().toString();



        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("jenis_makanan", jenisMakanan);
        jsonObject.addProperty("tidak_dikonsumsi_sejak", tidakDikonsumsi);
        jsonObject.addProperty("dijual_karena", dijualKarena);
        jsonObject.addProperty("berat_makanan", beratMakanan);
        jsonObject.addProperty("nama_toko", namaToko);
        jsonObject.addProperty("nama_penjual", namaPenjual);
        jsonObject.addProperty("lokasi_makanan", lokasiMakanan);
        jsonObject.addProperty("harga_makanan", hargaMakanan);
        jsonObject.addProperty("saran_penggunaan", saranPenggunaan);
        jsonObject.addProperty("kandungan_kimia", kandunganKimia);
        jsonObject.addProperty("phone_number", phoneNumber);


        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);




        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<FoodTrashMitraPostItemRespon> call= methodsFactory.isPostDataItem(id,token ,jsonObject);
        call.enqueue(new Callback<FoodTrashMitraPostItemRespon>() {
            @Override
            public void onResponse(Call<FoodTrashMitraPostItemRespon> call, Response<FoodTrashMitraPostItemRespon> response) {
                if(response.isSuccessful()){

                    FoodTrashMitraPostItemRespon foodTrashMitraPostItemRespon= response.body();
                    spHandle.setSpIdItem(SpHandle.SP_ID_ITEM, foodTrashMitraPostItemRespon.getId() );

                    Intent intent = new Intent(EditProductActivity.this,BottomNav.class);
                    startActivity(intent);

                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(EditProductActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(EditProductActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(EditProductActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(EditProductActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<FoodTrashMitraPostItemRespon> call, Throwable t) {
                Toast.makeText(EditProductActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });








    }
    public void getDataMakanan(){

    }

}