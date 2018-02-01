package com.salah.amr.codingtaskapp.widget;

import android.util.Log;

import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;
import com.salah.amr.codingtaskapp.utils.UnitsConverter;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public class WidgetPresenter implements IWidget.presenter {

    private static final String TAG = "WidgetPresenter";

    private IWidget.view view;
    private OpenWeatherAPI openWeatherAPI;
    private WeatherSharedPreferences preferences;

    @Inject
    public WidgetPresenter(IWidget.view view , OpenWeatherAPI openWeatherAPI , WeatherSharedPreferences preferences) {
        this.view = view;
        this.openWeatherAPI = openWeatherAPI;
        this.preferences = preferences;
    }

    @Override
    public void getCurrentTemp(String city) {
        Log.d(TAG, "getCurrentTemp: "+city);
        preferences.setWidgetCity(city);
        openWeatherAPI.getCurrentWeather(city).subscribe(new SingleObserver<Double>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onSuccess(Double aDouble) {
                if(preferences.getUnitsType().equals("0")){
                    preferences.setWidgetTemp(UnitsConverter.kelvinToCelsius(aDouble));
                }else {
                    preferences.setWidgetTemp(UnitsConverter.kelvinToFahrenheit(aDouble));
                }
                Log.d(TAG, "onSuccess: "+aDouble);
                view.updateWidget();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }
        });
    }
}
