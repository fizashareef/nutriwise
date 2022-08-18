package com.example.nutriwise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        //hide or show items
        Menu menu=navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    public void setSupportActionBar(Toolbar toolbar) {
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
       switch (item.getItemId())
       {
           case R.id.nav_home:
           case R.id.nav_login:
               break;
           case R.id.nav_water:
               Intent intent=new Intent(DashBoard.this,water.class);
               startActivity(intent);
           case R.id.nav_cal:
               Intent intent1=new Intent(DashBoard.this,calory.class);
               startActivity(intent1);
               break;
           case R.id.nav_weight:
               Intent intent2=new Intent(DashBoard.this,Weight_tracker1.class);
               startActivity(intent2);
               break;
           case R.id.nav_share:
               Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
               break;
       }
       drawerLayout.closeDrawer(GravityCompat.START);
       return true;
    }
}