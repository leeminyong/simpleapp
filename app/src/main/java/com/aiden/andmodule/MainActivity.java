package com.aiden.andmodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.activity.BottomSheetActivity;
import com.aiden.andmodule.activity.ButtonActivity;
import com.aiden.andmodule.activity.ConstLayout;
import com.aiden.andmodule.activity.CustomListviewActivity;
import com.aiden.andmodule.activity.DBRecyclerActivity;
import com.aiden.andmodule.activity.DataBindingActivity;
import com.aiden.andmodule.activity.DialogActivity;
import com.aiden.andmodule.activity.GroupBtnActivity;
import com.aiden.andmodule.activity.ImvocaActivity;
import com.aiden.andmodule.activity.KotlinActivity;
import com.aiden.andmodule.activity.ListViewActivity;
import com.aiden.andmodule.activity.MultiDelListActivity;
import com.aiden.andmodule.activity.RecyclerViewActivity;
import com.aiden.andmodule.activity.RxSimpleActivity;
import com.aiden.andmodule.activity.SharedDataActivity;
import com.aiden.andmodule.activity.ToogleActivity;
import com.aiden.andmodule.activity.VMLDbindActivity;
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
            cityNames.add("RecyclerView");
            cityNames.add("Imvoca");
            cityNames.add("Rxandroid");
            cityNames.add("Button UI");
            cityNames.add("KotlinTest");
            cityNames.add("MVVMTest");
            //KotlinActivity

            // 어댑터를 생성

            ListAdapter adapter = new ArrayAdapter<>(this,
                    R.layout.list_item, R.id.lable, cityNames);


            // 어댑터를 설정
            GridView gridView = findViewById(R.id.gridview);
            gridView.setAdapter(adapter);

            // 항목 클릭시 위치값과 값 토스트로 출력
            gridView.setOnItemClickListener((parent, view, position, id) -> {


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
                    case 12:
                        //RecyclerViewActivity
                        intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 13:
                        //RecyclerViewActivity
                        intent = new Intent(MainActivity.this, ImvocaActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(MainActivity.this, RxSimpleActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(MainActivity.this, ButtonActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(MainActivity.this, KotlinActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(MainActivity.this, VMLDbindActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;

                }

                //Toast.makeText(MainActivity.this,  position + ", " + tv.getText(), Toast.LENGTH_SHORT).show();
            });
        }
    }

