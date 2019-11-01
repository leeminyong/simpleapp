package com.aiden.andmodule.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("select * from Todo")
    List<Todo> getAll();
    @Insert
    void insert(Todo todo);
    @Update
    void update(Todo todo);
    @Delete
    void delete(Todo todo);




}
