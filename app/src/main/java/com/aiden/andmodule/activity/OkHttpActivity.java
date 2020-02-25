package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.model.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static io.reactivex.Observable.fromCallable;

public class OkHttpActivity extends AppCompatActivity {

    static String TAG = "OkHttpActivity";

    static TextView txtMsg;
    static Weather weatherData;
    static List<Weather> webActivityList = new ArrayList<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        txtMsg = findViewById(R.id.context);



        OkHttpClient client = new OkHttpClient();
        Disposable disposable =fromCallable(() -> {
            String data = null;
            Request request = new Request.Builder()
                    .url("https://goo.gl/eIXu9l")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                JSONArray jsonArray = new JSONArray(response.body().string());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String counter = jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");
                    weatherData = new Weather(counter, weather, temperature);
                    webActivityList.add(weatherData);
                }
                return webActivityList;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.e(TAG, "List--------------->" + webActivityList.size());
            return false;
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(result -> {
            Log.d("HttpAsyncTask", result.toString());
            if (result != null) {
                LogUtil.e(TAG, "onPostExecute() " + result.toString());
                for (Weather w : (List<Weather>) result) {
                    txtMsg.append("country:" + w.getCity() +
                            "/ weather:" + w.getWeather() +
                            "/ temperature:" + w.getTemp() +
                            "\n");
                }
            }
        });

        compositeDisposable.add(disposable); //IDE is satisfied that the Disposable is being managed.

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
