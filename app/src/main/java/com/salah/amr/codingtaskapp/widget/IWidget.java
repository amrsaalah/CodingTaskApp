package com.salah.amr.codingtaskapp.widget;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public interface IWidget {
    interface view{
        void updateWidget();
    }

    interface presenter{
        void getCurrentTemp(String city);
    }
}
