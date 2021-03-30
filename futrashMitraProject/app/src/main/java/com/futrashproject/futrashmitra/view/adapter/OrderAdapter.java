package com.futrashproject.futrashmitra.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.futrashproject.futrashmitra.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAdapterChild> {

    @NonNull
    @Override
    public OrderAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapterChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderAdapterChild extends RecyclerView.ViewHolder{

        private TextView textView_name, textView_location, textView_phone, textView_shipping_type, textView_food_name;

        private CardView cardView_order_order;

        public OrderAdapterChild(@NonNull View itemView) {
            super(itemView);

            textView_name=itemView.findViewById(R.id.tv_order_cust_name);
            textView_location=itemView.findViewById(R.id.tv_order_cust_location);
            textView_phone=itemView.findViewById(R.id.tv_order_cust_phone);
            textView_shipping_type=itemView.findViewById(R.id.tv_order_cust_shipp_type);
            textView_food_name=itemView.findViewById(R.id.tv_order_nama_makanan);
            cardView_order_order=itemView.findViewById(R.id.cv_order_order);
        }
    }
}
