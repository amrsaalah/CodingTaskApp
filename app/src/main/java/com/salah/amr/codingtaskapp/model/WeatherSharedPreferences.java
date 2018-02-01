package com.salah.amr.codingtaskapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 1/31/2018.
 */

public class WeatherSharedPreferences {

    private static final String PREF_INIT_DATABASE = "pref_init_database";
    private static final String PREF_UNIT_TYPE = "unitsType";
    private static final String PREF_WIDGET_TEMP = "pref_widget_temp";
    private static final String PREF_WIDGET_CITY = "pref_widget_city";
    private SharedPreferences prefs;

    public WeatherSharedPreferences(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setInitDatabase(boolean flag) {
        prefs.edit().putBoolean(PREF_INIT_DATABASE, flag).apply();
    }

    public boolean getInitDatabase(){
        return prefs.getBoolean(PREF_INIT_DATABASE , false);
    }

    public String getUnitsType(){
        return prefs.getString(PREF_UNIT_TYPE , "0");
    }

    public String getWidgetTemp(){
        return prefs.getString(PREF_WIDGET_TEMP , "0");
    }

    public void setWidgetTemp(String temp){
        prefs.edit().putString(PREF_WIDGET_TEMP , temp).apply();
    }

    public void setWidgetCity(String city){
        prefs.edit().putString(PREF_WIDGET_CITY , city).apply();
    }

    public String getWidgetCity(){
        return prefs.getString(PREF_WIDGET_CITY , "");
    }
}
