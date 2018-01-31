package com.salah.amr.codingtaskapp.main;

import com.salah.amr.codingtaskapp.base.BaseView;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public interface IMain {
    interface view extends BaseView{
        void showList(MainAdapter adapter);
    }

    interface presenter{
        void getCurrentTemp();
    }
}
