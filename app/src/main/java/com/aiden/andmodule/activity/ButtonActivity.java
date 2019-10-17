package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aiden.andmodule.R;

public class ButtonActivity extends AppCompatActivity {


    boolean FONT_1,FONT_2,FONT_3,FONT_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        TextView font_btn1 = findViewById(R.id.txt_font1);
        TextView font_btn2 = findViewById(R.id.txt_font2);
        TextView font_btn3 = findViewById(R.id.txt_font3);
        TextView font_btn4 = findViewById(R.id.txt_font4);



        font_btn1.setOnClickListener(v -> {
            if(!FONT_1) {
                font_btn1.setBackground(getDrawable(R.drawable.round_btn_on));
                font_btn1.setTextColor(getResources().getColor(R.color.setting_txt_on));
                FONT_1 = true;
            }else{
                font_btn1.setBackground(getDrawable(R.drawable.round_btn_off));
                font_btn1.setTextColor(getResources().getColor(R.color.setting_txt_off));
                FONT_1 = false;
            }
        });
        font_btn2.setOnClickListener(v -> {
            if(!FONT_2) {
                font_btn2.setBackground(getDrawable(R.drawable.round_btn_on));
                font_btn2.setTextColor(getResources().getColor(R.color.setting_txt_on));
                FONT_2 = true;
            }else{
                font_btn2.setBackground(getDrawable(R.drawable.round_btn_off));
                font_btn2.setTextColor(getResources().getColor(R.color.setting_txt_off));
                FONT_2 = false;
            }
        });
        font_btn3.setOnClickListener(v -> {
            if(!FONT_3) {
                font_btn3.setBackground(getDrawable(R.drawable.round_btn_on));
                font_btn3.setTextColor(getResources().getColor(R.color.setting_txt_on));
                FONT_3 = true;
            }else{
                font_btn3.setBackground(getDrawable(R.drawable.round_btn_off));
                font_btn3.setTextColor(getResources().getColor(R.color.setting_txt_off));
                FONT_3 = false;
            }
        });
        font_btn4.setOnClickListener(v -> {
            if(!FONT_4) {
                font_btn4.setBackground(getDrawable(R.drawable.round_btn_on));
                font_btn4.setTextColor(getResources().getColor(R.color.setting_txt_on));
                FONT_4 = true;
            }else{
                font_btn4.setBackground(getDrawable(R.drawable.round_btn_off));
                font_btn4.setTextColor(getResources().getColor(R.color.setting_txt_off));
                FONT_4 = false;
            }
        });


    }
}
