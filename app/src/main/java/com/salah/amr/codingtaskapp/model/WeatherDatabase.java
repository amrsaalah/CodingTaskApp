package com.salah.amr.codingtaskapp.model;

import java.util.List;

/**
 * Created by user on 1/31/2018.
 */

public class WeatherDatabase {

    private AppDatabase appDatabase;

    public WeatherDatabase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }


    public void addLocalWeather(LocalWeather localWeather){
        appDatabase.weatherDAO().insert(localWeather);
    }

    public void updateLocalWeather(LocalWeather localWeather){
        appDatabase.weatherDAO().update(localWeather);
    }

    public List<LocalWeather> getLocalWeathers(){
        return appDatabase.weatherDAO().getLocalWeathers();
    }

    public LocalWeather getLocalWeather(String city){
        return appDatabase.weatherDAO().getLocalWeatherByCity(city);
    }

}
