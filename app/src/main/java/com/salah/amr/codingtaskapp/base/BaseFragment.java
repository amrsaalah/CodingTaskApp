package com.salah.amr.codingtaskapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 1/31/2018.
 */

public abstract class BaseFragment extends Fragment {

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(getLayout() , container , false);
        initWidgets(v);
        return v;
    }

    public abstract int getLayout();
    public abstract void initWidgets(View v);
}
