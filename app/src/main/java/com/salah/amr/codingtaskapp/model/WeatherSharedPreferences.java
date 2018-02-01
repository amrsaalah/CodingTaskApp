package com.salah.amr.codingtaskapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 1/31/2018.
 */

public class WeatherSharedPreferences {

    private static final String PREF_INIT_DATABASE = "pref_init_database";
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
}
