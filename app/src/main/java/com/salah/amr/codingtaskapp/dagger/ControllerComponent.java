package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.MainFragment;

import dagger.Subcomponent;

/**
 * Created by user on 1/31/2018.
 */

@Subcomponent(modules = {ControllerModule.class})
@ControllerScope
public interface ControllerComponent {
     void inject(MainFragment target);
}
