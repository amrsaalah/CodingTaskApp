package com.salah.amr.codingtaskapp.forecast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.salah.amr.codingtaskapp.R;

public class ForecastActivity extends AppCompatActivity {
    private static final String TAG = "ForecastActivity";

    private static final String EXTRA_CITY = "extra_city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        String city = getIntent().getStringExtra(EXTRA_CITY);
        Log.d(TAG, "onCreate: "+city);

        ForecastFragment forecastFragment = ForecastFragment.newInstance(city);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container , forecastFragment).commit();
    }

    public static Intent newIntent(Context context  , String city){
        Intent intent =new Intent(context , ForecastActivity.class);
        intent.putExtra(EXTRA_CITY , city);
        return intent;
    }
}
