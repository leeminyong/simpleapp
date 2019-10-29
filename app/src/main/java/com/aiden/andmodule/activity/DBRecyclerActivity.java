package com.aiden.andmodule.activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.MyEditListAdapter;
import com.aiden.andmodule.db.MyEditDBHelper;
import com.aiden.andmodule.model.MyEditWord;

import java.util.ArrayList;


/**
 * MY 단어 메인
 */
public class DBRecyclerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MyEditListAdapter.OnListItemSelectedInterface {
    String TAG = getClass().getSimpleName();
    final int ADD_MODE = 100;

    ArrayList<MyEditWord> datas;
    ImageView ivNodata;
    MyEditListAdapter adapter;
    Context mcontext;
    int idx;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist);
        mcontext = getApplicationContext();
        mRecyclerView = findViewById(R.id.main_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ivNodata = findViewById(R.id.img_nodata);
        refreshData();
        selectData();
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
    private void selectData() {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db != null) {
            String sql = "select * from tb_myedit";
            Cursor cursor = db.rawQuery(sql, null);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                this.idx = id;
                String word_eng = cursor.getString(1);
                String word_kor = cursor.getString(2);
                String result_data = String.format("ID=%d,word_eng:%s,word_kor:%s", id, word_eng, word_kor);
                LogUtil.e(TAG, result_data);
            }
        }
        db.close();
        helper.close();
        adapter.notifyDataSetChanged();
        LogUtil.e(TAG, "데이터 리스트뷰 갱신.......");
    }

    private void selectOrderABC() {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db != null) {
            String sql = "select * from tb_myedit ORDER BY word_eng ASC";
            Cursor cursor = db.rawQuery(sql, null);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                this.idx = id;
                String word_eng = cursor.getString(1);
                String word_kor = cursor.getString(2);
                String result_data = String.format("ID=%d,word_eng:%s,word_kor:%s", id, word_eng, word_kor);
                LogUtil.e(TAG, result_data);
            }
        }
        db.close();
        helper.close();
        adapter.notifyDataSetChanged();
        LogUtil.e(TAG, "데이터 리스트뷰 갱신.......");
    }

    private void refreshData() {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_myedit ", null);
        datas = new ArrayList<>();
        while (cursor.moveToNext()) {
            MyEditWord vo = new MyEditWord();
            vo.id = cursor.getInt(0);
            vo.word_eng = cursor.getString(1);
            vo.word_kor = cursor.getString(2);
            datas.add(vo);

            String result_data = String.format("[VO] ID=%d ,word_eng:%s,word_kor:%s "
                    , vo.id, vo.word_eng, vo.word_kor);
            LogUtil.e(TAG, result_data);
        }
        adapter = new MyEditListAdapter(this, R.layout.lv_myedit_item, datas, this);
        mRecyclerView.setAdapter(adapter);
        db.close();
        if (count() < 1)
            ivNodata.setVisibility(View.VISIBLE);
        else
            ivNodata.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {

            item.setTitle(R.string.action_option_1);
            item.setChecked(false);
            //bDEL_MODE =false;

        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * 편집모드 클릭시 리스트에서 경고 이미지 출력 여부 결정
     * false: 체크박스 가린다.
     *
     * @param bEdit
     */
    public void setListEdit(boolean bEdit) {
        for (int i = 0; i < adapter.getItemCount(); i++) {
            adapter.setb_Edit(bEdit);
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (intent == null) {
            intent = new Intent();
        }
        super.startActivityForResult(intent, requestCode);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //  LogUtil.e(TAG,"클릭 pos-->"+position);
    }
    private void item_edit(final int position) {
        Intent intent = new Intent(DBRecyclerActivity.this, MyEditPopUp.class);
        intent.putExtra("mode", "edit");
        intent.putExtra("no", position);
        startActivityForResult(intent, ADD_MODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            LogUtil.e(TAG, "데이터 refreshData");
            refreshData();
        }
    }

    public void onAdd(View v) {
        Intent intent = new Intent(DBRecyclerActivity.this, MyEditPopUp.class);
        intent.putExtra("mode", "add");
        intent.putExtra("idx", idx);
        startActivityForResult(intent, ADD_MODE);
    }

    public void onDel(View view) {
        showMessge();
    }
    public void onAll(View view) {
        adapter.allSelectedItem();
        LogUtil.e(TAG, "선택한 갯수--->" + adapter.getCountItem());
    }

    public void onSort(View view) {
        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        //      String sql = "select * from tb_myedit ORDER BY word_eng ASC";
        Cursor cursor = db.rawQuery("select * from tb_myedit ORDER BY word_eng ASC", null);
        datas = new ArrayList<>();
        while (cursor.moveToNext()) {
            MyEditWord vo = new MyEditWord();
            vo.id = cursor.getInt(0);
            vo.word_eng = cursor.getString(1);
            vo.word_kor = cursor.getString(2);
            datas.add(vo);
            String result_data = String.format("[VO] ID=%d ,word_eng:%s,word_kor:%s "
                    , vo.id, vo.word_eng, vo.word_kor);
            LogUtil.e(TAG, result_data);
        }
        adapter = new MyEditListAdapter(this, R.layout.lv_myedit_item, datas, this);
        mRecyclerView.setAdapter(adapter);
        db.close();
    }

    public void onSort2(View view) {

        MyEditDBHelper helper = new MyEditDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        //      String sql = "select * from tb_myedit ORDER BY word_eng ASC";
        Cursor cursor = db.rawQuery("select * from tb_myedit ORDER BY _id ASC", null);
        datas = new ArrayList<>();
        while (cursor.moveToNext()) {
            MyEditWord vo = new MyEditWord();
            vo.id = cursor.getInt(0);
            vo.word_eng = cursor.getString(1);
            vo.word_kor = cursor.getString(2);
            datas.add(vo);

            @SuppressLint("DefaultLocale")
            String result_data = String.format("[VO] ID=%d ,word_eng:%s,word_kor:%s "
                    , vo.id, vo.word_eng, vo.word_kor);
            LogUtil.e(TAG, result_data);
        }
        adapter = new MyEditListAdapter(this, R.layout.lv_myedit_item, datas, this);
        mRecyclerView.setAdapter(adapter);
        db.close();

    }

    public void showMessge() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage(adapter.getCountItem() + "개를 삭제할까요?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", (dialog, which) -> {
            adapter.DeleteItem();
            adapter.notifyDataSetChanged();
            refreshData();
            LogUtil.e(TAG, "삭제했다..");
        });
        builder.setNegativeButton("아니오", (dialog, which) -> {
            dialog.dismiss();
        });

        //만들어주기
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onItemSelected(View v, int position) {
        MyEditListAdapter.MyViewHolder viewHolder = (MyEditListAdapter.MyViewHolder) mRecyclerView.findViewHolderForAdapterPosition(position);

        //Toast.makeText(this, viewHolder.tx_no.getText().toString(), Toast.LENGTH_SHORT).show();
        LogUtil.e(TAG, "선택한것--->" + position);
        LogUtil.e(TAG, "남은   갯수--->" + adapter.getCountItem());

    }

    public void onUnSelect(View view) {
        adapter.clearSelectedItem();
    }


}
