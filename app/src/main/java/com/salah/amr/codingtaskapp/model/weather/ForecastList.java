package com.salah.amr.codingtaskapp.model.weather;

/**
 * Created by user on 8/26/2017.
 */

public class ForecastList {
    Main main;
    Weather [] weather;

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
}
