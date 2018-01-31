package com.salah.amr.codingtaskapp.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by user on 7/25/2017.
 */

public class WeatherModel {
    private String name;
    private Main main;
    private Weather[] weather;
    private City city;
    @SerializedName("list")
    private ForecastList[] forecastList;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public ForecastList[] getForecastList() {
        return forecastList;
    }

    public void setForecastList(ForecastList[] forecastList) {
        this.forecastList = forecastList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "name='" + name + '\'' +
                ", main=" + main +
                ", weather=" + Arrays.toString(weather) +
                ", city=" + city +
                ", forecastList=" + Arrays.toString(forecastList) +
                '}';
    }
}
