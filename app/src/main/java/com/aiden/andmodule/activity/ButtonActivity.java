package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aiden.andmodule.R;

public class ButtonActivity extends AppCompatActivity {

    TextView btn1,btn2,btn3,btn4;
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn1 = findViewById(R.id.txt_1);
        btn2 = findViewById(R.id.txt_2);
        btn3 = findViewById(R.id.txt_3);
        btn4 = findViewById(R.id.txt_4);



        btn1.setOnClickListener(v -> {


            if(flag) {
                btn1.setBackground(getDrawable(R.drawable.round_btn_on));
                btn1.setTextColor(getResources().getColor(R.color.setting_txt_on));
                flag = false;
            }else{
                btn1.setBackground(getDrawable(R.drawable.round_btn_off));
                btn1.setTextColor(getResources().getColor(R.color.setting_txt_off));
                flag = true;
            }
        });


    }
}
