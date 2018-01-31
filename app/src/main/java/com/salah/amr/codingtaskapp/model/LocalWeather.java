package com.salah.amr.codingtaskapp.model;

import java.util.List;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class LocalWeather {
    String city;
    Double currentTemp;
    List<Double> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public List<Double> getForecast() {
        return forecast;
    }

    public void setForecast(List<Double> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "LocalWeather{" +
                "city='" + city + '\'' +
                ", currentTemp=" + currentTemp +
                ", forecast=" + forecast +
                '}';
    }
}
