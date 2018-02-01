package com.salah.amr.codingtaskapp.forecast;

import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.LocalWeather;
import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;
import com.salah.amr.codingtaskapp.model.WeatherDatabase;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by Amr Salah on 2/1/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ForecastPresenterTest {

    @Mock
    IForecast.view view;

    @Mock
    WeatherDatabase weatherDatabase;

    @Mock
    OpenWeatherAPI openWeatherAPI;

    @Mock
    ForecastAdapter forecastAdapter;


    ForecastPresenter presenter;

    List<LocalForecast> localForecastList;
    List<LocalForecast> oldLocalList;

    @Before
    public void setUp(){
        presenter = new ForecastPresenter(view , openWeatherAPI , forecastAdapter ,  weatherDatabase);

        localForecastList = new ArrayList<>();
        LocalForecast localForecast = new LocalForecast();
        localForecast.setMaxTemp(10.0);
        localForecast.setMinTemp(5.0);
        localForecastList.add(localForecast);
        Mockito.when(openWeatherAPI.getForecast("Madrid")).thenReturn(Single.just(localForecastList));
        LocalWeather localWeather = new LocalWeather();
        localWeather.setCity("Madrid");


        oldLocalList = new ArrayList<>();
        LocalForecast localForecast2 = new LocalForecast();
        localForecast.setMaxTemp(100.0);
        localForecast.setMinTemp(50.0);
        LocalWeather localWeatherOld = new LocalWeather();
        localWeatherOld.setLocalForecasts(oldLocalList);
        Mockito.when(weatherDatabase.getLocalWeather("Madrid")).thenReturn(localWeatherOld);
    }

    @Test
    public void verifyIfInternetIsTrue(){
        presenter.loadForecast("Madrid" , true);
        verify(forecastAdapter).setLocalForecasts(localForecastList);
        verify(forecastAdapter , Mockito.never()).setLocalForecasts(oldLocalList);
    }

    @Test
    public void verifyIfInternetIsFalse(){
        presenter.loadForecast("Madrid" , false);
        verify(forecastAdapter).setLocalForecasts(oldLocalList);
    }

}