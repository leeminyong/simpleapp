package com.aiden.andmodule.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.aiden.andmodule.Net.NetRetrofit;
import com.aiden.andmodule.R;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NewLand on 2017. 11. 7..
 */

public class RetroMainAct extends BaseActivity {
    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrotest_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.code_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getSourceUrl()+getClass().getSimpleName()+".java")));
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSearch(View view) {
        String id = editText.getText().toString();
        if (!id.isEmpty()) {
            Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getListRepos(id);
            res.enqueue(new Callback<ArrayList<JsonObject>>() {
                @Override
                public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                    Log.e("Retrofit  응답값 ==>", response.toString());
                       if(response.isSuccessful()){
                           textView.setText("Successufl::"+response.body().toString());
                           Log.e("Retrofit  응답 결과 ==>", response.body().toString());
                       }
                        else
                        textView.setText("response of message: "+response.toString());
                }
                @Override
                public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                    Log.e("Err", t.getMessage());
                    textView.setText("Fail message : "+t.getMessage());
                }
            });
        } else
            Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
    }

    public void onGet(View view) {
            Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().get_data();
            res.enqueue(new Callback<ArrayList<JsonObject>>() {
                @Override
                public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                    Log.e("Retrofit  응답값 ==>", response.toString());
                    if (response.isSuccessful()) {
                        textView.setText(response.body().toString());
                        Log.e("Retrofit  응답 결과 ==>", response.body().toString());

                    }
                    else
                        textView.setText("");
                }
                @Override
                public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                    Log.e("Err", t.getMessage());
                }
            });
        }

    }

