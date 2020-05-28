package com.myapplicationdev.android.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;


public class AddActivity extends AppCompatActivity {
    EditText etName, etDes;
    Button btnAddTask, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
          etName =  findViewById(R.id.editText);
          etDes = findViewById(R.id.editText2);

         btnAddTask.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {



                 // Create the DBHelper object, passing in the
                 // activity's Context
                 DBHelper db = new DBHelper(AddActivity.this);

                 // Insert a task
                 db.insertTask(etName.getText().toString(), etDes.getText().toString());


                 Calendar cal = Calendar.getInstance();
                 cal.add(Calendar.SECOND, 5);
                 Intent iReminder =
                         new Intent(AddActivity.this,TaskReminderReceiver.class);

                 PendingIntent pendingIntent = PendingIntent.getBroadcast(
                         AddActivity.this, 1234,
                         iReminder, PendingIntent.FLAG_CANCEL_CURRENT);

                 AlarmManager am = (AlarmManager)
                         getSystemService(Activity.ALARM_SERVICE);
                 am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                         pendingIntent);

                 db.close();
             }
         });


    }
}
