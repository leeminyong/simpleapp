package com.aiden.andmodule.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.StdRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements StdRecyclerAdapter.OnListItemLongSelectedInterface
        , StdRecyclerAdapter.OnListItemSelectedInterface{

    String TAG = "RecyclerViewActivity";


    RecyclerView recyclerView;
    StdRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_recyclerview);
        init();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.e(TAG,"회전값--->"+newConfig.orientation);

        if (newConfig.orientation == newConfig.ORIENTATION_PORTRAIT) // 세로 전환시

        {
            LogUtil.e(TAG,"세로:    Portrait");
        }
        else if (newConfig.orientation == newConfig.ORIENTATION_LANDSCAPE)// 가로 전환시

        {
            LogUtil.e(TAG,"가로:      landscape");
        }
    }

    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> dataSet = new ArrayList<String>();

        int row = 1;
        for ( int i = 0; i < 3 ; i++) {
            dataSet.add("<" + row++ + ">" + "C/C++");
            dataSet.add("<" + row++ + ">" + "Java");
            dataSet.add("<" + row++ + ">" + "Kotlin");
            dataSet.add("<" + row++ + ">" + "Python");
            dataSet.add("<" + row++ + ">" + "Ruby");
        }

         mAdapter = new StdRecyclerAdapter(this, recyclerView, this,this);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setData(dataSet);

        // 기본 구분선 추가
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(),new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.clearSelectedItem();
                //LogUtil.e(TAG,"해지한  갯수--->"+mAdapter.getCountItem());
            }
        });
    }

    @Override
    public void onItemSelected(View v, int position) {
        StdRecyclerAdapter.StdViewHolder viewHolder = (StdRecyclerAdapter.StdViewHolder)recyclerView.findViewHolderForAdapterPosition(position);

        Toast.makeText(this, viewHolder.textView.getText().toString(), Toast.LENGTH_SHORT).show();
        LogUtil.e(TAG,"선택한것--->"+position);
        LogUtil.e(TAG,"남은   갯수--->"+mAdapter.getCountItem());
//        Toast.makeText(this, position + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongSelected(View v, int position) {
        Toast.makeText(this, position + " long clicked", Toast.LENGTH_SHORT).show();
    }


    public void onSell(View view) {
        mAdapter.allSelectedItem();
        LogUtil.e(TAG,"선택한 갯수--->"+mAdapter.getCountItem());


    }

    public void onDel(View view) {
    }
}
