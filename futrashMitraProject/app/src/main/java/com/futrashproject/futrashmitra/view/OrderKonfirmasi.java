package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class OrderKonfirmasi extends AppCompatActivity {
    private TextView textView_nama_penjual, textView_nama_makanan, textView_lokasi_customer,
    textView_nama_customer, textView_phone_customer;

    private EditText editText_terima_tolak, editText_note_reason;

    private TextView textView_btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_konfirmasi);

        textView_nama_penjual=findViewById(R.id.tv_confirm_nama_penjual);
        textView_nama_makanan=findViewById(R.id.tv_confirm_jenis_makanan);
        textView_lokasi_customer=findViewById(R.id.tv_confirm_lokasi_customer);
        textView_nama_customer=findViewById(R.id.tv_confirm_cutomer_name);
        textView_phone_customer=findViewById(R.id.tv_confirm_cust_phone);
        editText_terima_tolak=findViewById(R.id.et_confirm_activity_terima_tolak);
        editText_note_reason=findViewById(R.id.et_confirm_activity_catatan_alasan);
        textView_btn_confirm=findViewById(R.id.tv_confirm_layout_btn_konfirm_order);

        textView_btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void confirmOder(){

    }
}