package com.aiden.andmodule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyEditDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public MyEditDBHelper(Context context){
        super(context,"myeidtdb.db3",null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String studentSql = "CREATE TABLE tb_myedit (_id INTEGER PRIMARY KEY, word_eng TEXT,word_kor TEXT)";

        db.execSQL(studentSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
