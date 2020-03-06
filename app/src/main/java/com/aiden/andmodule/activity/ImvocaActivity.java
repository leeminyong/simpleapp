package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

public class ImvocaActivity extends BaseActivity {

    String TAG = "ImvocaActivity";


    AppCompatTextView tv,txtPron,txtKor,txtEng,stn_eng,stn_kor;
    float userEngFont,userDicFont,userKorFont,userEngExamFont,userKorExamFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imvoca);
         tv = findViewById(R.id.textView4);
        txtEng = findViewById(R.id.txtEng);
        txtPron = findViewById(R.id.txtPron);
        txtKor = findViewById(R.id.txtKor);

        stn_eng = findViewById(R.id.stn_eng);
        stn_kor = findViewById(R.id.stn_kor);

        SeekBar sb  = findViewById(R.id.seekBar);
        int pos = sb.getProgress();
        LogUtil.e(TAG,"현재 포지션.---->"+pos);
        fontResize(pos);


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

    /**
     * userEngFont,userDicFont,userKorFont,userEngExamFont,userKorExamFont;
     * @param pos
     */
    /**
     * 0~6 ( 7단계)
     *
     * @param pos
     */
    private void fontResize(int pos){
        switch (pos){
            case 0:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step0);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step0);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step0);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step0);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step0);

                break;
            case 1:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step1);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step1);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step1);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step1);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step1);
                break;
            case 2:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step2);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step2);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step2);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step2);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step2);
                break;
            case 3:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step3);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step3);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step2);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step2);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step2);
                break;
            case 4:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step4);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step4);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step4);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step4);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step4);
                break;

            case 5:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step5);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step5);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step5);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step5);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step5);
                break;
            case 6:
                userEngFont = getResources().getDimension(R.dimen.myword_eng_step6);
                userDicFont = getResources().getDimension(R.dimen.myword_engdic_step6);
                userKorFont = getResources().getDimension(R.dimen.myword_kor_step6);
                userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step6);
                userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step6);
                break;
        }

        /**
       * userDicFont = getResources().getDimension(R.dimen.myword_engdic_step3);
       *userKorFont = getResources().getDimension(R.dimen.myword_kor_step3);
       *userEngExamFont = getResources().getDimension(R.dimen.myword_eng_exam_step3);
       * userKorExamFont = getResources().getDimension(R.dimen.myword_kor_exam_step3);
         */
        txtEng.setTextSize(TypedValue.COMPLEX_UNIT_PX, userEngFont);
        txtPron.setTextSize(TypedValue.COMPLEX_UNIT_PX, userDicFont);
        txtKor.setTextSize(TypedValue.COMPLEX_UNIT_PX, userKorFont);
        stn_eng.setTextSize(TypedValue.COMPLEX_UNIT_PX, userEngExamFont);
        stn_kor.setTextSize(TypedValue.COMPLEX_UNIT_PX, userKorExamFont);
        LogUtil.e(TAG,"pos---->"+pos);
    }
}
