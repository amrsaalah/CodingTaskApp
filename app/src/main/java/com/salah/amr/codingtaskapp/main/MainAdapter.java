package com.salah.amr.codingtaskapp.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.base.BaseListener;
import com.salah.amr.codingtaskapp.model.LocalWeather;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.WeatherHolder> {

    private static final String TAG = "MainAdapter";
    public interface OnItemClickListener extends BaseListener {
        void onItemClick(String name);
    }

    List<LocalWeather> localWeathers;
    private OnItemClickListener onItemClickListener;

    @Inject
    public MainAdapter(BaseListener baseListener) {
        this.onItemClickListener = (OnItemClickListener) baseListener;
        this.localWeathers = new ArrayList<>();
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_current_temp , parent , false);
        return new WeatherHolder(v);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        LocalWeather localWeather = localWeathers.get(position);
        holder.bindWeather(localWeather , onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return localWeathers.size();
    }


    public class WeatherHolder extends RecyclerView.ViewHolder{
        TextView city , temp;

        public WeatherHolder(View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.item_city_name);
            temp = itemView.findViewById(R.id.item_city_temp);
        }

        public void bindWeather(LocalWeather localWeather , OnItemClickListener onItemClickListener){
            Log.d(TAG, "bindWeather: "+localWeather);
            itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClick(localWeather.getCity());
            });
            city.setText(localWeather.getCity());
            temp.setText(String.valueOf(localWeather.getCurrentTemp()));
        }
    }

    public void addWeather(LocalWeather localWeather){
        Log.d(TAG, "setWeather: "+localWeathers);
        this.localWeathers.add(localWeather);
    }
}
