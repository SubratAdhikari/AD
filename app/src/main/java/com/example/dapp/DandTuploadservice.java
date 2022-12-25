package com.example.dapp;

import static android.content.ContentValues.TAG;

import static com.example.dapp.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DandTuploadservice extends Service {

    public DandTuploadservice(){
    }

    private static String uid;
    ScheduledExecutorService myschedule_executor;
    DboUserInfo dbuinfo = new DboUserInfo();
//    uid = Dashboard.uid;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        uid = intent.getStringExtra("uid");

        Intent notificationIntent = new Intent(this, Dashboard.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,
//                0, notificationIntent,0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText("On Duty")
                .setSmallIcon(R.drawable.ic_baseline_location_on_24)

                .build();

//        myschedule_executor = Executors.newScheduledThreadPool(1);
//        myschedule_executor.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
////                datetimeuploder();
//            }
//        },1,5, TimeUnit.SECONDS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    datetimeuploder();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();





        startForeground(1,notification);

        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myschedule_executor.shutdown();
    }

    private static void datetimeuploder() {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
        int sec = Calendar.getInstance().get(Calendar.SECOND);
        String time =  month + " " + day + " " + year + " " + hour + ":" + min +":"+ sec;
        DboUserInfo dbuinfo = new DboUserInfo();

        if (uid != null) {
            dbuinfo.uploadtime(uid, time);
        }

    }
}
