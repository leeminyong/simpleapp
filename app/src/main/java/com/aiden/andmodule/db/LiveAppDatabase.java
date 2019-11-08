package com.aiden.andmodule.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LiveTodo.class},version =2)
public abstract  class LiveAppDatabase extends RoomDatabase {
    public abstract LiveDataDao todoDao();
}
