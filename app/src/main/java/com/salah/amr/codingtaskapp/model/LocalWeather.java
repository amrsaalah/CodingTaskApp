package com.salah.amr.codingtaskapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.salah.amr.codingtaskapp.utils.Converters;

import java.util.List;

/**
 * Created by Amr Salah on 1/31/2018.
 */

@Entity
public class LocalWeather {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo
    private String city;

    @ColumnInfo
    private Double currentTemp;


    @ColumnInfo
    @TypeConverters(Converters.class)
    private List<LocalForecast> localForecasts;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }


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

    public List<LocalForecast> getLocalForecasts() {
        return localForecasts;
    }

    public void setLocalForecasts(List<LocalForecast> localForecasts) {
        this.localForecasts = localForecasts;
    }

    @Override
    public String toString() {
        return "LocalWeather{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", currentTemp=" + currentTemp +
                ", localForecasts=" + localForecasts +
                '}';
    }
}
