package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

public class TabHostActivity extends BaseActivity  {


    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("TAB 1") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("TAB 2") ;
        tabHost1.addTab(ts2) ;



        for (int i = 0; i < tabHost1.getTabWidget().getChildCount(); i++) {
            tabHost1.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")); // unselected
            TextView tv = (TextView) tabHost1.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
            tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setTextSize(40);
        }

        tabHost1.getTabWidget().getChildAt(tabHost1.getCurrentTab()).setBackgroundColor(Color.parseColor("#0000FF")); // selected
        TextView tv = (TextView) tabHost1.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
        tv.setTextColor(Color.parseColor("#000000"));

        tabHost1.setOnTabChangedListener(tabId -> {

            int id = tabHost1.getCurrentTab();

            if (id == 0) {
                // your method 1
                LogUtil.e("TabHostActivity","tab  1 ");
            }
            else if (id ==1) {
                // your method 2
                LogUtil.e("TabHostActivity","tab  2 ");
            }

            for (int i = 0; i < tabHost1.getTabWidget().getChildCount(); i++) {
                tabHost1.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")); // unselected
                TextView tv2 = (TextView) tabHost1.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                tv2.setTextColor(Color.parseColor("#ffffff"));
            }

            tabHost1.getTabWidget().getChildAt(tabHost1.getCurrentTab()).setBackgroundColor(Color.parseColor("#0000FF")); // selected
            TextView tv3 = (TextView) tabHost1.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
            tv3.setTextColor(Color.parseColor("#000000"));

        });



    }


}




