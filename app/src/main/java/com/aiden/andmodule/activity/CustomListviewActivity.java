package com.aiden.andmodule.activity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.MyFirstAdapter;
import com.aiden.andmodule.model.Weather;

import java.util.ArrayList;

public class CustomListviewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    MyFirstAdapter adapter;
    ListView listView;
    ArrayList<Weather> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomlistview);
       showData();

        adapter = new MyFirstAdapter(data);

        // 뷰
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //view.setBackgroundColor(Color.RED);
        adapter.setmSelectedPosition(position);
        adapter.notifyDataSetChanged();
    }
    private void showData(){
        data = new ArrayList<>();
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("서울", "26도", "비"));
        data.add(new Weather("안양", "24도", "구름"));
        data.add(new Weather("부산", "29도", "구름"));
        data.add(new Weather("인천", "23도", "맑음"));
        data.add(new Weather("대구", "28도", "비"));
        data.add(new Weather("용인", "25도", "비"));


    }
}
