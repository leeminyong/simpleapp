package com.aiden.andmodule.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {
    val TAG = "KotlinActivity"

    private  val disposables by lazy{ CompositeDisposable()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        var map = mapOf(Pair("name","age"))
        var map2 = mutableMapOf<String,String>()
        map2.put("minyong","32")

        for(map in map2){
            LogUtil.e(TAG,"$map.value")
            LogUtil.e(TAG,"$map.key")


        }


        test()

        button.clicks().subscribe{
            LogUtil.e(TAG,"Clcick.........................")
            txt.text = "Click...."
        }.let {
            disposables.addAll(it)
        }
        var arr1 = listOf("1","2","3","4","5","6")
        var arr2 = mutableListOf("1",'2')
        for(item in arr1){
            LogUtil.e(TAG,"$arr1")
        }

        for((index,item)in arr1.withIndex()){
            LogUtil.e(TAG,"$index ,$item")

        }
        var hello:Any = "hello"
        if(hello is String) {
            var str  = hello
            LogUtil.e(TAG,"munja--->$str")
        }



    }
    private val temp: String by lazy {
        LogUtil.e(TAG,"subject initalized!!!")
        "temp test...."

    }

    fun test(){
        LogUtil.e(TAG,"Not Initalize..")
        LogUtil.e(TAG,"subject one : $temp")
        LogUtil.e(TAG,"subject two : $temp")
        LogUtil.e(TAG,"subject three : $temp")

        var cls = HelloClass(2)

    }

    class  HelloClass{
        var age:Int = 0
        init {

        }

        constructor()
        constructor(age:Int){
            this.age = age
        }
    }

}
