package com.aiden.andmodule.activity;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.aiden.andmodule.R;

public class GroupBtnActivity extends BaseActivity {
    private RadioButton r_btn1, r_btn2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupbtn);

        //라디오 버튼 설정
        r_btn1 = findViewById(R.id.rg_btn1);
        r_btn2 = findViewById(R.id.rg_btn2);
        r_btn1.setOnClickListener(radioButtonClickListener);
        r_btn2.setOnClickListener(radioButtonClickListener);

        //라디오 그룹 설정
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

    }

    //라디오 버튼 클릭 리스너
    RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(GroupBtnActivity.this, "r_btn1 : " + r_btn1.isChecked() + "r_btn2 : " + r_btn2.isChecked(), Toast.LENGTH_SHORT).show();
        }
    };

    //라디오 그룹 클릭 리스너
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = (radioGroup, position) -> {
        if (position == R.id.rg_btn1) {
            Toast.makeText(GroupBtnActivity.this, "라디오 그룹 버튼1 눌렸습니다.", Toast.LENGTH_SHORT).show();
        } else if (position == R.id.rg_btn2) {
            Toast.makeText(GroupBtnActivity.this, "라디오 그룹 버튼2 눌렸습니다.", Toast.LENGTH_SHORT).show();
        }
    };
}

