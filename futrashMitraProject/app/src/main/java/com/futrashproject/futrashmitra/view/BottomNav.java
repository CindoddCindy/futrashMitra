package com.futrashproject.futrashmitra.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.futrashproject.futrashmitra.R;
import com.futrashproject.futrashmitra.view.fragment.FragmentAddItem;
import com.futrashproject.futrashmitra.view.fragment.FragmentConfirm;
import com.futrashproject.futrashmitra.view.fragment.FragmentItem;
import com.futrashproject.futrashmitra.view.fragment.FragmentOrder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new FragmentAddItem());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.add_item:
                        fragment = new FragmentAddItem();
                        break;

                    case R.id.list_food_trash_item:
                        fragment = new FragmentItem();
                        break;

                    case R.id.order_item:
                        fragment = new FragmentOrder();
                        break;

                    case R.id.confirm_item:
                        fragment = new FragmentConfirm();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}