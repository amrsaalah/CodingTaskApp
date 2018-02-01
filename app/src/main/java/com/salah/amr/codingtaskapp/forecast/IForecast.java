package com.salah.amr.codingtaskapp.forecast;

import com.salah.amr.codingtaskapp.base.BaseView;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public interface IForecast {
    interface view extends BaseView{
        void showList(ForecastAdapter adapter);
    }

    interface presenter{
        void loadForecast(String city , boolean internet);
    }
}
