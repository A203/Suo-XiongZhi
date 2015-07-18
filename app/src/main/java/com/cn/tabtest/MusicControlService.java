package com.cn.tabtest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SuoXiongZhi on 2015-7-15.
 */

public class MusicControlService extends Service{

    int current = 0;
    int count = 0;
    int status = 0x11;
    int flog = 0;
    MediaPlayer mediaPlayer;
    List<Object> musicLists = new ArrayList<Object>();
    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    private static final File MUSIC_PATH = Environment.getExternalStorageDirectory();
    MainActivity mainActivity;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        flog=0;
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        if(flog==2){
            Intent sendIntent = new Intent(MainActivity.UPDATE_ACTION);
            sendIntent.putExtra("update", status);
            sendBroadcast(sendIntent);
        }
        flog=2;
    }

    @Override
    public void onCreate() {
        flog =1;
        musicList();
        count = list.size();
        Log.e("service", "该服务正在运行中");
        MusicReceiver musicReceiver = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MainActivity.CTL_ACTION);
        registerReceiver(musicReceiver, intentFilter);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;
                if (current >= count) {
                    current = 0;
                }
                String filename = ((MusicInfo) musicLists.get(current)).getData();
                playMusic(filename);
            }
        });
        super.onCreate();
    }

    public class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int control = intent.getIntExtra("control",-1);
            switch (control){
                case 1: {
                    // 如果原来处于停止的状态
                    if (status == 0x11) {
                        mediaPlayer.start();
                        playMusic( ((MusicInfo) musicLists.get(current)).getData());
                        status = 0x12;
                    }
                    // 原来处于播放状态
                    else if (status == 0x12) {
                        mediaPlayer.pause();
                        status = 0x13;
                    }
                    // 原来处于暂停状态
                    else if (status == 0x13) {
                        mediaPlayer.start();
                        status = 0x12;
                    }
                    break;
                }
                case 2: {
                    // 如果原来正在播放或暂停
                    if (status == 0x12) {
                        mediaPlayer.stop();
                        status = 0x11;
                    }
                    else {
                        mediaPlayer.start();
                        status = 0x12;
                    }
                    break;
                }
                case 3: {
                    current--;
                    if (current < 0) {
                        current = count;
                    }
                    playMusic(((MusicInfo) musicLists.get(current)).getData());
                    status = 0x12;
                    break;
                }
                case 4: {
                    current++;
                    if (current > count) {
                        current = 0;
                    }
                    playMusic( ((MusicInfo) musicLists.get(current)).getData());
                    status = 0x12;
                    break;
                }
                case 5: {
                    current = intent.getIntExtra("current", -1);;
                    playMusic( ((MusicInfo) musicLists.get(current)).getData());
                    status = 0x12;
                    break;
                }
            }
            Intent sendIntent = new Intent(MainActivity.UPDATE_ACTION);
            sendIntent.putExtra("update",status);
            sendBroadcast(sendIntent);
        }
    }

    public void playMusic(String path){
        try{
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    current--;
                    if(current < 0 ){
                        current = count;
                    }
                    playMusic(((MusicInfo) musicLists.get(current)).getData());
                    status = 0X12;
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void musicList() {
        // 取得指定位置的文件设置显示到播放列表
        String[] str1 = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.SIZE,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION
        };
        Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                str1, null, null, MediaStore.Audio.Media.ARTIST);
        while (cursor.moveToNext()) {
            MusicInfo temp = new MusicInfo();
            temp.setFilename(cursor.getString(6));
            temp.setTitle(cursor.getString(0));
            temp.setDuration(cursor.getInt(1));
            temp.setArtist(cursor.getString(2));
            temp.setData(cursor.getString(5));
            musicLists.add(temp);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", cursor.getString(2));
            map.put("artist", cursor.getString(5));
            list.add(map);
        }
    }

}
