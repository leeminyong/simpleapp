package com.aiden.andmodule.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aiden.andmodule.R
import com.aiden.andmodule.databinding.ActivityliveBinding
import com.aiden.andmodule.livedata.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

//0227
class LiveDataActivity : AppCompatActivity() {
    lateinit var TAG: String

    private val disposables by lazy { CompositeDisposable() }

    lateinit var liveViewModel : MainViewModel
    private  lateinit var liveDataBing: ActivityliveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = javaClass.name.replace("$packageName", "")

        liveDataBing = DataBindingUtil.setContentView(this, R.layout.activitylive)
        liveViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        liveDataBing.lifecycleOwner = this

        liveDataBing.mliveModel = liveViewModel



    }

    fun addDisposable(disposable : Disposable?){
        disposables.add(disposable?:return)
    }
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}
