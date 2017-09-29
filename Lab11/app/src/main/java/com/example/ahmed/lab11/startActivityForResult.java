package com.example.ahmed.lab11;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class startActivityForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity_for_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    public void sendMessage(View view) {



        Intent intent = new Intent();

        EditText editText = (EditText) findViewById(R.id.editText);
        String message1 = editText.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message2 = editText2.getText().toString();

        intent.putExtra("name", message1);
        intent.putExtra("year", message2);


        setResult(RESULT_OK, intent);
        finish();
    }
}