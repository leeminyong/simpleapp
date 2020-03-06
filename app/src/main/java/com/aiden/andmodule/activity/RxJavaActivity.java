package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;

public class RxJavaActivity extends BaseActivity {

    String TAG = "RxJavaActivity";

    Observable<String> mObservable;//흐르는 물
    Observer<String> mObserver;//흐르는 물에서 onNext로 넘어온걸 받아온다.
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

         tv = findViewById(R.id.txt);
        mObservable = Observable.just("Hello from Rxandroid....!");
        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                tv.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
    public void onClick(View view) {
        mObservable.subscribe(mObserver);
        mObservable.just("Today is Firing Friday..").subscribe(s-> Toast.makeText(this, s, Toast.LENGTH_SHORT).show());


    }
}
