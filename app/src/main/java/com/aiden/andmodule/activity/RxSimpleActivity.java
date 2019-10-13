package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aiden.andmodule.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxSimpleActivity extends AppCompatActivity {

    private Observable<String> mObservable;
    private Observer<String> mOnserver;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        txt = findViewById(R.id.txt);
        mObservable = Observable.just("Hello from Rxandroid....");
        mOnserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                 txt.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

    }

    public void subscribeNow(View view) {
        mObservable.subscribe(mOnserver);

    }
}
