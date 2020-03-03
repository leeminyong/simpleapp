package com.aiden.andmodule.activity;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;
import com.aiden.andmodule.model.Api;
import com.aiden.andmodule.model.Weath;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroJsonAct extends AppCompatActivity {
    String BASE_URL = "http://hackers.gscdn.com/app/";
    ArrayList<Weath> repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_json);

        TextView txtResult = findViewById(R.id.txt_message);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        Call<ArrayList<Weath>> call = api.getUrlWeather();
        call.enqueue(new  Callback<ArrayList<Weath>>() {
            @Override
            public void onResponse(Call<ArrayList<Weath>> call, Response<ArrayList<Weath>> response) {
                LogUtil.e("Retrofit", response.toString());
                repo = response.body();
                LogUtil.e("repo-->", response.body().toString());
                if (response.body() != null) {
                    for(int i=0;i<repo.size();i++) {
                        txtResult.append("\n"+(i+1)+". 나라:"+response.body().get(i).getCountry()+"/"+
                                "날씨:"+response.body().get(i).getWeather()+"/"+"온도:"+response.body().get(i).getTemperature());
                    }

                }
            }
            @Override
            public void onFailure(Call<ArrayList<Weath>> call, Throwable t) {
                Log.e("Err", t.getMessage());
            }
        });
    }
}
