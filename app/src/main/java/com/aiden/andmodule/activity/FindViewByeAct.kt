package com.aiden.andmodule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_find.*

class FindViewByeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        txt_2.text = "Hello"
        btn.setOnClickListener{
            LogUtil.e("FindViewByeAct","Click....")
        }

        val list:List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
        val observable: Observable<Any> = list.toObservable(); //1

        observable.subscribeBy(  // 2 named arguments for lambda Subscribers
                onNext = { println(it) },
                onError =  { it.printStackTrace() },
                onComplete = { println("Done!") }
        )

    }
}
