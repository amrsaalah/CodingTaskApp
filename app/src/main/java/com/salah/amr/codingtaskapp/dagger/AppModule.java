package com.salah.amr.codingtaskapp.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.salah.amr.codingtaskapp.model.AppDatabase;
import com.salah.amr.codingtaskapp.model.WeatherDatabase;
import com.salah.amr.codingtaskapp.model.WeatherSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amr Salah on 1/31/2018.
 */

@Singleton
@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    /*@Provides
    @Singleton
    public AppDatabase provideAppDatabase(Application application){
        return Room.databaseBuilder(application,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();
    }*/

    @Provides
    @Singleton
    public Application provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    public WeatherSharedPreferences provideEmployeeSharedPreferences(Application application){
        return new WeatherSharedPreferences(application);
    }


    @Provides
    @Singleton
    public WeatherDatabase provideEmployeeDatabase(AppDatabase appDatabase){
        return new WeatherDatabase(appDatabase);
    }


}

