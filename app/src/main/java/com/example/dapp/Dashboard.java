package com.example.dapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Dashboard extends AppCompatActivity {

    public static String uid;

    Button btnonduty, btnoffduty;

    static String time="";

    private Handler dtuhandeler = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        uid = getIntent().getStringExtra("uid");

        btnonduty = findViewById(R.id.btnonduty);
        btnoffduty = findViewById(R.id.btnoffduty);

        DboUserInfo dbuinfo = new DboUserInfo();

        btnonduty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbuinfo.setonoffduty(uid, "1");
                Intent intent = new Intent(Dashboard.this, DandTuploadservice.class);
                intent.putExtra("uid", uid);
                ContextCompat.startForegroundService(Dashboard.this,intent);
                foregroundServicesRunning();
            }
        });

        btnoffduty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbuinfo.setonoffduty(uid, "0");
                Intent intent = new Intent(Dashboard.this, DandTuploadservice.class);
                stopService(intent);
            }
        });



    }

    public boolean foregroundServicesRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)){
            if (DandTuploadservice.class.getName().equals(service.service.getClassName())){
                return true;
            }
        }
        return false;
    }


}