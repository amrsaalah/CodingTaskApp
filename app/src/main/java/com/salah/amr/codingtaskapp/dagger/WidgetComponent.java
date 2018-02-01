package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.widget.NewAppWidget;
import com.salah.amr.codingtaskapp.widget.NewAppWidgetConfigureActivity;

import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by Amr Salah on 2/1/2018.
 */

@Subcomponent(modules = {WidgetModule.class})
@WidgetScope
public interface WidgetComponent {

    void inject(NewAppWidgetConfigureActivity target);
}
