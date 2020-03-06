package com.aiden.andmodule.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TabHost
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R

class TabKotlinActivity : AppCompatActivity() {


    private val button: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val tabHost1 = findViewById<View>(R.id.tabHost1) as TabHost
        tabHost1.setup()

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        val ts1 = tabHost1.newTabSpec("Tab Spec 1")
        ts1.setContent(R.id.content1)
        ts1.setIndicator("TAB 1")
        tabHost1.addTab(ts1)

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        val ts2 = tabHost1.newTabSpec("Tab Spec 2")
        ts2.setContent(R.id.content2)
        ts2.setIndicator("TAB 2")
        tabHost1.addTab(ts2)



        for (i in 0 until tabHost1.tabWidget.childCount) {
            tabHost1.tabWidget.getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")) // unselected
            val tv = tabHost1.tabWidget.getChildAt(i).findViewById<View>(android.R.id.title) as TextView //Unselected Tabs
            tv.setTextColor(Color.parseColor("#ffffff"))
            tv.textSize = 40f
        }
        tabHost1.tabWidget.getChildAt(tabHost1.currentTab).setBackgroundColor(Color.parseColor("#0000FF")) // selected
        val tv = tabHost1.currentTabView!!.findViewById<View>(android.R.id.title) as TextView //for Selected Tab
        tv.setTextColor(Color.parseColor("#000000"))

        tabHost1.setOnTabChangedListener { tabId ->

            val id = tabHost1.currentTab

            if (id == 0) {
                // your method 1
                LogUtil.e("TabHostActivity", "tab  1 ")
            } else if (id == 1) {
                // your method 2
                LogUtil.e("TabHostActivity", "tab  2 ")
            }
            for (i in 0 until tabHost1.tabWidget.childCount) {
                tabHost1.tabWidget.getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")) // unselected
                val tv2 = tabHost1.tabWidget.getChildAt(i).findViewById<View>(android.R.id.title) as TextView //Unselected Tabs
                tv2.setTextColor(Color.parseColor("#ffffff"))
            }
            tabHost1.tabWidget.getChildAt(tabHost1.currentTab).setBackgroundColor(Color.parseColor("#0000FF")) // selected

        }

    }


}




