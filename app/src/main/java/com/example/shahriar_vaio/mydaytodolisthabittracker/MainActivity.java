package com.example.shahriar_vaio.mydaytodolisthabittracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add custom tool bar to every activity
        // Default tool bar is set to NoActionBar
        initializeToolBar();


        // Display the Navigation Side Bar
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_to_do_list:
                Intent toDoListIntent = new Intent(MainActivity.this,ToDoListActivity.class);
                startActivity(toDoListIntent);
                CustomIntent.customType(MainActivity.this,"left-to-right");

                break;
            case R.id.nav_report:
                Intent reportIntent = new Intent(MainActivity.this,ReportActivity.class);
                startActivity(reportIntent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
                break;
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(settingsIntent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initializeToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
    }
}
