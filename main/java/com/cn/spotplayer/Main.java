package com.cn.spotplayer;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import util.BaseActivity;

/**
 * Created By SuoXiongZhi on 2015/07/13.
 */

public class Main extends TabActivity implements RadioGroup.OnCheckedChangeListener{

    long waitTime = 2000;
    long touchTime = 0;
    TabHost tabHost;
    ListView musicList;
    ListView songForma;
    TextView onlineInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.music_tab_view);
        initTabView();
        initData();
    }

    private void initData() {
        ((RadioGroup) findViewById(R.id.tab_radiogroup))
                .setOnCheckedChangeListener(this);
    }

    /**
     *
     */

    private TabHost.TabSpec buildTagSpec(String tagName, int tagLable,
                                         int icon, int view) {
        return
                tabHost.newTabSpec(tagName)
                .setIndicator(getResources().getString(tagLable),
                        getResources().getDrawable(icon)).setContent(view);
    }

    /**
     * 初始化tab
     */

    private void initTabView() {
        tabHost = getTabHost();
        musicList = (ListView)findViewById(R.id.tab_list);
        songForma = (ListView)findViewById(R.id.tab_forma);
        onlineInfo = (TextView)findViewById(R.id.tab_online);
        tabHost.addTab(this.buildTagSpec("tab_list", R.string.song_list, R.drawable.next, R.id.tab_list));
        tabHost.addTab(this.buildTagSpec("tab_forma", R.string.song_froma, R.drawable.next, R.id.tab_forma));
        tabHost.addTab(this.buildTagSpec("tab_online", R.string.music_online, R.drawable.next, R.id.tab_online));
    }


    //当radioButton改变时候发生按钮相应事件
    /**
     * 按钮点击事件
     */

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_button_list:
                tabHost.setCurrentTabByTag("tab_list");
                break;
            case R.id.radio_button_forma:
                tabHost.setCurrentTabByTag("tab_forma");
                break;
            case R.id.radio_button_online:
                tabHost.setCurrentTabByTag("tab_online");
                break;
        }

    }



    //再按一次就要匆匆离去功能提示

    /**
     * 再按一次离开
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                Toast.makeText(getApplication(),"再按一次我就匆匆离去",Toast.LENGTH_SHORT).show();
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
