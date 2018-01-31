package com.salah.amr.codingtaskapp.model.weather;

/**
 * Created by user on 8/26/2017.
 */

public class City {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
