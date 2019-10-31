package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    static  String TAG = "OkHttpActivity";

    static TextView txtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_okhttp);
        txtMsg = findViewById(R.id.context);


        new HttpAsynTask().execute("http://goo.gl/eIXu9l");
    }

    private  static  class HttpAsynTask extends AsyncTask<String, Void ,String >{
        OkHttpClient client = new OkHttpClient();
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];
            Request request = new Request.Builder()
                    .url(strUrl)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                //LogUtil.e(TAG, "doinbackground"+response.body().string());
                result = response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return  result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null) {
                LogUtil.e(TAG, s);
                txtMsg.setText(s);


            }

        }
    }


}
