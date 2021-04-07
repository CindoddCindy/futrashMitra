package com.futrashproject.futrashmitra.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_confirm.confirm_get.Content;

import java.util.List;

public class ConfirmAdapter extends RecyclerView.Adapter<ConfirmAdapter.ConfirmAdapterChild> {

    public List<com.futrashproject.futrashmitra.model.pojo_confirm.confirm_get.Content> contentList;
    public Context context;

    public  ConfirmAdapter(List<com.futrashproject.futrashmitra.model.pojo_confirm.confirm_get.Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }



    @NonNull
    @Override
    public ConfirmAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirmitem, parent, false);
        ConfirmAdapterChild mViewHolder = new ConfirmAdapterChild(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmAdapterChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaMitra());
        holder.textView_status_order.setText(content.getTerimaTolak());
        holder.textView_catatan_mitra.setText(content.getCatatanAlasan());
        holder.textView_tanggal_confirm.setText(content.getCreatedAt());
        holder.textView_nama_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_customer.setText(content.getLokasiCustomer());
        holder.textView_nama_customer.setText(content.getNamaCustomer());
        holder.textView_customer_phone.setText(content.getPhoneCustomer());

        holder.cardView_confirm_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



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
