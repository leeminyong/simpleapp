package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.ListViewAdapter;
import com.aiden.andmodule.model.ListViewItem;

public class ListViewActivity extends AppCompatActivity {

    String TAG = "ListViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_mail_gray_24dp),"Ind", "Assignment Ind Black 36dp") ;

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;
                adapter.setSelect(position);
                adapter.notifyDataSetChanged();
                //v.setBackgroundColor(Color.RED);
                LogUtil.e(TAG,"pos--->"+position);

                // TODO : use item data.
            }
        }) ;

    }
}
