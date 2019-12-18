package com.aiden.andmodule.activity

import android.os.Bundle
import com.aiden.andmodule.R


import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_rxbinding.*

class RxBindingAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxbinding)

        button.clicks().subscribe{drawer_layout.showSnackBar("Hello word....", Snackbar.LENGTH_SHORT)
        }.let { disposables.add(it) }
    }
}