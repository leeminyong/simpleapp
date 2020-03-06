package com.aiden.andmodule.activity

import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.aiden.andmodule.R
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.disposables.CompositeDisposable

/**
 * 2020.01.03... start
 */
open class BaseKtActivity : AppCompatActivity(){

    public var sourceUrl = "https://github.com/leeminyong/simpleapp/blob/master/app/src/main/java/com/aiden/andmodule/activity/"

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
}