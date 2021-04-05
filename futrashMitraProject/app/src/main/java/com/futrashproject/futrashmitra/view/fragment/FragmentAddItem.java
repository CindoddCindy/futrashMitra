package com.futrashproject.futrashmitra.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.futrashproject.futrashmitra.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAddItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAddItem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText editText_jenis_makanan, editText_tidak_dikonsumsi_sejak,
    editText_dijual_karena, editText_berat_makanan, editText_nama_toko,
    editText_nama_penjual, editText_lokasi_makanan, editText_harga_makanan,
    editText_saran_penggunaan, editText_kandungan_kimia, editText_phone_number;

    private TextView textView_btn_post_item;

    public FragmentAddItem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAddItem.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAddItem newInstance(String param1, String param2) {
        FragmentAddItem fragment = new FragmentAddItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_add_item, container, false);
       editText_jenis_makanan=view.findViewById(R.id.et_add_item_jenis_makanan);
       editText_tidak_dikonsumsi_sejak=view.findViewById(R.id.et_add_item_tidak_dikonsumsi_sejak);
       editText_dijual_karena=view.findViewById(R.id.et_add_item_di_posting_karena);
       editText_berat_makanan=view.findViewById(R.id.et_add_item_berat_makanan);
       editText_nama_toko=view.findViewById(R.id.et_add_item_nama_toko);
       editText_nama_penjual=view.findViewById(R.id.et_add_item_nama_penjual);
       editText_lokasi_makanan=view.findViewById(R.id.et_add_item_lokasi_makanan);
       editText_harga_makanan=view.findViewById(R.id.et_add_item_harga_makanan);
       editText_saran_penggunaan=view.findViewById(R.id.et_add_item_saran_penggunaan);
       editText_kandungan_kimia=view.findViewById(R.id.et_add_item_kandungan_kimia);
       editText_phone_number=view.findViewById(R.id.et_add_item_phone_number);

       textView_btn_post_item=view.findViewById(R.id.tv_add_item_btn_subbmit_makanan);

       textView_btn_post_item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(editText_jenis_makanan.getText().toString().isEmpty()&&editText_tidak_dikonsumsi_sejak.getText().toString().isEmpty()&& editText_dijual_karena.getText().toString().isEmpty()&&editText_berat_makanan.getText().toString().isEmpty() && editText_nama_toko.getText().toString().isEmpty()&&editText_nama_penjual.getText().toString().isEmpty()&&editText_lokasi_makanan.getText().toString().isEmpty()&& editText_harga_makanan.getText().toString().isEmpty()&&editText_saran_penggunaan.getText().toString().isEmpty()&&editText_kandungan_kimia.getText().toString().isEmpty()&&editText_phone_number.getText().toString().isEmpty()){
                   editText_jenis_makanan.setError("Field Kosong");
                   editText_tidak_dikonsumsi_sejak.setError("Field Kosong");
                   editText_dijual_karena.setError("Field Kosong");
                   editText_berat_makanan.setError("Field Kosong");
                   editText_nama_toko.setError("Field Kosong");
                   editText_nama_penjual.setError("Field Kosong");
                   editText_lokasi_makanan.setError("Field Kosong");
                   editText_harga_makanan.setError("Field Kosong");
                   editText_saran_penggunaan.setError("Field Kosong");
                   editText_kandungan_kimia.setError("Field Kosong");
                   editText_phone_number.setError("Field Kosong");


               }else {
                   postItem();


               }
           }
       });

        return  view;
    }

    public void postItem(){

    }
}