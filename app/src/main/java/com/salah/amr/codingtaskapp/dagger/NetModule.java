package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.model.OpenWeatherAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 1/31/2018.
 */
@Module
public class NetModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory gson , RxJava2CallAdapterFactory rxJava){
        return  new Retrofit.Builder()
                .baseUrl(OpenWeatherAPI.BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxJava)
                .build();
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGson(){
        return  GsonConverterFactory.create();
    }


    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJava(){
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OpenWeatherAPI provideOpenWeatherAPI(Retrofit retrofit){
        return retrofit.create(OpenWeatherAPI.class);
    }

}
