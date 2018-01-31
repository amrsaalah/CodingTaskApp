package com.salah.amr.codingtaskapp.forecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.model.LocalForecast;
import com.salah.amr.codingtaskapp.model.LocalWeather;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    List<LocalForecast> localForecasts;

    @Inject
    public ForecastAdapter() {
        localForecasts = new ArrayList<>();
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast , parent , false);
       return new ForecastHolder(v);
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        LocalForecast localForecast  = localForecasts.get(position);
        holder.bindForecast(localForecast);
    }

    @Override
    public int getItemCount() {
        return localForecasts.size();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder{

        TextView date , minTemp , maxTemp;

        public ForecastHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.item_forecast_date);
            minTemp =  itemView.findViewById(R.id.item_forecast_min_temp);
            maxTemp = itemView.findViewById(R.id.item_forecast_max_temp);
        }

        public void bindForecast(LocalForecast localForecast){
            minTemp.setText(String.valueOf(localForecast.getMinTemp()));
            maxTemp.setText(String.valueOf(localForecast.getMaxTemp()));
        }
    }
}
