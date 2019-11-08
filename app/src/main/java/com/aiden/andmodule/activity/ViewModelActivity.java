package com.aiden.andmodule.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.aiden.andmodule.R;
import com.aiden.andmodule.db.LiveTodo;
import com.aiden.andmodule.model.MainViewModel;

public class ViewModelActivity extends AppCompatActivity {

    private EditText mEdit;
    private TextView txtResult;
    String TAG = "ViewModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewmodel);

        mEdit = findViewById(R.id.et_input);
        txtResult = findViewById(R.id.txt_result);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // UI  갱신
        viewModel.getAll().observe(this, todos -> {
            txtResult.setText(todos.toString());

        });
        //DB에 Insert
        findViewById(R.id.btn_add).setOnClickListener(v -> {
            viewModel.insert(new LiveTodo(mEdit.getText().toString()));
            mEdit.setText("");
        });



    }
}
