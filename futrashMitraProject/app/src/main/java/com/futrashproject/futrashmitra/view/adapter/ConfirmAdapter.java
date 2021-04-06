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

        TextView textView_nama_penjual, textView_status_order, textView_catatan_mitra, textView_tanggal_confirm,
        textView_nama_makanan, textView_lokasi_customer, textView_nama_customer, textView_customer_phone;

        private CardView cardView_confirm_confirm;

        public ConfirmAdapterChild(@NonNull View itemView) {
            super(itemView);
            textView_nama_penjual=itemView.findViewById(R.id.tv_confirm_item_nama_penjual);
            textView_status_order=itemView.findViewById(R.id.tv_confirm_item_status_order);
            textView_catatan_mitra=itemView.findViewById(R.id.tv_confirm_item_catatan_mitra);
            textView_tanggal_confirm=itemView.findViewById(R.id.tv_confirm_item_tanggal_confirm);
            textView_nama_makanan=itemView.findViewById(R.id.tv_confirm_item_jenis_makanan);
            textView_lokasi_customer=itemView.findViewById(R.id.tv_confirm_item_lokasi_customer);
            textView_nama_customer=itemView.findViewById(R.id.tv_confirm_item_cutomer_name);
            textView_customer_phone=itemView.findViewById(R.id.tv_confirm_item_phone_customer);
            cardView_confirm_confirm=itemView.findViewById(R.id.cv_confirm_confirm);
        }
    }
}
