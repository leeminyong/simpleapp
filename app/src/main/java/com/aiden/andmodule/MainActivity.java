package com.aiden.andmodule;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.aiden.andmodule.activity.BottomSheetActivity;
import com.aiden.andmodule.activity.ConstLayout;
import com.aiden.andmodule.activity.CustomListviewActivity;
import com.aiden.andmodule.activity.DBRecyclerActivity;
import com.aiden.andmodule.activity.DataBindingActivity;
import com.aiden.andmodule.activity.DialogActivity;
import com.aiden.andmodule.activity.GroupBtnActivity;
import com.aiden.andmodule.activity.ListViewActivity;
import com.aiden.andmodule.activity.MultiDelListActivity;
import com.aiden.andmodule.activity.MultiSimpleLvActivity;
import com.aiden.andmodule.activity.SharedDataActivity;
import com.aiden.andmodule.activity.SimpleLvActivity;
import com.aiden.andmodule.activity.ToogleActivity;
import com.aiden.andmodule.activity.WebActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> cityNames;



            // 데이터 준비
            cityNames = new ArrayList<String>();
            cityNames.add("Groupbtn");
            cityNames.add("BottomSheetDialog");
            cityNames.add("DBListview");
            cityNames.add("데이터저장");
            cityNames.add("WebView");
            cityNames.add("Toogle");
            cityNames.add("TabHost");
            cityNames.add("ConsLayout");
            cityNames.add("Databinding");
            cityNames.add("Listview");
            cityNames.add("CustomListview");
            cityNames.add("MultiDelListView");
            cityNames.add("MultiCheckListView");
            cityNames.add("SiplmeListview");
            cityNames.add("");
            cityNames.add("");

            // 어댑터를 생성
//        ListAdapter adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, cityNames);
            ListAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.list_item, R.id.lable, cityNames);
            // 리스트의 각 도시명을 id 가 lable 인 textView 에 표시

            // 어댑터를 설정
            GridView gridView = (GridView) findViewById(R.id.gridview);
            gridView.setAdapter(adapter);

            // 항목 클릭시 위치값과 값 토스트로 출력
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    TextView tv = (TextView) view.findViewById(R.id.lable);
                    Intent intent = null;
                    switch (position){
                        case 0:
                            intent = new Intent(MainActivity.this, GroupBtnActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, BottomSheetActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, DBRecyclerActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MainActivity.this, SharedDataActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(MainActivity.this, WebActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;

                        case 5:
                            intent = new Intent(MainActivity.this, ToogleActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(MainActivity.this, DialogActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 7:
                            intent = new Intent(MainActivity.this, ConstLayout.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 8:
                            intent = new Intent(MainActivity.this, DataBindingActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;

                        case 9:
                            intent = new Intent(MainActivity.this, ListViewActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        case 10:
                            //Listview
                            intent = new Intent(MainActivity.this, CustomListviewActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        /**
                         * 롱터치로 멀티 터치및 삭제 기능 있는 리스트뷰
                          */
                        case 11:

                            intent = new Intent(MainActivity.this, MultiDelListActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                        /**
                         * 체크박스 있는 리스트뷰
                         */
                        case 12:

                            intent = new Intent(MainActivity.this, MultiSimpleLvActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                         //SimpleLvActivity

                        case 13:

                            intent = new Intent(MainActivity.this, SimpleLvActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;

                    }

                    //Toast.makeText(MainActivity.this,  position + ", " + tv.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

