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

public class RxJavaActivity extends AppCompatActivity {

    String TAG = "RxJavaActivity";

    Observable<String> mObservable;
    Observer<String> mObserver;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

         tv = (TextView) findViewById(R.id.txt);
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

        mObservable.subscribe((s-> LogUtil.e(TAG,"새로운 데이터..............")));
    }
}
