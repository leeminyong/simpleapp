package com.aiden.andmodule.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    public MutableLiveData<Integer> counter = new MutableLiveData<>();
    public  CounterViewModel(){
        counter.setValue(0);
    }

    public  void increase(){
        counter.setValue(counter.getValue()+1);
    }
    public  void decrease(){
        counter.setValue(counter.getValue()-1);
    }



}
