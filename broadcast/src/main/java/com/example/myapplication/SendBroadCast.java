package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class SendBroadCast extends AppCompatActivity {
    private static final String TAG = "yslSend";
    private MyBroadcastReceiver  broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broad_cast);


    }
    
    
    @Override
    protected void onStart() {
        super.onStart();
        //注册广播接收者(动态),静态是在清单文件中
        broadcastReceiver = new MyBroadcastReceiver();//发送给谁
        IntentFilter filter = new IntentFilter();//用于过滤
//        filter.addAction("anhao");
        /*filter .addAction("android.intent.action.TIME_SET");//监听系统广播：时间变化；注意时间一直在变化，需要对应的处理，否则会死循环 */
        filter .addAction("android.intent.action.DATE_CHANGE");//监听系统广播：日期变化
        registerReceiver(broadcastReceiver,filter);

        //发送广播
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DATE_CHANGE");
        sendBroadcast(intent);
        Log.d(TAG, "onStart: 发送广播");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //销毁广播
        unregisterReceiver(broadcastReceiver);
    }
}