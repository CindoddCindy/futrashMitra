package com.futrashproject.futrashmitra.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.model.pojo_order.get_order.Content;
import com.futrashproject.futrashmitra.view.DetailItem;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAdapterChild> {

    public List<Content> contentList;
    public Context context;

    public  OrderAdapter(List<Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }


    @NonNull
    @Override
    public OrderAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout, parent, false);
        OrderAdapterChild mViewHolder = new OrderAdapterChild(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapterChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_name.setText(content.getCustomerName());
        holder.textView_food_name.setText(content.getJenisMakanan());
        holder.textView_location.setText(content.getCustomerLocation());
        holder.textView_phone.setText(content.getCustomerPhone());
        holder.textView_shipping_type.setText(content.getShippingType());
        holder.textView_date.setText(content.getCreatedAt());

        holder.textView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.cardView_order_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("cn",content.getCustomerName());
                bundle.putString("cl",content.getCustomerLocation());
                bundle.putString("cp",content.getCustomerPhone());
                bundle.putString("csp",content.getShippingType());
                bundle.putString("jm", content.getJenisMakanan());
                bundle.putString("tds",content.getTidakDikonsumsiSejak());
                bundle.putString("dk",content.getDijualKarena());
                bundle.putString("bm",content.getBeratMakanan());
                bundle.putString("nt",content.getNamaToko());
                bundle.putString("np", content.getNamaPenjual());
                bundle.putString("lm",content.getLokasiMakanan());
                bundle.putString("hm",content.getHargaMakanan());
                bundle.putString("sp",content.getSaranPenggunaan());
                bundle.putString("kk",content.getKandunganKimia());
                bundle.putString("pn",content.getPhoneNumber());
                bundle.putString("ca",content.getCreatedAt());


                Intent intent = new Intent(context, DetailItem.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderAdapterChild extends RecyclerView.ViewHolder{

        private TextView textView_name, textView_location, textView_phone, textView_shipping_type, textView_food_name,textView_date, textView_delete;

        private CardView cardView_order_order;

        public OrderAdapterChild(@NonNull View itemView) {
            super(itemView);

            textView_name=itemView.findViewById(R.id.tv_order_cust_name);
            textView_location=itemView.findViewById(R.id.tv_order_cust_location);
            textView_phone=itemView.findViewById(R.id.tv_order_cust_phone);
            textView_shipping_type=itemView.findViewById(R.id.tv_order_cust_shipp_type);
            textView_food_name=itemView.findViewById(R.id.tv_order_nama_makanan);
            textView_date=itemView.findViewById(R.id.tv_order_date_);
            textView_delete=itemView.findViewById(R.id.tv_order_delete);
            cardView_order_order=itemView.findViewById(R.id.cv_order_order);

        }
    }
}
