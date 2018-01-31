package com.salah.amr.codingtaskapp.forecast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salah.amr.codingtaskapp.MyApp;
import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.base.BaseFragment;
import com.salah.amr.codingtaskapp.dagger.ControllerModule;
import com.salah.amr.codingtaskapp.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class ForecastFragment extends BaseFragment implements IForecast.view {
    private static final String TAG = "ForecastFragment";
    private static final String ARG_CITY = "arg_city";
    String city;

    ImageView backBtn;
    TextView cityName;

    @Inject
    ForecastPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        city = getArguments().getString(ARG_CITY);
        Log.d(TAG, "onCreate: "+city);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        cityName.setText(city);

        presenter.loadForecast();

        backBtn.setOnClickListener(view -> {
            navigateToMainActivity();
        });

        return v;
    }

    @Override
    public void initWidgets(View v) {
        backBtn = v.findViewById(R.id.back_btn);
        cityName = v.findViewById(R.id.forecast_city);
    }

    @Override
    public void navigateToForecastActivity() {
        Intent intent = new Intent(getActivity() , ForecastActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = new Intent(getActivity() , MainActivity.class);
        startActivity(intent);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_forecast;
    }


    @Override
    public void injectDependencies() {
        MyApp.getComponent().newControllerComponent(new ControllerModule(this)).inject(this);
    }

    public static ForecastFragment newInstance(String city){
        Bundle args = new Bundle();
        args.putString(ARG_CITY , city);
        ForecastFragment forecastFragment = new ForecastFragment();
        forecastFragment.setArguments(args);
        return forecastFragment;
    }
}
