package com.salah.amr.codingtaskapp.model;

import android.util.Log;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
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

    public Single<Double> getCurrentWeather(String city) {
        Log.d(TAG, "getCurrentWeather: ");
        return feedAPI.getCurrentWeatherByName(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(weatherModel -> {
                    Double currentTemp;
                    currentTemp = weatherModel.getMain().getTemp();
                    return Single.just(currentTemp);
                });
    }

    public Single<List<LocalForecast>> getForecast(String name) {
        Log.d(TAG, "getForecast: ");
        return feedAPI.getForecastByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(weatherModel -> {
                    List<LocalForecast> forecasts = new ArrayList<>();
                    for (int i = 0; i < weatherModel.getForecastList().length; i++) {
                        if (i % 8 == 0) {
                            LocalForecast localForecast = new LocalForecast();
                            localForecast.setMinTemp(weatherModel.getForecastList()[i].getMain().getMinTemp());
                            localForecast.setMaxTemp(weatherModel.getForecastList()[i].getMain().getMaxTemp());
                            forecasts.add(localForecast);
                        }
                    }
                    return Single.just(forecasts);
                });
    }


}




