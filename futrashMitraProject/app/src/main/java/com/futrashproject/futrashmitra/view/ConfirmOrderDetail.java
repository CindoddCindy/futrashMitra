package com.futrashproject.futrashmitra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.shared_preference.SpHandle;

public class ConfirmOrderDetail extends AppCompatActivity {
    private TextView textView_nama_penjual, textView_nama_makanan,textView_date_item, textView_lokasi_customer, textView_nama_customer,
    textView_phone_customer, textView_shipping_type,textView_tanggal_konfirmasi_order, textView_konfirm_terima_tidak, textView_catata_alasan, textView_edit, textView_hapus, textView_back;

    private SpHandle spHandle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_detail);

        textView_nama_penjual=findViewById(R.id.tv_confirm_detail_nama_penjual);
        textView_nama_makanan=findViewById(R.id.tv_confirm_detail_jenis_makanan);
        textView_date_item=findViewById(R.id.tv_confirm_detail_date_order);
        textView_lokasi_customer=findViewById(R.id.tv_confirm_detail_location_customer);
        textView_nama_customer=findViewById(R.id.tv_confirm_detail_cutomer_name);
        textView_phone_customer=findViewById(R.id.tv_confirm_detail_cust_phone);
        textView_shipping_type=findViewById(R.id.tv_confirm_detail_shiping_type);
        textView_tanggal_konfirmasi_order=findViewById(R.id.tv_confirm_item_tanggal_confirm);
        textView_konfirm_terima_tidak=findViewById(R.id.tv_confirm_detail_terima_tolak);
        textView_catata_alasan=findViewById(R.id.tv_confirm_detail_catatan_alasan);
        textView_edit=findViewById(R.id.tv_confirm_detail_btn_Edit);
        textView_hapus=findViewById(R.id.tv_confirm_detail_btn_hapus);
        textView_back=findViewById(R.id.tv_confirm_detail_btn_kembali);

        spHandle= new SpHandle(ConfirmOrderDetail.this);

        getConfirmDetail();


    }

    public void editConfirm(){

        Bundle bundle = new Bundle();
        spHandle.setSpIdConfirm(SpHandle.SP_ID_CONFIRM_ORDER, bundle.getLong("id_confirm"));
       // bundle.putLong("id_confirm",content.getId());
        bundle.putString("nm",textView_nama_penjual.getText().toString());
        bundle.putString("tt",textView_konfirm_terima_tidak.getText().toString());
        bundle.putString("ca",textView_catata_alasan.getText().toString());
        bundle.putString("od",textView_tanggal_konfirmasi_order.getText().toString());
        bundle.putString("jm", textView_nama_makanan.getText().toString());
        bundle.putString("cl",textView_lokasi_customer.getText().toString());
        bundle.putString("cn",textView_nama_customer.getText().toString());
        bundle.putString("ct",textView_phone_customer.getText().toString());
      //  bundle.putString("cd",content.getCreatedAt());
        bundle.putString("st", textView_shipping_type.getText().toString());


        Intent intent = new Intent(ConfirmOrderDetail.this, EditConfrimActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    public void hapusConfirm(){

    }
    public void backConfirm(){

    }

    public void getConfirmDetail(){

        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();

            textView_nama_penjual.setText(bundle.getString("nm"));
            textView_konfirm_terima_tidak.setText(bundle.getString("tt"));
            textView_catata_alasan.setText(bundle.getString("ca"));
            textView_date_item.setText(bundle.getString("od"));
            textView_nama_makanan.setText(bundle.getString("jm"));
            textView_lokasi_customer.setText(bundle.getString("cl"));
            textView_nama_customer.setText(bundle.getString("cn"));
            textView_phone_customer.setText(bundle.getString("ct"));
            textView_tanggal_konfirmasi_order.setText(bundle.getString("cd"));
            textView_shipping_type.setText(bundle.getString("st"));




        }
    }
}