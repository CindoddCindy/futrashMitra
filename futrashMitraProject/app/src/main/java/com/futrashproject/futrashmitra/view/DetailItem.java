package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class DetailItem extends AppCompatActivity {
    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak, textView_dijual_karena, textView_phone_numb,
    textView_berat_makanan, textView_nama_toko, textView_nama_penjual, textView_lokasi_makanan,
    textView_harga_makanan, textView_saran_penggunaan, textView_kandungan_kimia, textView_tanggal_post_makanan,
    textView_btn_tambah_product, textView_btn_edit_product, textView_btn_hapus_product;


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

    }

    public void hapusItem(){

    }
}