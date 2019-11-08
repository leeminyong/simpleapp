package com.aiden.andmodule.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LiveTodo {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private  String title;

    public LiveTodo(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LiveTodo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
