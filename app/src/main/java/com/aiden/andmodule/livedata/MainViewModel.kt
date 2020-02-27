package com.aiden.andmodule.livedata


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by admin on 2017-08-03.
 */
class MainViewModel : ViewModel(){

    var isSwitch : MutableLiveData<Boolean> = MutableLiveData()

    var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun increase() {
        counter.value = this.counter.value?.plus(1)
    }








}