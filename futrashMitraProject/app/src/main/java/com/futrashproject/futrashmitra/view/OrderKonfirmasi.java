package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class OrderKonfirmasi extends AppCompatActivity {
   private TextView textView_tanggal_order, textView_nama_makanan, textView_tanggal_makanan_post, textView_lokasi_customer, textView_nama_customer,
    textView_phone_customer, textView_shipping_type, textView_confirmation_btn_order;

   private EditText editText_nama_penjual, editText_lokasi_makanan, editText_nomor_telepon, editText_terima_tolak, editText_catatan_mitra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_konfirmasi);
        textView_tanggal_order=findViewById(R.id.tv_confirm_activity_date_order);
        textView_nama_makanan=findViewById(R.id.tv_confirm_activity_jenis_makanan);
        textView_tanggal_makanan_post=findViewById(R.id.tv_confirm_activity_date_item);
        textView_lokasi_customer=findViewById(R.id.tv_confirm_activity_customer_location);
        textView_nama_customer=findViewById(R.id.tv_confirm_activity_cutomer_name);
        textView_phone_customer=findViewById(R.id.tv_confirm_item_phone_customer);
        textView_shipping_type=findViewById(R.id.tv_confirm_activity_jenis_pengiriman);
        textView_confirmation_btn_order=findViewById(R.id.tv_confirm_activity_btn_konfirm_order);

        editText_nama_penjual=findViewById(R.id.et_confirm_activity_nama_penjual);
        editText_lokasi_makanan=findViewById(R.id.et_confirm_activity_lokasi_makanan);
        editText_nomor_telepon=findViewById(R.id.et_confirm_activity_phone_mitra);
        editText_terima_tolak=findViewById(R.id.et_confirm_activity_terima_tolak);
        editText_catatan_mitra=findViewById(R.id.et_confirm_activity_catatan_mitra);

        textView_confirmation_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void confirmOder(){

    }

    public void getDataOrder(){

        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_tanggal_order.setText(bundle.getString("ca"));
            textView_nama_makanan.setText(bundle.getString("jm"));
            textView_tanggal_makanan_post.setText(bundle.getString("di"));
            textView_lokasi_customer.setText(bundle.getString("cl"));
            textView_nama_customer.setText(bundle.getString("cn"));
            textView_phone_customer.setText(bundle.getString("cp"));
            textView_shipping_type.setText(bundle.getString("cst"));
            editText_nama_penjual.setText(bundle.getString("np"));
            editText_lokasi_makanan.setText(bundle.getString("lm"));
            editText_nomor_telepon.setText(bundle.getString("pn"));




        }

    }
}