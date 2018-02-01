package com.salah.amr.codingtaskapp.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by user on 1/31/2018.
 */

@Dao
public interface WeatherDAO {

    @Query("select * from localweather")
    List<LocalWeather> getLocalWeathers();

    @Query("select * from localweather where city = :city")
    LocalWeather getLocalWeatherByCity(String city);

    @Insert
    void insert(LocalWeather localWeather);

    @Delete
    void delete(LocalWeather localWeather);

    @Update
    void update(LocalWeather localWeather);
}
