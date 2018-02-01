package com.salah.amr.codingtaskapp.main;

import android.util.Log;

import com.salah.amr.codingtaskapp.base.BaseView;
import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.LocalWeather;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;
import com.salah.amr.codingtaskapp.model.WeatherDatabase;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;
import com.salah.amr.codingtaskapp.utils.UnitsConverter;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class MainPresenter implements IMain.presenter {

    private static final String TAG = "MainPresenter";

    private IMain.view view;
    private OpenWeatherAPI openWeatherAPI;
    private MainAdapter mainAdapter;
    private WeatherDatabase weatherDatabase;
    private WeatherSharedPreferences preferences;

    @Inject
    public MainPresenter(BaseView view, OpenWeatherAPI openWeatherAPI, MainAdapter mainAdapter, WeatherDatabase weatherDatabase, WeatherSharedPreferences preferences) {
        this.view = (IMain.view) view;
        this.openWeatherAPI = openWeatherAPI;
        this.mainAdapter = mainAdapter;
        this.weatherDatabase = weatherDatabase;
        this.preferences = preferences;
    }

    @Override
    public void initDatabase() {
        if (!preferences.getInitDatabase()) {
            Log.d(TAG, "initDatabase: ");
            String[] cities = {"Roma", "Madrid", "London", "Moscow", "Cairo"};
            for (int i = 0; i < cities.length; i++) {
                LocalWeather localWeather = new LocalWeather();
                localWeather.setCity(cities[i]);
                weatherDatabase.addLocalWeather(localWeather);
            }
            preferences.setInitDatabase(true);
        }
    }

    @Override
    public void addCity(String city) {
        openWeatherAPI.getCurrentWeather(city).subscribe(new SingleObserver<Double>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Double aDouble) {
                LocalWeather localWeather = new LocalWeather();
                localWeather.setCity(city);
                weatherDatabase.addLocalWeather(localWeather);
                view.navigateToMainActivity();
            }

            @Override
            public void onError(Throwable e) {
                view.showError();
            }
        });
    }

    @Override
    public void updateWidget() {
        String city = preferences.getWidgetCity();
        openWeatherAPI.getCurrentWeather(city).subscribe(new SingleObserver<Double>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onSuccess(Double aDouble) {
                if(preferences.getUnitsType().equals("0")){
                    preferences.setWidgetTemp(UnitsConverter.kelvinToCelsius(aDouble));
                }else {
                    preferences.setWidgetTemp(UnitsConverter.kelvinToFahrenheit(aDouble));
                }
                view.sendBroadcastToWidget();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void getCurrentTemp(Boolean internet) {
        if (internet) {
            for (int i = 0; i < weatherDatabase.getLocalWeathers().size(); i++) {
                int temp = i;
                openWeatherAPI.getCurrentWeather(weatherDatabase.getLocalWeathers().get(i).getCity()).subscribe(new SingleObserver<Double>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onSuccess(Double aDouble) {

                        LocalWeather localWeather = weatherDatabase.getLocalWeathers().get(temp);
                        localWeather.setCurrentTemp(aDouble);

                        weatherDatabase.updateLocalWeather(localWeather);

                        mainAdapter.addWeather(localWeather);
                        view.showList(mainAdapter);
                    }
                    @Override
                    public void onError(Throwable e) {

                        for (int i = 0; i < weatherDatabase.getLocalWeathers().size(); i++) {
                            mainAdapter.addWeather(weatherDatabase.getLocalWeathers().get(i));
                            view.showList(mainAdapter);
                        }
                    }
                });
            }
        } else {
            for (int i = 0; i < weatherDatabase.getLocalWeathers().size(); i++) {
                mainAdapter.addWeather(weatherDatabase.getLocalWeathers().get(i));
                view.showList(mainAdapter);
            }
        }

    }
}
