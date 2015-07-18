package com.cn.tabtest;

import android.widget.Button;

/**
 * Created by SuoXiongZhi on 2015-7-14.
 */
public class MusicInfo {

    private String filename;
    private String Title;
    private int   duration;
    private String artist;
    private String location;

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getData() {
        return location;
    }
    public void setData(String location) {
        this.location = location;
    }

}
