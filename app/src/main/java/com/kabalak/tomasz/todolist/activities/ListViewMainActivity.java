package com.kabalak.tomasz.todolist.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kabalak.tomasz.todolist.R;

/**
 * Created by Wiesiek on 2016-08-16.
 */
public class ListViewMainActivity extends Activity {

    //array of options -> ArrayAdapter --> ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(android.R.layout.activity_list_item);

        populateListView();
    }

    public void populateListView(){
        String [] items = {"Blue", "Red"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.activity_list_item, items);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);



    }

    public void registerCallBack(){
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
