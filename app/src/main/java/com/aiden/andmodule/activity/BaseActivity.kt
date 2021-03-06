package com.aiden.andmodule.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.aiden.andmodule.R

/**
 * 2020.01.03... start
 */
open class BaseActivity : AppCompatActivity(){

    public var sourceUrl = "https://github.com/leeminyong/simpleapp/blob/master/app/src/main/java/com/aiden/andmodule/activity/"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.code_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_setting) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(sourceUrl + javaClass.simpleName + ".java")))
        }
        return super.onOptionsItemSelected(item)
    }
}