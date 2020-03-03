package com.aiden.andmodule.Net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NewLand on 2017. 11. 7..
 */

public class GetRetrofit {

    String URL = "https://gist.githubusercontent.com/";
    private static GetRetrofit ourInstance = new GetRetrofit();
    public static GetRetrofit getInstance() {
        return ourInstance;
    }
    private GetRetrofit() {
    }

    Retrofit getrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

    RetrofitService service = getrofit.create(RetrofitService.class);

    public RetrofitService getService() {
        return service;
    }
}
