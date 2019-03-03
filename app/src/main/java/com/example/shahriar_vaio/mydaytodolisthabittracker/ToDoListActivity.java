package com.example.shahriar_vaio.mydaytodolisthabittracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import maes.tech.intentanim.CustomIntent;



public class ToDoListActivity extends AppCompatActivity implements TaskInputDialog.ExampleDialogListener{

    Toolbar toolbar;
    ListView taskListView;
    private Button addButton;
    private Button saveButton;
     ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;

    String text1 = "";
    String text2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        initializeToolBar();

        taskListView = findViewById(R.id.lvDisplay);

        //arrayList = new ArrayList<>();
        loadData();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,arrayList);
        taskListView.setAdapter(arrayAdapter);


        addButton = (Button) findViewById(R.id.addButtonID);
        saveButton = (Button) findViewById(R.id.saveButtonID);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });



        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ToDoListActivity.this,"task "+ position,Toast.LENGTH_SHORT).show();



            }


        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });


    }
    public void  deleteItem(){
        SparseBooleanArray positionChecker = taskListView.getCheckedItemPositions();
        int count = taskListView.getCount();
        for (int item=count-1; item>=0; item--){
            if(positionChecker.get(item)){
                arrayAdapter.remove(arrayList.get(item));
            }
        }
        positionChecker.clear();
        arrayAdapter.notifyDataSetChanged();
        saveData();
    }




    public void openDialog(){
        TaskInputDialog taskInputDialog = new TaskInputDialog();
        taskInputDialog.show(getSupportFragmentManager(), "example dialog");
    }



    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString("task list",json);
        editor.apply();

    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        arrayList = gson.fromJson(json,type);

        if(arrayList == null){
            arrayList = new ArrayList<String>();
        }

    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this,"right-to-left");
    }

    public void initializeToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ToDoList");
    }

    @Override
    public void applyTexts(String username, String password) {
        text1 = username;
        text2 = password;
        Toast.makeText(ToDoListActivity.this,text1,Toast.LENGTH_SHORT).show();
        arrayList.add(text1);
        arrayAdapter.notifyDataSetChanged();
        saveData();
    }
}
