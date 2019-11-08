package com.aiden.andmodule.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LiveDataDao {

    @Query("select * from LiveTodo")
    LiveData<List<LiveTodo>> getAll();
    @Insert
    void insert(LiveTodo todo);
    @Update
    void update(LiveTodo todo);
    @Delete
    void delete(LiveTodo todo);




}
