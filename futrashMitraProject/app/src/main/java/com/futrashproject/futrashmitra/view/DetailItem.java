package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class DetailItem extends AppCompatActivity {
    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak, textView_dijual_karena,
    textView_berat_makanan, textView_nama_toko, textView_nama_penjual, textView_lokasi_makanan,
    textView_harga_makanan, textView_saran_penggunaan, textView_kandungan_kimia, textView_catata_mitra,
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
        textView_catata_mitra=findViewById(R.id.tv_item_detail_catatan_tambahan);
        textView_btn_tambah_product=findViewById(R.id.tv_item_detail_btn_tambah_item);
        textView_btn_edit_product=findViewById(R.id.tv_item_detail_btn_edit);
        textView_btn_hapus_product=findViewById(R.id.tv_item_detail_btn_hapus);

        textView_btn_tambah_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_btn_edit_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_btn_hapus_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void addItem(){

    }

    public void getDetail(){

    }

    public void editItem(){

    }

    public void hapusItem(){

    }
}