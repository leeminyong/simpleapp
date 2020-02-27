package com.aiden.andmodule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R
import kotlinx.android.synthetic.main.activity_find.*

class FindViewByeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        txt_2.text = "Hello"
        btn.setOnClickListener{
            LogUtil.e("FindViewByeAct","Click....")
        }

    }
}
