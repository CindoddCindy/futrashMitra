package com.futrashproject.futrashmitra.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterChild> {


    @NonNull
    @Override
    public ItemAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ItemAdapterChild extends RecyclerView.ViewHolder{
        private TextView textView_nama_penjual, textView_jenis_makanan, textView_nama_makanan, textView_lokasi_makanan, textView_harga_makanan;

        private ImageView imageView_item_edit, imageView_item_delete;

        public ItemAdapterChild(@NonNull View itemView) {
            super(itemView);
            textView_nama_penjual=itemView.findViewById(R.id.tv_item_nama_penjual);
            textView_jenis_makanan=itemView.findViewById(R.id.tv_item_jenis_makanan);
            textView_nama_makanan=itemView.findViewById(R.id.tv_item_nama_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_item_lokasi);
            textView_harga_makanan=itemView.findViewById(R.id.tv_item_harga_makanan);
            imageView_item_edit=itemView.findViewById(R.id.iv_item_edit_item);
            imageView_item_delete=itemView.findViewById(R.id.iv_item_delete_item);
        }
    }
}
