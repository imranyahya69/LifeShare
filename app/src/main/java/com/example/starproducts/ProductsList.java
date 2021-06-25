package com.example.starproducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;

public class ProductsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_products_list);
        RecyclerView programmingList = (RecyclerView) findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        String[] languages = {"AL-khidmat foundation", "Hussaini blood bank", "Fatmid blood bank",
                "Sundas blood bank", "Eidhi blood bank"};
        int[] listView = new int[]{R.drawable.khidmat, R.drawable.hussaini, R.drawable.fatmid,
                R.drawable.sundas, R.drawable.eidhi, R.drawable.minhaj};
        programmingList.setAdapter(new ProgrammingAdapter(languages, listView));

    }
}