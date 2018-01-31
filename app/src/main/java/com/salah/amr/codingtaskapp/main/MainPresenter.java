package com.salah.amr.codingtaskapp.main;

import android.util.Log;

import com.salah.amr.codingtaskapp.base.BaseView;
import com.salah.amr.codingtaskapp.model.LocalWeather;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;

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

    @Inject
    public MainPresenter(BaseView view, OpenWeatherAPI openWeatherAPI , MainAdapter mainAdapter) {
        this.view = (IMain.view) view;
        this.openWeatherAPI = openWeatherAPI;
        this.mainAdapter = mainAdapter;
    }


    @Override
    public void getCurrentTemp() {
        Log.d(TAG, "getCurrentTemp: ");
        List<LocalWeather> localWeatherList = new ArrayList<>();
        String[] cities = {"roma" , "madrid" , "cairo" , "moscow" , "berlin"};
        for (int i = 0; i <cities.length ; i++) {
            int temp = i;
            openWeatherAPI.getCurrentWeather(cities[i]).subscribe(new SingleObserver<Double>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.d(TAG, "onSubscribe: ");
                }

                @Override
                public void onSuccess(Double aDouble) {
                    Log.d(TAG, "onSuccess: "+aDouble);
                    LocalWeather localWeather = new LocalWeather();
                    localWeather.setCity(cities[temp]);
                    localWeather.setCurrentTemp(aDouble);
                    localWeatherList.add(localWeather);
                    mainAdapter.addWeather(localWeather);
                    view.showList(mainAdapter);
                }

                @Override
                public void onError(Throwable e) {
                    Log.d(TAG, "onError: "+e.getMessage());
                }
            });
        }

    }
}
