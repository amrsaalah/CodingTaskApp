package com.salah.amr.codingtaskapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salah.amr.codingtaskapp.MyApp;
import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.base.BaseFragment;
import com.salah.amr.codingtaskapp.dagger.ControllerModule;

import javax.inject.Inject;


/**
 * Created by Amr Salah on 1/31/2018.
 */

public class MainFragment extends BaseFragment implements IMain.view  , MainAdapter.OnItemClickListener{
    private static final String TAG = "MainFragment";

    @Override
    public void onItemClick(String city) {

    }
    RecyclerView recyclerView;

    @Inject
    MainPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater , container , savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getCurrentTemp();

        return v;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidgets(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
    }

    @Override
    public void injectDependencies() {
        MyApp.getComponent().newControllerComponent(new ControllerModule(this)).inject(this);
    }

    @Override
    public void showList(MainAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }



}
