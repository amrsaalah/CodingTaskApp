package com.salah.amr.codingtaskapp.forecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;
import com.salah.amr.codingtaskapp.utils.UnitsConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    List<LocalForecast> localForecasts;
    private WeatherSharedPreferences preferences;

    @Inject
    public ForecastAdapter(WeatherSharedPreferences preferences) {
        this.preferences = preferences;
        localForecasts = new ArrayList<>();
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ForecastHolder(v);
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        LocalForecast localForecast = localForecasts.get(position);
        holder.bindForecast(localForecast, position);
    }

    @Override
    public int getItemCount() {
        return localForecasts.size();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder {

        TextView dateTextView, minTemp, maxTemp;

        public ForecastHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.item_forecast_date);
            minTemp = itemView.findViewById(R.id.item_forecast_min_temp);
            maxTemp = itemView.findViewById(R.id.item_forecast_max_temp);
        }

        public void bindForecast(LocalForecast localForecast, int position) {

            if (position == 0) {
                dateTextView.setText("Today");
            } else if (position == 1) {
                dateTextView.setText("Tomorrow");
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, position);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                Date date = new GregorianCalendar(year, month, day).getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM");
                String formattedDate = df.format(date);
                dateTextView.setText(formattedDate);
            }
            if (preferences.getUnitsType().equals("0")) {
                minTemp.setText(UnitsConverter.kelvinToCelsius(localForecast.getMinTemp()));
                maxTemp.setText(UnitsConverter.kelvinToCelsius(localForecast.getMaxTemp()));
            } else {
                minTemp.setText(UnitsConverter.kelvinToFahrenheit(localForecast.getMinTemp()));
                maxTemp.setText(UnitsConverter.kelvinToFahrenheit(localForecast.getMaxTemp()));
            }
        }
    }

    public void setLocalForecasts(List<LocalForecast> localForecasts) {
        this.localForecasts = localForecasts;
    }
}
