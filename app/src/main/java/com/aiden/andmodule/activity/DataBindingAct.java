package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.aiden.andmodule.R;

import com.aiden.andmodule.databinding.Main;


//2020.02.17 databind commit 
public class DataBindingAct extends AppCompatActivity {

    Main binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.databind);
        binding = DataBindingUtil.setContentView(this,R.layout.databind);
        binding.setMydata(this);

        //비효율적인 코드
        /*
        binding.btStart.setOnClickListener(v -> {
            Intent intent = new Intent(DataBindingAct.this,ToogleActivity.class);
            startActivity(intent);
        });
        */



    }

    public void ShowToast(){
        Toast.makeText(this, "Clicked Button....", Toast.LENGTH_SHORT).show();
    }
}
