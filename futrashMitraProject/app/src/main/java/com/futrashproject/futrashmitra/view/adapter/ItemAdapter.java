package com.futrashproject.futrashmitra.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_get_item.Content;
import com.futrashproject.futrashmitra.view.DetailItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterChild> {

    public List<Content> contentList;

    public Context context;

    public ItemAdapter(Context context, List<Content>contentList){
        this.context=context;
        this.contentList=contentList;
    }


    @NonNull
    @Override
    public ItemAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ItemAdapterChild mViewHolder = new ItemAdapterChild(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_jenis_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_makanan.setText(content.getLokasiMakanan());
        holder.textView_phone_makanan.setText(content.getPhoneNumber());
        holder.textView_harga_makanan.setText(content.getHargaMakanan());

        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("first_name", datum.getFirstName());
                bundle.putString("last_name",datum.getLastName());
                bundle.putString("email",datum.getEmail());
                bundle.putString("gender",datum.getGender());
                bundle.putString("image",datum.getAvatar());
                Intent intent = new Intent(context, DetailItem.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public  class ItemAdapterChild extends RecyclerView.ViewHolder{
        private TextView textView_nama_penjual, textView_jenis_makanan, textView_phone_makanan, textView_lokasi_makanan, textView_harga_makanan;

        private ImageView imageView_item_edit, imageView_item_delete;

        private CardView cardViewItem;

        public ItemAdapterChild(@NonNull View itemView) {
            super(itemView);
            textView_nama_penjual=itemView.findViewById(R.id.tv_item_nama_penjual);
            textView_jenis_makanan=itemView.findViewById(R.id.tv_item_jenis_makanan);
            textView_phone_makanan=itemView.findViewById(R.id.tv_item_phone_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_item_lokasi);
            textView_harga_makanan=itemView.findViewById(R.id.tv_item_harga_makanan);

            cardViewItem=itemView.findViewById(R.id.cv_item_item);
        }
    }
}
