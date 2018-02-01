package com.salah.amr.codingtaskapp.main;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.salah.amr.codingtaskapp.ContactUs;
import com.salah.amr.codingtaskapp.MyApp;
import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.base.BaseFragment;
import com.salah.amr.codingtaskapp.dagger.ControllerModule;
import com.salah.amr.codingtaskapp.forecast.ForecastActivity;
import com.salah.amr.codingtaskapp.settings.SettingsActivity;
import com.salah.amr.codingtaskapp.utils.CheckInternetHelper;

import javax.inject.Inject;


/**
 * Created by Amr Salah on 1/31/2018.
 */

public class MainFragment extends BaseFragment implements IMain.view  , MainAdapter.OnItemClickListener{
    private static final String TAG = "MainFragment";

    @Override
    public void onItemClick(String city) {
       Intent intent =  ForecastActivity.newIntent(getActivity() , city);
        startActivity(intent);
    }
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Inject
    MainPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater , container , savedInstanceState);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.initDatabase();
        presenter.getCurrentTemp(CheckInternetHelper.isNetworkAvailable(getActivity()));

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "onCreateOptionsMenu: ");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        switch (item.getItemId()) {
            case R.id.item_menu_settings:
                Intent intent1 = new Intent(getActivity() , SettingsActivity.class);
                startActivity(intent1);
                return true;
            case R.id.item_menu_contactUs:
              Intent intent2 = new Intent(getActivity() , ContactUs.class);
              startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidgets(View v) {
        toolbar = v.findViewById(R.id.toolbar);
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


    @Override
    public void navigateToForecastActivity() {
        Intent intent = new Intent(getActivity() , ForecastActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = new Intent(getActivity() , MainActivity.class);
        startActivity(intent);
    }



}
