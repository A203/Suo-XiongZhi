package com.cn.tabtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import Util.BaseActivity;

/**
 * Created by SuoXiongZhi on 2015-7-13.
 */

public class Welcome extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        enter();
    }

    private void enter() {

        //方法一：启动一个自建的线程
//        StartThread startThread = new StartThread();
//        startThread.start();
//        final Intent intent = new Intent(Welcome.this,Main.class);
//
//        Timer timer = new Timer();
//        TimerTask tt = new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(intent);
//                finish();
//            }
//        };
//        timer.schedule(tt, 3 * 1000);

        //方法二：直接启动一个现时线程
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                Intent intent = new Intent(Welcome.this,MainActivity.class);
                animPush();
                startActivity(intent);
            }

        };
        thread.start();
    }

}

/*

class StartThread extends Thread{

    @Override
    public void run(){

    }

}

*/