package com.aiden.andmodule.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import com.aiden.andmodule.db.LiveAppDatabase;
import com.aiden.andmodule.db.LiveTodo;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveAppDatabase db;
   public MainViewModel(@NonNull Application application) {
        super(application);
        db= Room.databaseBuilder(application, LiveAppDatabase.class,"todo-db")
                .allowMainThreadQueries()
                .build();
    }
    public LiveData<List<LiveTodo>> getAll(){
        return  db.todoDao().getAll();
    }
    public void insert(LiveTodo todo){
        db.todoDao().insert(new LiveTodo(todo.getTitle()));
    }
}
