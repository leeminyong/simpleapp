package com.aiden.andmodule.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by admin on 2017-10-17.
 */
open class BaseActivity : AppCompatActivity(),LifecycleOwner{
    protected val disposables by lazy { CompositeDisposable() }
    protected val analytics by lazy { FirebaseAnalytics.getInstance(this) }
    private val registry : LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = registry
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}