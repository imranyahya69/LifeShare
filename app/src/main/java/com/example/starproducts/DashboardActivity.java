package com.example.starproducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView userName;
    String username;
    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        username = intent.getStringExtra("name");
        TToast tToast = new TToast(this,  "DashBoard");


        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }


    public void runHome(MenuItem item) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
        TToast tToast = new TToast(this, "DashBoard");
    }

    public void runLoc(MenuItem item) {
        Intent in = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Location activity");
    }

    public void runInfo(MenuItem item) {
        Intent in = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "About activity");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void logIn(MenuItem item) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Login activity");

    }

    public void runProfile(MenuItem item) {

        Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
        in.putExtra("name", username);
        startActivity(in);
        TToast tToast = new TToast(this, "Profile activity");

    }

    public void runLogout(MenuItem item) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Logged out");


    }

    public void runLogIn(MenuItem item) {

        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Login activity");
    }

    public void runShare(MenuItem item) {
        TToast tToast = new TToast(this, "Shared");
    }


    public void runRate(MenuItem item) {
        TToast tToast = new TToast(this, "Thanks for rating * * * * *");
    }


    public void cardProducts(View view) {
        Intent in = new Intent(getApplicationContext(), ProductsList.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Products activity");


    }

    public void cardLocation(View view) {
        Intent in = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Location activity");


    }

    public void cardInfo(View view) {
        Intent in = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "About activity");


    }

    public void cardContact(View view) {
        Intent in = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(in);
        TToast tToast = new TToast(this, "Contact activity");


    }

    public void refresh(View view) {
        onRestart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }
}