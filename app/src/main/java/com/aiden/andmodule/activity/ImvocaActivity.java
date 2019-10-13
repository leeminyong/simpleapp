package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aiden.andmodule.R;

public class ImvocaActivity extends AppCompatActivity {

    TextView tv,txtEng,txtPron,txtKor;
    float userFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imvoca);
         tv = findViewById(R.id.textView4);
        txtEng = findViewById(R.id.txtEng);
        txtPron = findViewById(R.id.txtPron);
        txtKor = findViewById(R.id.txtKor);

        SeekBar sb  = findViewById(R.id.seekBar);

        //tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.myword_day_size_basic));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.myword_day_size_step0));
/**
 * txtEng
 * txtPron
 * txtKor
 *
 */
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText("onStop TrackingTouch");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                tv.setText("onStart TrackingTouch");
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                tv.setText("onProgressChanged : " + progress);
                fontResize(progress);
            }
        });
    }

    private void fontResize(int pos){
        switch (pos){
            case 1:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step1);
                break;
            case 2:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step2);
                break;
            case 3:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step3);
                break;
            case 4:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step4);
                break;
            case 5:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step5);
                break;
            case 6:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step6);
                break;
            case 7:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step7);
                break;
            case 8:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step8);
                break;
            case 9:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step9);
                break;
            case 10:
                userFont = getResources().getDimension(R.dimen.myword_day_size_step10);
                break;


        }
        txtEng.setTextSize(TypedValue.COMPLEX_UNIT_PX, userFont);
        txtPron.setTextSize(TypedValue.COMPLEX_UNIT_PX, userFont);
        txtKor.setTextSize(TypedValue.COMPLEX_UNIT_PX, userFont);
    }
}
