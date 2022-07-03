package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;

public class ActivityServiceTest extends AppCompatActivity {

    private static final String TAG = "yslServiceTest";
    private static SharedPreferences mSpf;
    private static EditText usr;
    private static EditText password;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        bt_login = findViewById(R.id.btn_login);
        usr = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        mSpf = getSharedPreferences("test", MODE_PRIVATE);
        Log.d(TAG, "onCreate: ");

    }

    public static void writeUserMessage() {
        SharedPreferences.Editor editor = mSpf.edit();//获取编辑器
        editor.putString("usr",usr.getText().toString());//放数据
        editor.putString("password",password.getText().toString());
        editor.commit();
    }

    public static void readUserMessage(){
        String usrread = mSpf.getString("usr", "");//取数据
        usr.setText(usrread);
        String passwordread = mSpf.getString("password","");
        password.setText(passwordread);
    }


    @Override
    protected void onStart() {
        super.onStart();
        readUserMessage();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void start(View view) {//
        startService(new Intent(this, MyService.class));
    }

    public void stop(View view) {//
        stopService(new Intent(this, MyService.class));
    }


}