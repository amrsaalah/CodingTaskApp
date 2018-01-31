package com.salah.amr.codingtaskapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.salah.amr.codingtaskapp.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container , fragment)
                .commit();

    }
}
