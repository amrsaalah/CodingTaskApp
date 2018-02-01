package com.salah.amr.codingtaskapp.main;

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

import io.reactivex.Single;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by Amr Salah on 2/1/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    IMain.view view;

    @Mock
    MainAdapter mainAdapter;

    @Mock
    WeatherSharedPreferences preferences;

    @Mock
    WeatherDatabase weatherDatabase;

    @Mock
    OpenWeatherAPI openWeatherAPI;

    MainPresenter presenter;
    LocalWeather localWeather1;
    LocalWeather localWeather2;

    @Before
    public void setUp(){
        presenter  = new MainPresenter(view , openWeatherAPI , mainAdapter , weatherDatabase , preferences);

        List<LocalWeather> localWeatherList = new ArrayList<>();
        localWeather1 = new LocalWeather();
        localWeather1.setCity("Berlin");
        localWeather2 = new LocalWeather();
        localWeather2.setCity("Paris");
        localWeather1.setCurrentTemp(5.0);
        localWeather2.setCurrentTemp(7.1);

        localWeatherList.add(localWeather1);
        localWeatherList.add(localWeather2);

        Mockito.when(weatherDatabase.getLocalWeathers()).thenReturn(localWeatherList);
        Mockito.when(preferences.getInitDatabase()).thenReturn(false);

        Mockito.when(openWeatherAPI.getCurrentWeather("Berlin")).thenReturn(Single.just(15.5));
        Mockito.when(openWeatherAPI.getCurrentWeather("Paris")).thenReturn(Single.just(32.5));
    }

    @Test
    public void verifyFlagBecomeTrue(){
        presenter.initDatabase();
        verify(preferences).setInitDatabase(true);
    }

    @Test
    public void verifyAdapterAddRightInstanceWhenInternetIsTrue(){
        presenter.getCurrentTemp(true);
        assertEquals(localWeather1.getCurrentTemp() , 15.5 , 0.5);
        verify(mainAdapter).addWeather(localWeather1);
    }

    @Test
    public void verifyAdapterDoesNotAddWrongInstanceWhenInternetIsTrue(){
        presenter.getCurrentTemp(true);
        LocalWeather localWeather = new LocalWeather();
        verify(mainAdapter , Mockito.never()).addWeather(localWeather);
    }

   @Test
    public void verifyAdapterAddRightInstanceWhenInternetIsFalse(){
        presenter.getCurrentTemp(false);
       assertEquals(localWeather1.getCurrentTemp() , 5 , 0.5);
    }

}