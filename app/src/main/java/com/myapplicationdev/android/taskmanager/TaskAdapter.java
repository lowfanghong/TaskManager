package com.myapplicationdev.android.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvName, tvDec;
    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        Task s = task.get(position);
        tvName = (TextView) rowView.findViewById(R.id.textView);
        tvName.setText(s.getName());

        tvDec = (TextView) rowView.findViewById(R.id.textView2);
        tvDec.setText(s.getDescription());

        return rowView;
    }

}
