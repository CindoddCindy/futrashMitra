package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

public class EditConfrimActivity extends AppCompatActivity {

    private TextView textView_nama_penjual, textView_nama_makanan,textView_date_item, textView_lokasi_customer, textView_nama_customer,
            textView_phone_customer, textView_shipping_type,textView_tanggal_konfirmasi_order, textView_konfirm_terima_tidak, textView_catata_alasan, textView_edit, textView_hapus, textView_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_confrim);

        textView_nama_penjual=findViewById(R.id.tv_confirm_detail_edit_nama_penjual);
        textView_nama_makanan=findViewById(R.id.tv_confirm_detail_edit_jenis_makanan);
        textView_date_item=findViewById(R.id.tv_confirm_detail_edit_date_order);
        textView_lokasi_customer=findViewById(R.id.tv_confirm_detail_edit_location_customer);
        textView_nama_customer=findViewById(R.id.tv_confirm_detail_edit_cutomer_name);
        textView_phone_customer=findViewById(R.id.tv_confirm_detail_edit_cust_phone);
        textView_shipping_type=findViewById(R.id.tv_confirm_detail_edit_shiping_type);
        textView_tanggal_konfirmasi_order=findViewById(R.id.tv_confirm_detail_edit_tgal_confirm);
        textView_konfirm_terima_tidak=findViewById(R.id.tv_confirm_detail_edit_terima_tolak);
        textView_catata_alasan=findViewById(R.id.tv_confirm_detail_edit_catatan_alasan);
        textView_edit=findViewById(R.id.tv_confirm_detail_edit_btn_Edit);
        textView_hapus=findViewById(R.id.tv_confirm_detail_edit_btn_hapus);
        textView_back=findViewById(R.id.tv_confirm_detail_edit_btn_kembali);

    }

    public void getDataEdit(){

    }
}