package com.salah.amr.codingtaskapp.dagger;

import com.salah.amr.codingtaskapp.widget.IWidget;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amr Salah on 2/1/2018.
 */

@Module
@WidgetScope
public class WidgetModule {

    private IWidget.view view;

    public WidgetModule(IWidget.view view) {
        this.view = view;
    }

    @Provides
    @WidgetScope
    IWidget.view provideView(){
        return this.view;
    }


}
