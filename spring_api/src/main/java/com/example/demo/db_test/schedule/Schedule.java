package com.example.demo.db_test.schedule;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int user_id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date started_at;
    @Column
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
