package com.basith.cbseapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.basith.cbseapp.Activities.Dashboard.DashboardActivity;
import com.basith.cbseapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myTask();
            }
        }, 1000);
    }



    public void myTask(){
        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(i);
    }
}