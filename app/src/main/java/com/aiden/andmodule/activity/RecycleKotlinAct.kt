package com.aiden.andmodule.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R
import com.example.admin.kotlinlistexample.DummyData
import com.example.admin.kotlinlistexample.MainRecyclerAdapter


/**
 * 2020.02.29
 */
class RecycleKotlinAct : BaseKtActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val mainAdapter = MainRecyclerAdapter()
        var recyclerview :RecyclerView = findViewById(R.id.mrecyclerview)
        recyclerview.apply{
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@RecycleKotlinAct)
            addItemDecoration((DividerItemDecoration(this@RecycleKotlinAct,LinearLayoutManager.VERTICAL)))
        }

        /*
        recyclerview.adapter = mainAdapter
        recyclerview.layoutManager = LinearLayoutManager(this@RecycleKotlinAct)
        recyclerview.addItemDecoration((DividerItemDecoration(this@RecycleKotlinAct,LinearLayoutManager.VERTICAL)))
        */

        mainAdapter.setOnClickListener { i -> LogUtil.e("RecycleKotlinAct","onClick = $i") }
        mainAdapter.addData(dummyData())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.code_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_setting) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(sourceUrl + javaClass.simpleName + ".kt")))
        }
        return super.onOptionsItemSelected(item)
    }

    fun dummyData(): ArrayList<DummyData>{
        val datas: ArrayList<DummyData> = ArrayList()
        (1..50).forEach{
            datas.add(DummyData(it.toString()))
        }
        return datas
    }
}

