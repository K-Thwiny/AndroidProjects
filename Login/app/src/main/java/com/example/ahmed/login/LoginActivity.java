package com.example.ahmed.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Hashtable;


public class LoginActivity extends AppCompatActivity {

    static Hashtable<String, String> nameList= new Hashtable<>();
    EditText user;

    //Login Class
    private static class LoginManager {
        /** Is the given user name known to the system? */
        //Checks if the input is in the hashtable. If it is it will return true if not it will return false.
        public boolean isKnownUser(String name) {
            if(nameList.contains(name)){
                return true;
            }
            else
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.name);
        readTextFile(this, R.raw.names);

    }

    public void readTextFile(Context ctx, int resId) {
        InputStream inputStream = ctx.getResources().openRawResource(resId);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                //Puts the names into the HashTable
                nameList.put(line, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Welcome(View v){
        //Gets text from the EditText view
        String name = user.getText().toString();
        //Creates a new object of type LoginManager.
        LoginManager loginManager = new LoginManager();
        //Checks the input in the EditText view against the hashtable full of names.
        if(loginManager.isKnownUser(name) == false){
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, Welcome.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }
}

