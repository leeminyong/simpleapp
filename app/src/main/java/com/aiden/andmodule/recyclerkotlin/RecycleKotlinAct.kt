package com.aiden.andmodule.recyclerkotlin

import android.os.Bundle

import android.util.Log
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiden.andmodule.R
import com.example.admin.kotlinlistexample.DummyData
import com.example.admin.kotlinlistexample.MainRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_recycler.*
import org.w3c.dom.Text


class RecycleKotlinAct : AppCompatActivity() {
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

        mainAdapter.setOnClickListener { i -> Log.e("RecycleKotlinAct","onClick = $i") }
        mainAdapter.addData(dummyData())
    }

    fun dummyData(): ArrayList<DummyData>{
        val datas: ArrayList<DummyData> = ArrayList()
        (1..50).forEach{
            datas.add(DummyData(it.toString()))
        }
        return datas
    }
}

