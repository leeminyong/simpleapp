package com.aiden.andmodule.Net;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface UserService {

    @GET("users/{user}/repos")
    Call<ArrayList<JsonObject>> getListRepos(@Path("user") String id);


    @GET("junsuk5/6b293ac781b038366419ac6e4027abb7/raw/b30deab47a9d2fd04247d9d912df3a9a4f7be8a9/weather.json")
    Call<ArrayList<JsonObject>> get_data();

    @GET
    public Call<ResponseBody> profilePicture(@Url String url);
}
