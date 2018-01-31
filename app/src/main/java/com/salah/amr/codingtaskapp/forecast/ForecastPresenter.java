package com.salah.amr.codingtaskapp.forecast;

import android.util.Log;

import com.salah.amr.codingtaskapp.base.BaseView;
import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class ForecastPresenter implements IForecast.presenter {

    private static final String TAG = "ForecastPresenter";
    
    private IForecast.view view;
    private OpenWeatherAPI openWeatherAPI;
    private ForecastAdapter adapter;

    @Inject
    public ForecastPresenter(BaseView view , OpenWeatherAPI openWeatherAPI , ForecastAdapter adapter) {
        this.view = (IForecast.view) view;
        this.openWeatherAPI = openWeatherAPI;
        this.adapter = adapter;
    }

    @Override
    public void loadForecast(String city) {
        openWeatherAPI.getForecast(city).subscribe(new SingleObserver<List<LocalForecast>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onSuccess(List<LocalForecast> localForecasts) {
                adapter.setLocalForecasts(localForecasts);
                view.showList(adapter);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }
        });

    }
}
