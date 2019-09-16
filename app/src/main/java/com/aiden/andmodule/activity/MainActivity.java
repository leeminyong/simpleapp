package com.aiden.andmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.aiden.andmodule.R;

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
            cityNames.add("");
            cityNames.add("");
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
                        case 11:
                            //Listview
                            intent = new Intent(MainActivity.this, MultiDelListActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            break;
                         //MultiDelListActivity
                        //DialogActivity
                        //ToogleActivity
                        //SharedDataActivity
                        //DBRecyclerActivity

                    }

                    //Toast.makeText(MainActivity.this,  position + ", " + tv.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

