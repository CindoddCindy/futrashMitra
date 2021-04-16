package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_get_item.Content;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_get_item.FoodTrashMitraGetItemRespon;
import com.futrashproject.futrashmitra.servis.MethodsFactory;
import com.futrashproject.futrashmitra.servis.RetrofitHandle;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;
import com.futrashproject.futrashmitra.view.adapter.ItemAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailItem extends AppCompatActivity {
    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak, textView_dijual_karena, textView_phone_numb,
    textView_berat_makanan, textView_nama_toko, textView_nama_penjual, textView_lokasi_makanan,
    textView_harga_makanan, textView_saran_penggunaan, textView_kandungan_kimia, textView_tanggal_post_makanan,
    textView_btn_tambah_product, textView_btn_edit_product, textView_btn_hapus_product;

    private SpHandle spHandle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        textView_jenis_makanan=findViewById(R.id.tv_item_detail_nama_makanan);
        textView_tidak_dikonsumsi_sejak=findViewById(R.id.tv_item_detail_tidak_dikonsumsi);
        textView_dijual_karena=findViewById(R.id.tv_item_detail_post_karena);
        textView_berat_makanan=findViewById(R.id.tv_item_detail_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_item_detail_nama_toko);
        textView_nama_penjual=findViewById(R.id.tv_item_detail_nama_penjual);
        textView_lokasi_makanan=findViewById(R.id.tv_item_detail_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_item_detail_harga);
        textView_saran_penggunaan=findViewById(R.id.tv_item_detail_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.tv_item_detail_kandungan_kimia);
        textView_tanggal_post_makanan=findViewById(R.id.tv_item_detail_tanggal_item_di_post);
        textView_btn_tambah_product=findViewById(R.id.tv_item_detail_btn_tambah_item);
        textView_btn_edit_product=findViewById(R.id.tv_item_detail_btn_edit);
        textView_btn_hapus_product=findViewById(R.id.tv_item_detail_btn_hapus);
        textView_phone_numb=findViewById(R.id.id_tv_item_detail_nomor_telepon);
        textView_tanggal_post_makanan = findViewById(R.id.tv_item_detail_tanggal_item_di_post);

        spHandle=new SpHandle(DetailItem.this);

        textView_btn_tambah_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailItem.this, BottomNav.class);
                startActivity(intent);
                finish();

            }
        });

        textView_btn_edit_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailItem.this, EditProductActivity.class);
                startActivity(intent);
                finish();



            }
        });

        textView_btn_hapus_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getDetail();


    }

    public void addItem(){

    }

    public void getDetail(){


        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            spHandle.setSpIdItem(SpHandle.SP_ID_ITEM, bundle.getLong("id_item"));
            textView_jenis_makanan.setText(bundle.getString("jm"));
            textView_tidak_dikonsumsi_sejak.setText(bundle.getString("tds"));
            textView_dijual_karena.setText(bundle.getString("dk"));
            textView_berat_makanan.setText(bundle.getString("bm"));
            textView_nama_toko.setText(bundle.getString("nt"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_lokasi_makanan.setText(bundle.getString("lm"));
            textView_harga_makanan.setText(bundle.getString("hm"));
            textView_saran_penggunaan.setText(bundle.getString("sp"));
            textView_kandungan_kimia.setText(bundle.getString("kk"));
            textView_tanggal_post_makanan.setText(bundle.getString("ca"));
            textView_phone_numb.setText(bundle.getString("pn"));
            textView_tanggal_post_makanan.setText(bundle.getString("ca"));




        }



    }

    public void editItem(){
        Bundle bundle = new Bundle();
        bundle.putLong("id_item",spHandle.getSpIdItem());
        bundle.putString("jm", textView_jenis_makanan.getText().toString());
        bundle.putString("tds",textView_tidak_dikonsumsi_sejak.getText().toString());
        bundle.putString("dk",textView_dijual_karena.getText().toString());
        bundle.putString("bm",textView_berat_makanan.getText().toString());
        bundle.putString("nt",textView_nama_toko.getText().toString());
        bundle.putString("np", textView_nama_penjual.getText().toString());
        bundle.putString("lm",textView_lokasi_makanan.getText().toString());
        bundle.putString("hm",textView_harga_makanan.getText().toString());
        bundle.putString("sp",textView_saran_penggunaan.getText().toString());
        bundle.putString("kk",textView_kandungan_kimia.getText().toString());
        bundle.putString("pn",textView_phone_numb.getText().toString());
        bundle.putString("ca",textView_tanggal_post_makanan.getText().toString());


        Intent intent = new Intent(DetailItem.this, EditProductActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void hapusItem(){

    }


    public void deleteItem(){
        Long id = spHandle.getSpIdUser();
        Long idItem= spHandle.getSpIdItem();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);


     MethodsFactory   methodsFactory = RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<String> orderListCall=methodsFactory.deleteItem(id,idItem, token);
        orderListCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(DetailItem.this,"Product Di Hapus",Toast.LENGTH_LONG).show();


                }
                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(DetailItem.this, "404 not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(DetailItem.this, "500 internal server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(DetailItem.this, "401 unauthorized", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(DetailItem.this, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<String > call, Throwable t) {
                Toast.makeText(DetailItem.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}