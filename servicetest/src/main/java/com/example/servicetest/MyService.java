package com.example.servicetest;

import static com.example.servicetest.ActivityServiceTest.readUserMessage;
import static com.example.servicetest.ActivityServiceTest.writeUserMessage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "Service";

    @Override
    public void onCreate() {
        super.onCreate();
        writeUserMessage();
        Toast.makeText(this, "My Service created 保存用户信息", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {//被废弃
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "My Service Start", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onStart");
        return super.onStartCommand(intent, flags, startId);
    }



    //onBind，onUnbind用于bindService
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "My Service onDestroy", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onDestroy");
    }

}