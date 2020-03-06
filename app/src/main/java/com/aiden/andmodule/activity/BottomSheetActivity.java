package com.aiden.andmodule.activity;

import android.os.Bundle;

import com.aiden.andmodule.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
//2019.09.14
public class BottomSheetActivity extends BaseActivity {
//2019.09.24 21 lmy test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheet);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.getInstance();
            bottomSheetDialog.show(getSupportFragmentManager(),"bottomSheet");
        });

    }


}
