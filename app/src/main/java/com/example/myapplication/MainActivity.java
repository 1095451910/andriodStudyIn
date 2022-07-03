package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "sl";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
           /* 1.显式启动：，第一种
            startActivity(new Intent(当前Act.this,要启动的Act.class));*/
            startActivity(new Intent(this, OpenStyleDemo.class));
                break;
            case R.id.btn2:
           /* 1.显式启动：，第二种
                 通过Intent的ComponentName：
                ComponentName cn = new ComponentName("包名","启动Act的全限定类名") ;或者（this，启动Act的.class）
                Intent intent = new Intent() ;
                intent.setComponent(cn) ;
                startActivity(intent) ;*/

                 Intent intent = new Intent();
                ComponentName name = new ComponentName("com.example.myapplication","com.example.myapplication.OpenStyleDemo");//可以用来打开外部应用
                intent.setComponent(name);
                startActivity(intent);
                break;
            case R.id.btn3:
                  /*   1.显式启动：,第三种
                Intent intent = new Intent();
                intent.setClassName("包名","启动Act的全限定类名");
                startActivity(intent); */
                Intent intent2 = new Intent();
                intent2.setClassName("com.example.myapplication","com.example.myapplication.OpenStyleDemo");//但是setClassName一般是跳转到不同Applicaiton的activity或者service；
                startActivity(intent2);
                break;
            case R.id.btn4:
//              2.隐式启动
                String phoneNo = "12345";
                Intent intent4 = new Intent(); // 创建一个新意图
                intent4.setAction(Intent.ACTION_DIAL); // 设置意图动作准备拨号
                Uri  uri = Uri.parse("tel:" + phoneNo); // 声明一个拨号的
                intent4.setData(uri); // 设置意图前往的路径
                startActivity(intent4); // 启动意图通往的活动页面
                break;
            default:
        }

    }

}