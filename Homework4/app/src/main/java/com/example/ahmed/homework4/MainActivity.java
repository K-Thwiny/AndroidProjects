package com.example.ahmed.homework4;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> listResult = new ArrayList<Integer>();
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String Size = editText.getText().toString();
                String Min = editText2.getText().toString();
                String Max = editText3.getText().toString();
                String Sum = editText4.getText().toString();
                runner.execute(Size, Min, Max, Sum);


            }
        });

    }



    public class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {


            int count = 0;
            String Result;
            try {
                int editText = Integer.parseInt(params[0]);
                int editText2 = Integer.parseInt(params[1]);
                int editText3 = Integer.parseInt(params[2]);
                int editText4 = Integer.parseInt(params[3]);

                Random RandomNumber = new Random();

                int[] array;
                array = new int[editText];

                for (int i = 0; i < editText; i++) {
                    array[i] = RandomNumber.nextInt((editText3 - editText2) + 1) + editText2;
                }

                for (int i = 0; i < editText; i++) {
                    for (int j = 0; j < editText; j++) {
                        for (int k = 0; k < editText; k++) {

                            if (array[i] + array[j] + array[k] == editText4) {
                                count++;
                                listResult.add(array[i]);
                                listResult.add(array[j]);
                                listResult.add(array[k]);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Result = String.valueOf(count);
            return Result;
        }

        @Override
        protected void onPostExecute(String result) {

            final int NOTIF_ID = 1111;
            NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent list=new Intent(getApplicationContext(), TripleActivity.class);
            list.putIntegerArrayListExtra("tripleList",listResult );
            PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 0, list,PendingIntent.FLAG_CANCEL_CURRENT);
            Notification note = new NotificationCompat.Builder(getApplicationContext())
                    .setContentText("There are " + result + " of sets of numbers that equal to:" + editText4)
                    .setContentTitle("Results")
                    .setSmallIcon(R.mipmap.ic_launcher).setContentIntent(intent).build();
            notifManager.notify(NOTIF_ID, note);

        }

        }
    }




