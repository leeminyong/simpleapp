package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

public class ToogleActivity extends AppCompatActivity {
    AppCompatToggleButton toogle;
    AppCompatToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toogle);
        toogle = findViewById(R.id.btn_all_select_my);
        toggleButton = findViewById(R.id.toggleButton);
        toogle.setChecked(true);
        LogUtil.e("ToogleActivity","토글상태--->"+toogle.isChecked());
        toggleButton.setChecked(false);
        toggleButton.setBackground(getResources().getDrawable(R.drawable.bg_round_study_finish_gray));
      Button btn  = findViewById(R.id.button2);
      btn.setSelected(false);

        toogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e("ToogleActivity","토글상태--->"+toogle.isChecked());

                if(toogle.isChecked()){


                    LogUtil.e("ToogleActivity","토클 버튼 상태 : 켜짐");
                }
                else{
                    LogUtil.e("ToogleActivity","토클 버튼 상태 : 꺼짐");

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            if (!item.isChecked()) {
                LogUtil.e("ToogleActivity","닫기 상태(삭제기능).....111");
                item.setTitle(R.string.action_option_3);
                item.setChecked(true);
                toogle.setVisibility(View.VISIBLE);

            }else{
                LogUtil.e("ToogleActivity","편집 상태.....111");
                item.setTitle(R.string.action_option_1);
                item.setChecked(false);
                toogle.setVisibility(View.GONE);
            }


            //bDEL_MODE =false;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onAnko(View view) {

    }
}
