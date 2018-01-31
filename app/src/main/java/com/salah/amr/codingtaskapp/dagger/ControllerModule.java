package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.base.BaseFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 1/31/2018.
 */
@ControllerScope
@Module
public class ControllerModule {

    private BaseFragment fragment;

    public ControllerModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ControllerScope
    BaseFragment provideBaseFragment(){
        return this.fragment;
    }

}
