package com.aiden.andmodule.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.aiden.andmodule.R;
import com.aiden.andmodule.db.AppDatabase;
import com.aiden.andmodule.db.LiveTodo;
import com.aiden.andmodule.db.Todo;

public class RoomAct extends AppCompatActivity {

    private EditText mEdit;
    private TextView txtResult;
    String TAG = "RoomAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_room);
        mEdit = findViewById(R.id.et_input);
        txtResult = findViewById(R.id.txt_result);
        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,"todo-db2")
                .allowMainThreadQueries()
                .build();
        // UI  갱신
        txtResult.setText(db.todoDao().getAll().toString());
        //DB에 Insert
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            db.todoDao().insert(new Todo(mEdit.getText().toString()));
            txtResult.setText(db.todoDao().getAll().toString());
            mEdit.setText("");
        });
    }
}
