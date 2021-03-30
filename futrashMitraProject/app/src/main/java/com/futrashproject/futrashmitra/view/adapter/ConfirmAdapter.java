package com.futrashproject.futrashmitra.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;

public class ConfirmAdapter extends RecyclerView.Adapter<ConfirmAdapter.ConfirmAdapterChild> {

    @NonNull
    @Override
    public ConfirmAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmAdapterChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ConfirmAdapterChild extends  RecyclerView.ViewHolder{

        private TextView textView_nama_penjual, textView_terima_tolak, textView_note_penjual,
        textView_jenis_makanan, textView_lokasi_makanan, textView_nama_customer, textView_phone_customer;

        private CardView cardView_confirm_confirm;

        public ConfirmAdapterChild(@NonNull View itemView) {
            super(itemView);

            textView_nama_penjual=itemView.findViewById(R.id.tv_confirm_nama_penjual);
            textView_terima_tolak=itemView.findViewById(R.id.tv_confirm_order_terima_tolak);
            textView_note_penjual=itemView.findViewById(R.id.tv_confirm_catatan_mitra);
            textView_jenis_makanan=itemView.findViewById(R.id.tv_confirm_jenis_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_confirm_lokasi_makanan);
            textView_nama_customer=itemView.findViewById(R.id.tv_confirm_cutomer_name);
            textView_phone_customer=itemView.findViewById(R.id.tv_confirm_cust_phone);
            cardView_confirm_confirm=itemView.findViewById(R.id.cv_confirm_confirm);
        }
    }
}
