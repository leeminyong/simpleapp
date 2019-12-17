package com.aiden.andmodule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weath {
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("weather")
    @Expose
    private String weather;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
