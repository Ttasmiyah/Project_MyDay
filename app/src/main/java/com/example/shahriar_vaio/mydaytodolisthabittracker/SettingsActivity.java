package com.example.shahriar_vaio.mydaytodolisthabittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import maes.tech.intentanim.CustomIntent;

public class SettingsActivity extends AppCompatActivity {


    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initializeToolBar();
    }


    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this,"right-to-left");
    }

    public void initializeToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
    }
}
