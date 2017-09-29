package com.example.ahmed.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, startActivityForResult.class);
        startActivityForResult(intent, 0);
    }

    protected void
    onActivityResult(int requestCode, int resultCode, Intent intent) {
// Check which request we're responding to
        if (requestCode == 0) {
// Make sure the request was successful
            if (resultCode == RESULT_OK) {

                TextView displayresult = (TextView) findViewById(R.id.madlibs);


                String place = intent.getStringExtra("place");
                String celebrity = intent.getStringExtra("celebrity");
                String adjective1 = intent.getStringExtra("adjective1");
                String number1 = intent.getStringExtra("number1");
                String plural_noun = intent.getStringExtra("plural_noun");
                String adjective2 = intent.getStringExtra("adjective2");
                String food = intent.getStringExtra("food");
                String number2 = intent.getStringExtra("number2");
                String adjective3 = intent.getStringExtra("adjective3");


                displayresult.setText("We recently took a vacation to "+ place + " ! It was me, " + celebrity + ", and our kids. The suite was " + adjective1+ ", and big enough to fit a least " + number1+ " "+plural_noun+ ". We had a "+food+" "+ adjective2+ " dinner (grilled " + adjective2+ ") and then went right to sleep. we woke up after "+ number2+ " days feeling "+adjective3+"." );



            }
        }

    }

}
