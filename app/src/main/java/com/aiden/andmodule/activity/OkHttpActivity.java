package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    static  String TAG = "OkHttpActivity";

    static TextView txtMsg;
    static Weather weatherData;
    static List<Weather> webActivityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_okhttp);
        txtMsg = findViewById(R.id.context);


        new HttpAsynTask().execute("https://goo.gl/eIXu9l");
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                int counter = 0;
                while (true) {
                    LogUtil.e("AsyncTask", "count: " + counter);
                    counter ++;
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
*/

@Override
    public void onStart() {
        super.onStart();
        /*
        Observable.fromCallable(() -> {
            int counter = 0;
            while (true) {
                LogUtil.e("RxJava", "count: " + counter);
                counter ++;
            }
        }).subscribeOn(Schedulers.computation()).subscribe();

        */
    }

    private  static  class HttpAsynTask extends AsyncTask<String, Void ,String >{
        OkHttpClient client = new OkHttpClient();
        @Override
        protected String doInBackground(String... params) {
             webActivityList = new ArrayList<>();

            String result = null;
            String strUrl = params[0];


            try {
                Request request = new Request.Builder()
                        .url(strUrl)
                        .build();
                Response response = client.newCall(request).execute();
                //result = response.body().string();

                JSONArray jsonArray = new JSONArray(response.body().string());
                for(int i=0; i < jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String counter = jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");
                    weatherData = new Weather(counter,weather,temperature);
                    webActivityList.add(weatherData);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //LogUtil.e(TAG,"List--------------->"+webActivityList.toString());
            result =webActivityList.toString();

            return  result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null) {
                LogUtil.e(TAG, "onPostExecute() "+webActivityList.toString());
                for(Weather w : webActivityList) {
                    txtMsg.append("country:" + w.getCity() +
                            "/ weather:" + w.getWeather() +
                            "/ temperature:" + w.getTemp() +
                            "\n");
                }


            }

        }
    }


}
