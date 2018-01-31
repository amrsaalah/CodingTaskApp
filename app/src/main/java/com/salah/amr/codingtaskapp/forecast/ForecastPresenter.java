package com.salah.amr.codingtaskapp.forecast;

import com.salah.amr.codingtaskapp.base.BaseView;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;

import javax.inject.Inject;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class ForecastPresenter implements IForecast.presenter {

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
    public void loadForecast() {

    }
}
