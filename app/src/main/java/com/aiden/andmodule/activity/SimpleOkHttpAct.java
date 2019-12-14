package com.aiden.andmodule.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SimpleOkHttpAct extends AppCompatActivity {

    static  String TAG = "OkHttpActivity";

    static TextView txtMsg;
    static Weather weatherData;
    static List<Weather> webActivityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_okhttp);
        txtMsg = findViewById(R.id.context);


        new HttpAsynTask().execute("https://mqtalk.hackers.com/?m=api&a=auth_logkey&log_key=82430db8574d8effe518b54ec70d72feac5a4a0e9b9315fcf2a7f01a871dcca3");
    }

    private  static  class HttpAsynTask extends AsyncTask<String, Void ,String >{
        OkHttpClient client = new OkHttpClient();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMsg.setText("Loading......");
        }
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
                result = response.body().string();
                LogUtil.e(TAG,"List--------------->"+response.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return  result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null) {
                LogUtil.e(TAG, "onPostExecute() "+webActivityList.toString());
                    txtMsg.setText(s);
            }

        }
    }


}
