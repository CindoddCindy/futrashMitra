package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class DetailOrder extends AppCompatActivity {

    private TextView textView_tgl_order, textView_nama_food, textView_nama_cust,
    textView_lokasi_cust, textView_phone_cust, textView_shipping_type,
    textView_tdk_dikonsumsi_sejak, textView_dijual_karena, textView_berat_makanan,
    textView_nama_toko, textView_nama_penjual, textView_lokasi_makanan,
    textView_harga_makanan, textView_saran_penggunaan, textView_kandungan_kimia,
    textView_phone_number, textView_tanggal_item_di_post;

    private TextView textView_btn_konfirm, textView_btn_hbgni_customer,
    textView_btn_hapus, textView_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        textView_tgl_order=findViewById(R.id.tv_detail_order_tanggal);
        textView_nama_food=findViewById(R.id.tv_detail_order_nama_makanan);
        textView_nama_cust=findViewById(R.id.tv_detail_order_nama_customer);
        textView_lokasi_cust=findViewById(R.id.tv_detail_order_lokasi_customer);
        textView_phone_cust=findViewById(R.id.tv_detail_order_phone_customer);
        textView_shipping_type=findViewById(R.id.tv_detail_order_jenis_pengiriman);
        textView_tdk_dikonsumsi_sejak=findViewById(R.id.tv_detail_order_makanan_tidak_dikonsumsi_sejak);
        textView_dijual_karena=findViewById(R.id.tv_detail_order_diposting_karena);
        textView_berat_makanan=findViewById(R.id.tv_detail_order_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_detail_order_nama_toko);
        textView_nama_penjual=findViewById(R.id.tv_detail_order_nama_penjual);
        textView_lokasi_makanan=findViewById(R.id.tv_detail_order_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_detail_order_harga);
        textView_saran_penggunaan=findViewById(R.id.tv_detail_order_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.tv_detail_order_kandungan_kimia);
        textView_phone_number=findViewById(R.id.tv_detail_order_phone_makanan);
        textView_tanggal_item_di_post=findViewById(R.id.tv_item_detail_tanggal_item_di_post);
        textView_btn_konfirm=findViewById(R.id.tv_detail_order_btn_konfirm_order);
        textView_btn_hbgni_customer=findViewById(R.id.tv_detail_order_btn_hbngi_customer);
        textView_btn_hapus=findViewById(R.id.tv_detail_order_btn_hapus_order);
        textView_kembali=findViewById(R.id.tv_detail_order_btn_back);

        textView_btn_konfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKonfirm();
            }
        });



    }

    public void detailOrder(){


        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_nama_cust.setText(bundle.getString("cn"));
            textView_lokasi_cust.setText(bundle.getString("cl"));
            textView_phone_cust.setText(bundle.getString("cp"));
            textView_shipping_type.setText(bundle.getString("cst"));
            textView_nama_food.setText(bundle.getString("jm"));
            textView_tdk_dikonsumsi_sejak.setText(bundle.getString("tds"));
            textView_dijual_karena.setText(bundle.getString("dk"));
            textView_berat_makanan.setText(bundle.getString("bm"));
            textView_nama_toko.setText(bundle.getString("nt"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_lokasi_makanan.setText(bundle.getString("lm"));
            textView_harga_makanan.setText(bundle.getString("hm"));
            textView_saran_penggunaan.setText(bundle.getString("sp"));
            textView_kandungan_kimia.setText(bundle.getString("kk"));
            textView_phone_number.setText(bundle.getString("pn"));
            textView_tanggal_item_di_post.setText(bundle.getString("ca"));
            textView_tgl_order.setText(bundle.getString("di"));




        }


    }

    public void btnKonfirm(){
        Bundle setData = new Bundle();
        Intent toConfirmOrder = new Intent(DetailOrder.this, OrderKonfirmasi.class);
        setData.putString("ca", textView_tgl_order.getText().toString());
        setData.putString("jm", textView_nama_food.getText().toString());
        setData.putString("di", textView_tanggal_item_di_post.getText().toString());
        setData.putString("cl", textView_lokasi_cust.getText().toString());
        setData.putString("cn", textView_nama_cust.getText().toString());
        setData.putString("cp", textView_phone_cust.getText().toString());
        setData.putString("cst", textView_shipping_type.getText().toString());
        setData.putString("np", textView_nama_penjual.getText().toString());
        setData.putString("lm", textView_lokasi_makanan.getText().toString());
        setData.putString("pn", textView_phone_number.getText().toString());

        toConfirmOrder.putExtras(setData);
        startActivity(toConfirmOrder);
    }


}