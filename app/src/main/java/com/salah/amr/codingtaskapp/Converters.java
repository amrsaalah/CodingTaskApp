package com.salah.amr.codingtaskapp;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.salah.amr.codingtaskapp.model.LocalForecast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public class Converters {
    @TypeConverter
    public String fromCountryLangList(List<LocalForecast> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<LocalForecast>>() {
        }.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public List<LocalForecast> toCountryLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<LocalForecast>>() {
        }.getType();
        List<LocalForecast> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }
}
