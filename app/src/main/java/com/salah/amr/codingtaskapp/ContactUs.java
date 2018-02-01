package com.salah.amr.codingtaskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ContactUs extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        imageView = findViewById(R.id.back_btn);
        imageView.setOnClickListener(view -> {
            finish();
        });
    }
}
