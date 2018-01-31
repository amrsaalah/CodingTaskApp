package com.salah.amr.codingtaskapp.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 1/31/2018.
 */

public class OpenWeatherAPI {

    private static final String TAG = "OpenWeatherAPI";

    FeedAPI feedAPI;

    @Inject
    public OpenWeatherAPI(FeedAPI feedAPI) {
        this.feedAPI = feedAPI;
    }

    public void getCurrentWeather(SingleObserver<WeatherModel> consumer, String name) {
        Log.d(TAG, "getCurrentWeather: ");
        feedAPI.getCurrentWeatherByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public Single<List<Double>> getForecast(String name) {
        Log.d(TAG, "getForecast: ");
       return feedAPI.getForecastByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(weatherModel -> {
                    List<Double> doubles = new ArrayList<>();
                    for (int i = 0; i < weatherModel.getForecastList().length; i++) {
                        doubles.add(weatherModel.getForecastList()[i].getMain().getTemp());
                    }
                    return Single.just(doubles);
                });
    }


}

