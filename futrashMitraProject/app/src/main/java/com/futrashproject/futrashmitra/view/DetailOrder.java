package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class DetailOrder extends AppCompatActivity {

    private TextView textView_nama_customer, textView_lokasi_customer, textView_nomor_telpon, textView_shipping_type,
    textView_nama_makanan, textView_nama_mitra, textView_lokasi_makanan, textView_harga_makanan;

    private TextView textView_btn_konfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        textView_nama_customer=findViewById(R.id.tv_order_detail_nama_customer);
        textView_lokasi_customer=findViewById(R.id.tv_order_detail_lokasi_customer);
        textView_nomor_telpon=findViewById(R.id.tv_order_detail_phone_customer);
        textView_shipping_type=findViewById(R.id.tv_order_detail_jenis_pengiriman);
        textView_nama_makanan=findViewById(R.id.tv_order_detail_nama_makanan);
        textView_nama_mitra=findViewById(R.id.tv_order_detail_nama_mitra);
        textView_lokasi_makanan=findViewById(R.id.tv_order_detail_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_order_detail_harga_makanan);
        textView_btn_konfirm=findViewById(R.id.tv_order_detail_btn_konfirm);


    }

    public void detailOrder(){

    }

    public void btnKonfirm(){

    }


}