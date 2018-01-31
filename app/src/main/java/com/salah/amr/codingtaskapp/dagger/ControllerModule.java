package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.base.BaseFragment;
import com.salah.amr.codingtaskapp.base.BaseListener;
import com.salah.amr.codingtaskapp.base.BaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amr Salah on 1/31/2018.
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

    @Provides
    @ControllerScope
    BaseView provideBaseView(){
        return this.fragment;
    }

    @Provides
    @ControllerScope
    BaseListener provideBaseListener(){
        return (BaseListener) this.fragment;
    }

}
