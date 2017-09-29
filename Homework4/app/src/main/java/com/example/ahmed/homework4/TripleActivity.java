package com.example.ahmed.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.ListView;

import java.util.ArrayList;


public class TripleActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Integer>listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triple);
        listView =(ListView) findViewById(R.id.list_item);
        listResult =(ArrayList<Integer>) getIntent().getSerializableExtra("tripleList");
        listView.setAdapter(new ArrayAdapter(this, R.layout.list_item, R.id.textview,listResult));
    }
}
