package com.aiden.andmodule.livedata


import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by admin on 2017-08-03.
 */
class MainViewModel : ViewModel(){

    val name = ObservableField("")

    var isSwitch : MutableLiveData<Boolean> = MutableLiveData()

    var counter = MutableLiveData<Int>()

    init {

        isSwitch.value = false
        counter.value = 0
        name.set(initName())
    }

    private fun initName() :String = "Aiden"

    fun increase() {
        counter.value = this.counter.value?.plus(1)
    }

    fun nameClick() = name.set("Click!!")

    fun onCheckedChanged(checked: Boolean) { // implementation

         isSwitch.value  = checked
    }








}