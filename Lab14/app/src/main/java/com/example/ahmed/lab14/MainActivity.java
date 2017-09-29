package com.example.ahmed.lab14;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.support.v7.app.NotificationCompat.*;

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

    public void showToast(View view){

        Toast.makeText(this, "Your download has resumed.",
                Toast.LENGTH_LONG).show();
    }

    public void showAlert(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                this).create();
        alertDialog.setTitle("Alert Dialog");
        alertDialog.setMessage("Welcome to AndroidHive.info");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        // Setting OK Button
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                Toast.makeText(getApplicationContext(), "You clicked on OK",
                        Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "You clicked on No",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }



    public void showNotif(View v){
        final int NOTIF_ID = 111;
        NotificationManager notifManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        PendingIntent intent = PendingIntent.getActivity(this, 0,
                new Intent(this, GreetingActivity.class), 0);
        Notification note = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("New E-mail").setContentText("You have one unread message.").setContentIntent(intent).build();
         notifManager.notify(NOTIF_ID, note);

    }

            public void showSnackBar(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "This is the end!",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                snackbar.show();
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
        }
