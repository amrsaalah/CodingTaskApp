package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.forecast.ForecastFragment;
import com.salah.amr.codingtaskapp.main.MainFragment;
import com.salah.amr.codingtaskapp.base.BaseFragment;

import dagger.Subcomponent;

/**
 * Created by Amr Salah on 1/31/2018.
 */

@Subcomponent(modules = {ControllerModule.class})
@ControllerScope
public interface ControllerComponent {
     void inject(MainFragment target);
     void inject(ForecastFragment target);
}
