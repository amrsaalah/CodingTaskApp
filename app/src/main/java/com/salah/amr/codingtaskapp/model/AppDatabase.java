package com.salah.amr.codingtaskapp.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by user on 1/31/2018.
 */
//@Database(entities = {WeatherModel.class} , version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WeatherDAO weatherDAO();

}
