package com.salah.amr.codingtaskapp.model.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 7/25/2017.
 */

public class Main {
    private double temp;
    private double humidity;
    @SerializedName("temp_min") private double minTemp;
    @SerializedName("temp_max") private double maxTemp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return ((int) humidity);
    }

    public void setHumdity(double humdity) {
        this.humidity = humdity;
    }

    public int getMinTemp() {
        return ((int) minTemp - 273);
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {

        return ((int) maxTemp - 273);
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
