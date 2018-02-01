package com.salah.amr.codingtaskapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.salah.amr.codingtaskapp.MyApp;
import com.salah.amr.codingtaskapp.dagger.ControllerModule;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(getLayout() , container , false);
        injectDependencies();
        initWidgets(v);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public abstract int getLayout();
    public abstract void initWidgets(View v);
    public abstract void injectDependencies();
}
