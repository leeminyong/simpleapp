package com.aiden.andmodule.activity;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.ListViewEditListAdapter;
import com.aiden.andmodule.db.MyEditDBHelper;
import com.aiden.andmodule.model.MyEditWord;

import java.util.ArrayList;
import java.util.Collection;


/**
 MY 단어 메인
 */
public class DBListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String TAG = getClass().getSimpleName();
    final int ADD_MODE = 100;

    ArrayList<MyEditWord> datas;
    ImageView ivNodata;
    ListViewEditListAdapter adapter;

    Context mcontext;
    int idx;
    ListView listView;


    boolean bDEL_MODE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_dblist);
        mcontext = getApplicationContext();
        listView = findViewById(R.id.main_list);



        ivNodata = (ImageView) findViewById(R.id.img_nodata);
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
                String result_data = String.format("ID=%d,word_eng:%s,word_kor:%s", id, word_eng,word_kor);
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
                String result_data = String.format("ID=%d,word_eng:%s,word_kor:%s", id, word_eng,word_kor);
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
        adapter = new ListViewEditListAdapter(this, R.layout.lv_myedit_item, datas);
        listView.setAdapter(adapter);
        db.close();
        if (count() < 1)
            ivNodata.setVisibility(View.VISIBLE);
        else
            ivNodata.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.initConter();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            //삭제
            if (!item.isChecked()) {
                item.setTitle(R.string.action_option_3);
                item.setChecked(true);
                LogUtil.e(TAG, "닫기 상태 ....");
                setListEdit(true);
            }
            //편집
            else {
                LogUtil.e(TAG, "편집 클릭....");
                item.setTitle(R.string.action_option_3);
                item.setChecked(false);
                setListEdit(false);
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
                LogUtil.e(TAG,"선택한 아이템 사이즈-->"+checkedItems.size());
                int count = adapter.getCount();
                for (int i = count - 1; i >= 0; i--) {
                    if (checkedItems.get(i)) {
                        LogUtil.e(TAG,"삭제되는 데이터들--->"+i);
                        datas.remove(i);
                    }
                } // 모든 선택 상태 초기화.
                listView.clearChoices() ;
                adapter.notifyDataSetChanged();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void id_delete(Collection<Integer> ids){

        for(Integer s: ids){
            LogUtil.e(TAG,"삭제할 아이디-->"+s);

        }

        SQLiteDatabase db=null;
        final Integer[] idsToDelete = new Integer[ids.size()];

        ids.toArray(idsToDelete);
        for(Integer id: idsToDelete){
            LogUtil.e(TAG,"삭제할 id-->"+id);
            MyEditDBHelper helper = new MyEditDBHelper(this);
            db = helper.getWritableDatabase();
            String sql = "delete from tb_myedit where _id = ?";
            Object[] params = {id};

            db.execSQL(sql, params);
        }
        if(db!=null)
            db.close();

    }

    /**
     * 편집모드 클릭시 리스트에서 경고 이미지 출력 여부 결정
     * false: 체크박스 가린다.
     *
     * @param bEdit
     */
    public void setListEdit(boolean bEdit) {
        for (int i = 0; i < adapter.getCount(); i++) {
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
        Intent intent = new Intent(DBListViewActivity.this, MyEditPopUp.class);
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



    public void onAdd(View v){
        Intent intent = new Intent(DBListViewActivity.this, MyEditPopUp.class);
        intent.putExtra("mode", "add");
        intent.putExtra("idx", idx);
        startActivityForResult(intent, ADD_MODE);

    }

    public void onDel(View view) {

        id_delete(adapter.getCountersToDelete());
        refreshData();
        adapter.initConter();
        adapter.notifyDataSetChanged();

    }
/*
    public void onAll(View view) {
        //adapter.selecteAll();
        adapter.setAllChecked(true);
    }
    */


    boolean flag=true;
    public void onAll(View view) {

        LogUtil.e(TAG,"Size of data-->"+adapter.getCount());
        if(flag) {
            adapter.setAllChecked(true);
            adapter.set_allSell(true);

            flag = false;
        }else{
            adapter.setAllChecked(false);
            adapter.set_allSell(false);
            flag = true;
        }
        // Adapter에 Data에 변화가 생겼을때 Adapter에 알려준다.
        adapter.notifyDataSetChanged();
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
        adapter = new ListViewEditListAdapter(this, R.layout.lv_myedit_item, datas);
        listView.setAdapter(adapter);
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

                String result_data = String.format("[VO] ID=%d ,word_eng:%s,word_kor:%s "
                        , vo.id, vo.word_eng, vo.word_kor);
                LogUtil.e(TAG, result_data);
            }
            adapter = new ListViewEditListAdapter(this, R.layout.lv_myedit_item, datas);
        listView.setAdapter(adapter);
            db.close();

    }

    //selecteAll()
}
