package com.salah.amr.codingtaskapp.main;

import android.util.Log;

import com.salah.amr.codingtaskapp.base.BaseView;
import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.LocalWeather;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;
import com.salah.amr.codingtaskapp.model.WeatherDatabase;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;

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
    public MainPresenter(BaseView view, OpenWeatherAPI openWeatherAPI , MainAdapter mainAdapter , WeatherDatabase weatherDatabase , WeatherSharedPreferences preferences) {
        this.view = (IMain.view) view;
        this.openWeatherAPI = openWeatherAPI;
        this.mainAdapter = mainAdapter;
        this.weatherDatabase = weatherDatabase;
        this.preferences = preferences;
    }

    @Override
    public void initDatabase() {
        if(!preferences.getInitDatabase()){
            Log.d(TAG, "initDatabase: ");

            String [] cities = {"Roma" , "Madrid" , "London" , "Moscow" , "Cairo"};
            for(int i = 0 ; i<cities.length ; i++){
                LocalWeather localWeather = new LocalWeather();
                localWeather.setCity(cities[i]);
                weatherDatabase.addLocalWeather(localWeather);
            }
            preferences.setInitDatabase(true);
        }
    }

    @Override
    public void getCurrentTemp(Boolean internet) {
        Log.d(TAG, "getCurrentTemp: "+internet);

        Log.d(TAG, "getCurrentTemp: unit type "+preferences.getUnitsType());

        Log.d(TAG, "getCurrentTemp: "+weatherDatabase.getLocalWeathers());
        if(internet){
            for (int i = 0; i <weatherDatabase.getLocalWeathers().size() ; i++) {
                int temp = i;
                openWeatherAPI.getCurrentWeather(weatherDatabase.getLocalWeathers().get(i).getCity()).subscribe(new SingleObserver<Double>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+temp);
                    }

                    @Override
                    public void onSuccess(Double aDouble) {
                        Log.d(TAG, "onSuccess: "+aDouble + " "+temp);
                        LocalWeather localWeather = weatherDatabase.getLocalWeathers().get(temp);
                        localWeather.setCurrentTemp(aDouble);

                        weatherDatabase.updateLocalWeather(localWeather);

                        mainAdapter.addWeather(localWeather);
                        view.showList(mainAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        for(int i = 0 ; i<weatherDatabase.getLocalWeathers().size() ; i++){
                            mainAdapter.addWeather(weatherDatabase.getLocalWeathers().get(i));
                            view.showList(mainAdapter);
                        }
                    }
                });
            }
        }
        else{
            Log.d(TAG, "getCurrentTemp: "+internet);
            for(int i = 0 ; i<weatherDatabase.getLocalWeathers().size() ; i++){
                mainAdapter.addWeather(weatherDatabase.getLocalWeathers().get(i));
                view.showList(mainAdapter);
            }
        }

    }
}
