package com.example.shahriar_vaio.mydaytodolisthabittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton toDoListButton;
    ImageButton loopButton;
    ImageButton settingsButton;
    ImageButton reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toDoListButton = findViewById(R.id.button1);
        loopButton = findViewById(R.id.button2);
        reportButton = findViewById(R.id.button3);
        settingsButton = findViewById(R.id.button4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent toDoListIntent = new Intent(Main2Activity.this, ToDoListActivity.class);
                startActivity(toDoListIntent);
                break;
            case R.id.button2:

                break;

            case R.id.button3:
                Intent reportActivityIntent = new Intent(Main2Activity.this, ReportActivity.class);
                startActivity(reportActivityIntent);
                break;
            case R.id.button4:
                Intent settingsAcivityIntent = new Intent(Main2Activity.this, SettingsActivity.class);
                startActivity(settingsAcivityIntent);
                break;
        }
    }
}
