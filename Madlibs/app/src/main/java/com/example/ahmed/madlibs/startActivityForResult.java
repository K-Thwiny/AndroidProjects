package com.example.ahmed.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

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

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String message3 = editText3.getText().toString();

        EditText editText4 = (EditText) findViewById(R.id.editText4);
        String message4 = editText4.getText().toString();

        EditText editText5 = (EditText) findViewById(R.id.editText5);
        String message5 = editText5.getText().toString();

        EditText editText6 = (EditText) findViewById(R.id.editText6);
        String message6 = editText6.getText().toString();

        EditText editText7 = (EditText) findViewById(R.id.editText7);
        String message7 = editText7.getText().toString();

        EditText editText8 = (EditText) findViewById(R.id.editText8);
        String message8 = editText8.getText().toString();

        EditText editText9 = (EditText) findViewById(R.id.editText9);
        String message9 = editText9.getText().toString();

        intent.putExtra("place", message1);
        intent.putExtra("celebrity", message2);
        intent.putExtra("adjective1", message3);
        intent.putExtra("number1", message4);
        intent.putExtra("plural_noun", message5);
        intent.putExtra("adjective2", message6);
        intent.putExtra("food", message7);
        intent.putExtra("number2", message8);
        intent.putExtra("adjective3", message9);



        setResult(RESULT_OK, intent);
        finish();
    }

}
