package com.salah.amr.codingtaskapp.model;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class LocalForecast {

    double maxTemp;
    double minTemp;

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "LocalForecast{" +
                "maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }
}
