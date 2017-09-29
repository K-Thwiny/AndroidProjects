package com.example.ahmed.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent = getIntent();
        String  i= intent.getStringExtra("name");

        Toast.makeText(this, "Welcome" + i,Toast.LENGTH_LONG).show();

    }
}
