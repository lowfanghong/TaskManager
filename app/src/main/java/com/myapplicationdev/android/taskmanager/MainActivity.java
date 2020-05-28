package com.myapplicationdev.android.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnADDTask;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnADDTask = findViewById(R.id.button);
        lv = findViewById(R.id.lv);

        btnADDTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
        DBHelper db = new DBHelper(MainActivity.this);
        tasks= db.getTasks();

        aa = new TaskAdapter(this, R.layout.row, tasks);
        lv.setAdapter(aa);


    }
}
