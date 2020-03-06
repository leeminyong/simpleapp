package com.aiden.andmodule.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.aiden.andmodule.R;
import com.aiden.andmodule.databinding.ActivityVmldbindBinding;
import com.aiden.andmodule.model.CounterViewModel;

public class VMLDbindActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVmldbindBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_vmldbind);
        CounterViewModel viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

    }
}
