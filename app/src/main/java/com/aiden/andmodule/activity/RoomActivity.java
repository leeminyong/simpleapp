package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.db.AppDatabase;
import com.aiden.andmodule.db.Todo;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private EditText mEdit;
    private TextView txtResult;
    String TAG = "RoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mEdit = findViewById(R.id.et_input);
        txtResult = findViewById(R.id.txt_result);
        final  AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,"todo-db")
                .allowMainThreadQueries()
                .build();
        // UI  갱신
        db.todoDao().getAll().observe(this, todos -> {
            txtResult.setText(todos.toString());

        });
        //DB에 Insert
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            db.todoDao().insert(new Todo(mEdit.getText().toString()));
        });



    }
}
