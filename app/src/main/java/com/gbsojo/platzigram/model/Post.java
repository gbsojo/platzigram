package com.gbsojo.platzigram.model;

import org.joda.time.DateTime;

import java.math.BigInteger;
import java.util.Date;

public class Post {
    private String picture;
    private String username;
    private DateTime date;
    private int likes;

    public Post(String picture, String username, DateTime date, int likes) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.likes = likes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
