package com.salah.amr.codingtaskapp.settings;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.main.MainActivity;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;
import com.salah.amr.codingtaskapp.utils.UnitsConverter;
import com.salah.amr.codingtaskapp.widget.NewAppWidget;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        PreferenceManager.setDefaultValues(getActivity() ,R.xml.preferences , false);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {

       Intent intent = new Intent(getActivity() , MainActivity.class);
       startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
