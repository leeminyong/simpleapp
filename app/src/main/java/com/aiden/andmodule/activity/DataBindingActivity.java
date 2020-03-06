package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.aiden.andmodule.R;
import com.aiden.andmodule.databinding.ActivityBindingBinding;

public class DataBindingActivity extends BaseActivity {
    ActivityBindingBinding binding;
    public String txtString = "Wow DataBinding~~!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding);
        binding.setMyData(this);

    }
}
