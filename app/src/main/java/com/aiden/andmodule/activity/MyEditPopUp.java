package com.aiden.andmodule.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;


import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.db.MyEditDBHelper;
import com.aiden.andmodule.R;
import com.aiden.andmodule.model.MyEditWord;

import java.util.ArrayList;

/**
 * [학습알림]알림 등록및 알림편집 화면
 */


public class MyEditPopUp extends BaseActivity {

    String TAG = "MyEditPopUp";
    private EditText ed_eng;
    private EditText ed_kor;
    int vo_curid = 0;// cur의 id
    Context mcontext;
    String mWordEng = "";
    String mWordKor = "";
    String MODE = "";//추가 모드인지, 등록 모드인지 : edit:편집모드/  add: 새로 등록

    ArrayList<MyEditWord> datas;
    MyEditWord vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myedit_dialog);
        mcontext = getApplicationContext();
        ed_eng = findViewById(R.id.ed_eng);
        ed_kor = findViewById(R.id.ed_kor);
        Intent intent = getIntent();
        if (intent != null) {
            MODE = intent.getExtras().getString("mode");
            LogUtil.e(TAG, "현재모드--->" + MODE);
            vo_curid = intent.getExtras().getInt("no", 0);
            LogUtil.e(TAG, "현재 id-->" + vo_curid);
            if (count() > 0) {
                refreshData();
            }
        }
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.O) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        if (MODE.equals("edit")){
            querySelect(vo_curid);
            ed_eng.setText(mWordEng);
            ed_kor.setText(mWordKor);
        }
    }


    public void querySelect(int _id) {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] selectionArgs = new String[]{String.valueOf(_id)};
        Cursor cursor = db.rawQuery(
                "SELECT * FROM tb_myedit WHERE _id = ? ",
                selectionArgs);

        String wordeng = "";
        String wordkor = "";

        int id = 0;


        if (cursor != null) {
            cursor.moveToNext();
            wordeng = cursor.getString(cursor.getColumnIndex("word_eng"));
            wordkor = cursor.getString(cursor.getColumnIndex("word_kor"));
            id = cursor.getInt(cursor.getColumnIndex("_id"));

            mWordEng = wordeng;
            mWordKor = wordkor;
            String result_data = String.format(
                    "[조회] ID=%d ,wordeng:%s,wordkor:%s", id, wordeng,wordkor);
            LogUtil.e(TAG, result_data);
            cursor.close();
            cursor = null;
        }
        db.close();
    }

    public int count() {
        int cnt = 0;
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM tb_myedit ",
                null);
        cnt = cursor.getCount();
        return cnt;
    }

    public void queryUpdate(int _id,String _wordeng,String _wordkor) {
        LogUtil.e(TAG, "==============편집 등록============");
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues row = new ContentValues();


        row.put("word_eng", _wordeng);
        row.put("word_kor", _wordkor);
        db.update("tb_myedit", row, "_id=" + _id, null);

        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        setResult(RESULT_OK, intent);

        finish();
    }


    /**
     * DB에 데이터 저장 후 액티비티 호출
     */

    private void querySave( String _wordeng, String _wordkor) {
        LogUtil.e(TAG, "==============신규 등록============");
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues row;

        row = new ContentValues();
        row.put("word_eng", _wordeng);
        row.put("word_kor", _wordkor);
        db.insert("tb_myedit", null, row);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        setResult(RESULT_OK, intent);
        finish();
    }
    private void refreshData() {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        //String[] selectionArgs = new String[]{String.valueOf(_id)};
        Cursor cursor = db.rawQuery("select * from tb_myedit ", null);
        datas = new ArrayList<>();
        while (cursor.moveToNext()) {
            vo = new MyEditWord();
            vo.id = cursor.getInt(0);
            vo.word_eng = cursor.getString(1);
            vo.word_kor = cursor.getString(2);
            //  LogUtil.e(TAG,"refreshData :: memo-->"+vo.memo);
            datas.add(vo);
            String result_data = String.format("[VO] ID=%d ,memo:%s,", vo.id,vo.word_eng,vo.word_kor);
           // LogUtil.e(TAG, result_data);
        }
        db.close();
    }


    @Override
    public void onBackPressed() {
        finish();

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    public void mOnClose(View view) {
        finish();
    }

    public void mOnSave(View view) {
        mWordEng = ed_eng.getText().toString();
        mWordKor = ed_kor.getText().toString();
        if (MODE.equals("add")) {

            querySave(mWordEng,mWordKor);
        } else if (MODE.equals("edit")) {

            LogUtil.e(TAG, "idx--->" + vo_curid);
            queryUpdate(vo_curid, mWordEng,mWordKor);
        }

    }
}

