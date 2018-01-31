package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by user on 1/31/2018.
 */
@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
