package com.aiden.andmodule.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R


import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_rxbinding.*

class RxBindingAct : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxbinding)

        val name = intent.getStringExtra("name")
        val height = intent.getIntExtra("height",0)

        LogUtil.e("RxBinding","name-->$name, height->$height")


        button.clicks().subscribe{
            drawer_layout.showSnackBar("Hello word....", Snackbar.LENGTH_SHORT)
        }.let { LogUtil.e("ss","Hi rxbinding......") }
    }
}

