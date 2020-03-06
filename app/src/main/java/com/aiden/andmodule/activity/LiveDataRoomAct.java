package com.aiden.andmodule.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.db.LiveAppDatabase;
import com.aiden.andmodule.db.LiveTodo;

public class LiveDataRoomAct extends BaseActivity {

    private EditText mEdit;
    private TextView txtResult;
    String TAG = "LiveDataRoom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mEdit = findViewById(R.id.et_input);
        txtResult = findViewById(R.id.txt_result);
        final LiveAppDatabase db = Room.databaseBuilder(this, LiveAppDatabase.class,"todo-db")
                .allowMainThreadQueries()
                .build();



        // UI  갱신
        db.todoDao().getAll().observe(this, Observer -> {
            txtResult.setText(Observer.toString());
            LogUtil.e(TAG,"UI 갱신...");

        });
        //DB에 Insert
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            db.todoDao().insert(new LiveTodo(mEdit.getText().toString()));
            mEdit.setText("");
        });



    }
}
