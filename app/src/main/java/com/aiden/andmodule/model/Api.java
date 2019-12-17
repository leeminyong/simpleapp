package com.aiden.andmodule.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 2018-03-21.
 */

public interface Api {


    @GET("json4.html")
    Call<ArrayList<Weath>> getUrlWeather();

}
