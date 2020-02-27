package com.aiden.andmodule.livedata


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aiden.andmodule.LogUtil
import com.aiden.andmodule.R
import com.aiden.andmodule.databinding.ActivityliveBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activitylive.*

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


        dialog_main_switch.setOnCheckedChangeListener{ _, b : Boolean ->
            liveViewModel.isSwitch.value = b
            LogUtil.e(TAG, "변경한 값--->$b")
        }
        /*
        btn_counter.setOnClickListener{it->
            liveViewModel.increase()
            LogUtil.e(TAG, "증가한  값--->$it")
        }

        liveViewModel.counter.observe(this as LifecycleOwner, Observer { t ->
            count_txt.text = Integer.toString(t)
        })
        */

        liveViewModel.isSwitch.observe(this as LifecycleOwner, Observer { t ->
            main_test_txt.text = t.toString()
        })
    }

    fun addDisposable(disposable : Disposable?){
        disposables.add(disposable?:return)
    }
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}
