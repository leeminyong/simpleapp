package com.aiden.andmodule.model;

/**
 * Created by junsuk on 2017. 6. 22..
 */

public class Weather {
    private String country;        // 도시명
    private String weather;     // 날씨 (맑음, 비, 구름, 눈)
    private String temp;        // 기온

    public Weather(String city, String temp, String weather) {
        this.country = city;
        this.temp = temp;
        this.weather = weather;
    }

    public String getCity() {
        return country;
    }

    public void setCity(String city) {
        this.country = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("country='").append(country).append('\'');
        sb.append(", temp='").append(temp).append('\'');
        sb.append(", weather='").append(weather).append('\'');
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
}
