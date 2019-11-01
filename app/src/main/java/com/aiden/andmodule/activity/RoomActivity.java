package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.aiden.andmodule.R;
import com.aiden.andmodule.db.AppDatabase;
import com.aiden.andmodule.db.Todo;

public class RoomActivity extends AppCompatActivity {

    private EditText mEdit;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mEdit = findViewById(R.id.et_input);
        txtResult = findViewById(R.id.txt_result);
        final  AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,"todo-db")
                .allowMainThreadQueries()
                .build();
        txtResult.setText(db.todoDao().getAll().toString());
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            db.todoDao().insert(new Todo(mEdit.getText().toString()));
            txtResult.setText(db.todoDao().getAll().toString());
        });



    }
}
