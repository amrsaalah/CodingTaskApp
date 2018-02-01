package com.salah.amr.codingtaskapp.utils;

import android.util.Log;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public class UnitsConverter {

    private static final String TAG = "UnitsConverter";
    
    public static String kelvinToCelsius(Double temp){
        Log.d(TAG, "kelvinToCelsius: ");
        double celsius = temp - 273;

        String s = String.format("%.1f", celsius);
        s = s + "°C";
        return s;
    }

    public static String kelvinToFahrenheit(Double temp){

        double fah = 1.8 * (temp - 273) +32;
        String s = String.format("%.1f", fah);
        s = s + "°F";
        return s;
    }
}
