package com.salah.amr.codingtaskapp.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 1/31/2018.
 */

public interface FeedAPI {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "05a1b2a507005511dd6a8813391d6399";

    @GET("weather?appid="+API_KEY)
    Single<WeatherModel> getCurrentWeatherByName(@Query("q") String cityName);

    @GET("forecast?appid="+API_KEY)
    Single<WeatherModel>getForecastByName(@Query("q") String cityName);
}
