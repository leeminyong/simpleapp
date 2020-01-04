package com.aiden.andmodule.activity

import android.content.Context
import com.google.android.material.snackbar.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Created by admin on 2017-10-20.
 */
fun View.showSnackBar(message : String, duration : Int){
    Snackbar.make(this,message,duration).show()
}
fun Context.showToast(message: String, duration: Int){
    Toast.makeText(this,message,duration).show()
}