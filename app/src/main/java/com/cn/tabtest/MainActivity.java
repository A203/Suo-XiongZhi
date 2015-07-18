package com.cn.tabtest;

import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.DialogUtil;
import Util.ToastUtil;

/**
 * Created By SuoXiongZhi On 2015-7-15
 */

public class MainActivity extends TabActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    long waitTime = 2000;
    long touchTime = 0;

    TabHost tabHost;
    ListView musicList;
    MediaPlayer mediaPlayer;
    Cursor cursor;
    private int ids[], sizes[];
    private String artists[];
    private String path[];
    private String titles[];
    private String times[];
    private String albums[];
    private String displayName[];
    SimpleAdapter adapter;
    List<Object> musicLists = new ArrayList<Object>();
    List<Map<String,Object>> list;
    Button previous, play, next;
    ListView listView;
    public static final String CTL_ACTION = "CTL_ACTION";
    public static final String UPDATE_ACTION = "UPDATE_ACTION";
    int status = 0x11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        tabHost = getTabHost();
        addTab();
        uiInitView();
        initAction();
        showMp3Info();
        getMusic();
        ActivityReceiver activityReceiver = new ActivityReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UPDATE_ACTION);
        registerReceiver(activityReceiver, intentFilter);
        Intent intentService = new Intent(this,MusicControlService.class);
        startService(intentService);
    }

    public void getMusic() {
        list = new ArrayList<Map<String,Object>>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setTitle(cursor.getString(0));
            musicInfo.setArtist(cursor.getString(2));
            musicInfo.setData(cursor.getString(6));
            musicInfo.setDuration(cursor.getInt(1));
            musicLists.add(musicInfo);
            Map map = new HashMap<String,String>();
            map.put("name",cursor.getString(2));
            map.put("artist",cursor.getString(5));
            list.add(map);
            cursor.moveToNext();
        }
        adapter = new SimpleAdapter(this, list,
                R.layout.music_item, new String[] { "name", "artist" },
                new int[] { R.id.music_name, R.id.artist_name });
        listView.setAdapter(adapter);
    }

    private void addTab() {
        tabHost.addTab(this.buildTagSpec("tab1", "曲目列表", R.id.tab1_view));
        tabHost.addTab(this.buildTagSpec("tab2", "我的歌单", R.id.tab2_view));
        tabHost.addTab(this.buildTagSpec("tab3", "在线音乐", R.id.tab3_view));
    }

    private TabHost.TabSpec buildTagSpec(String tagName, String str, int id) {
        return tabHost
                .newTabSpec(tagName)
                .setIndicator(str).setContent(id);
    }

    private void initAction() {
        previous.setOnClickListener(this);
        play.setOnClickListener(this);
        next.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    private void uiInitView() {
        listView = (ListView) findViewById(R.id.music_1);
        previous = (Button) findViewById(R.id.previous);
        play = (Button) findViewById(R.id.play);
        next = (Button) findViewById(R.id.next);
        listView = (ListView)findViewById(R.id.music_1);
    }

    private void showMp3Info() {
        String[] str1 = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.SIZE,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION
        };
        cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                str1, null, null, MediaStore.Audio.Media.ARTIST);
        if (cursor != null && cursor.getCount() == 0) {
            DialogUtil.showDialog(this, "提示", "嗨，好像没搜索到歌曲耶，要不尝试添加音乐？", "我试试");
        }
        assert cursor != null;
        cursor.moveToFirst();
        ids = new int[cursor.getCount()];
        sizes = new int[cursor.getCount()];
        titles = new String[cursor.getCount()];
        artists = new String[cursor.getCount()];
        path = new String[cursor.getCount()];
        albums = new String[cursor.getCount()];
        times = new String[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++) {
            ids[i] = cursor.getInt(0);
            sizes[i] = cursor.getInt(1);
            titles[i] = cursor.getString(2);
            artists[i] = cursor.getString(3);
            path[i] = cursor.getString(4);
            albums[i] = cursor.getString(5);
            times[i] = cursor.getString(6);
            cursor.moveToNext();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        intent.setAction(CTL_ACTION);
        switch (v.getId()) {
            case R.id.previous:
                sendBroadCastor(3);
                status = 0x12;
                break;
            case R.id.play:
                if(!mediaPlayer.isPlaying()){
                    sendBroadCastor(1);
                    status = 0x12;
                }
                else {
                    sendBroadCastor(4);
                    status = 0x11;
                }
                break;
            case R.id.next:
                sendBroadCastor(5);
                status = 0x12;
                break;
            default:
                break;
        }
    }

    protected void sendBroadCastor(int state){
        Intent intent= new Intent();
        intent.setAction(CTL_ACTION);
        intent.putExtra("control", state);
        sendBroadcast(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(musicLists != null){
            Intent intent = new Intent(CTL_ACTION);
            intent.putExtra("control", 5);
            intent.putExtra("current", position);
            sendBroadcast(intent);
        }
        else {
            ToastUtil.TextShowShort(this,"让我安静一会儿");
        }
    }

    public class ActivityReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int update = intent.getIntExtra("update",-1);
            switch(update){
                case 0x11:
                {
                    status = 0x11;
                    break;
                }
                case 0x12:
                {
                    status = 0x12;
                    break;
                }
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                ToastUtil.TextShowShort(this,"再按一次我就匆匆离去");
                touchTime = currentTime;
            }
            else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

