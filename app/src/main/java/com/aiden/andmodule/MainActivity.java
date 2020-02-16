package com.aiden.andmodule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.activity.BottomSheetActivity;
import com.aiden.andmodule.activity.ButtonActivity;
import com.aiden.andmodule.activity.ConstLayout;
import com.aiden.andmodule.activity.CustomListviewActivity;
import com.aiden.andmodule.activity.DBRecyclerActivity;
import com.aiden.andmodule.activity.DataBindingAct;
import com.aiden.andmodule.activity.DataBindingActivity;
import com.aiden.andmodule.activity.DialogActivity;
import com.aiden.andmodule.activity.GridviewActivity;
import com.aiden.andmodule.activity.LiveDataRoomAct;
import com.aiden.andmodule.activity.OkHttpActivity;
import com.aiden.andmodule.activity.RecycleGridAct;
import com.aiden.andmodule.activity.RetroJsonAct;
import com.aiden.andmodule.activity.RoomAct;
import com.aiden.andmodule.activity.RxBindingAct;
import com.aiden.andmodule.activity.RxJavaActivity;
import com.aiden.andmodule.activity.SimpleOkHttpAct;
import com.aiden.andmodule.activity.TTSActivity;
import com.aiden.andmodule.activity.TabHostActivity;
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
import com.aiden.andmodule.activity.ViewModelActivity;
import com.aiden.andmodule.activity.WebActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    //2020.01.03
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> menuNames;
        LogUtil.e(TAG,"onCreate..");
            // 데이터 준비
        menuNames = new ArrayList<String>();
        //0.
        menuNames.add("Groupbtn");
        //1.
        menuNames.add("BottomSheetDialog");
        //2.
        menuNames.add("DBListview");
        //3.
        menuNames.add("데이터저장");
        //4.
        menuNames.add("WebView");
        //5.
        menuNames.add("Toogle");
        //6.
        menuNames.add("TabHost");
        //7.
        menuNames.add("ConsLayout");
        //8.
        menuNames.add("Databinding");
        //9.
        menuNames.add("Listview");
        //10.
        menuNames.add("CustomListview");
        //11.
        menuNames.add("MultiDelListView");
        //12.
        menuNames.add("RecyclerView");
        //13.
        menuNames.add("Imvoca");
        //14.
        menuNames.add("Rxandroid");
        //15.
        menuNames.add("Button UI");
        //16.
        menuNames.add("KotlinTest");
        //17.
        menuNames.add("DataBinding");
        //18.
        menuNames.add("DialogBox");
        //19.
        menuNames.add("OkHttp");
        //20.
        menuNames.add("Room");
        //21.
        menuNames.add("LiveDataRoom");
        //22.
        menuNames.add("ViewModel");
        //23.
        menuNames.add("RxJava");
        //24.
        menuNames.add("RxBinding");
        //25.
        menuNames.add("SimpleOKhttp");
        //26.
        menuNames.add("JsonRetroift");
        //27.
        menuNames.add("TTS Test");
        //28.
        menuNames.add("GridView");
        //29
        menuNames.add("RecyclerGrid");
        menuNames.add("DataBinding");

        ListAdapter adapter = new ArrayAdapter<>(this,R.layout.list_item, R.id.lable, menuNames);
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
                        intent = new Intent(MainActivity.this, TabHostActivity.class);
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
                    case 18:
                        intent = new Intent(MainActivity.this, DialogActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 19:
                        intent = new Intent(MainActivity.this, OkHttpActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 20:
                        intent = new Intent(MainActivity.this, RoomAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 21:
                        intent = new Intent(MainActivity.this, LiveDataRoomAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 22:
                        intent = new Intent(MainActivity.this, ViewModelActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 23:
                        intent = new Intent(MainActivity.this, RxJavaActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 24:
                        intent = new Intent(MainActivity.this, RxBindingAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 25:
                        intent = new Intent(MainActivity.this, SimpleOkHttpAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case 26:
                        intent = new Intent(MainActivity.this, RetroJsonAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                      //TTSActivity
                    case 27:
                        intent = new Intent(MainActivity.this, TTSActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    //GridviewActivity
                    case 28:
                        intent = new Intent(MainActivity.this, GridviewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    //RecycleGridAct
                    case 29:
                        intent = new Intent(MainActivity.this, RecycleGridAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    //RecycleGridAct
                    case 30:
                        intent = new Intent(MainActivity.this, DataBindingAct.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;

                }

                //Toast.makeText(MainActivity.this,  position + ", " + tv.getText(), Toast.LENGTH_SHORT).show();
            });
        }
    }

