package com.example.demo.db_test.schedule;

import java.util.Date;

public class ScheduleForm {
    
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Date started_at;
    private Date finished_at;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getStarted_at() {
        return started_at;
    }
    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }
    public Date getFinished_at() {
        return finished_at;
    }
    public void setFinished_at(Date finished_at) {
        this.finished_at = finished_at;
    }
}
