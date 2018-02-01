package com.salah.amr.codingtaskapp.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.salah.amr.codingtaskapp.R;
import com.salah.amr.codingtaskapp.main.MainActivity;

public class SettingsActivity extends AppCompatActivity {

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SettingsFragment fragment = new SettingsFragment();
        backButton = findViewById(R.id.back_btn);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        });
        getFragmentManager().beginTransaction()
                .add(R.id.container , fragment)
                .commit();
    }
}
