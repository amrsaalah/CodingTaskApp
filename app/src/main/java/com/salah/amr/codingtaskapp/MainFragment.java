package com.salah.amr.codingtaskapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.salah.amr.codingtaskapp.base.BaseFragment;

import org.w3c.dom.Text;

/**
 * Created by user on 1/31/2018.
 */

public class MainFragment extends BaseFragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater , container , savedInstanceState);
        textView.setOnClickListener(view -> {
            Toast.makeText(getActivity() , "hello" , Toast.LENGTH_LONG).show();
        });

        return v;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initWidgets(View v) {
        textView = v.findViewById(R.id.text);
    }
}
