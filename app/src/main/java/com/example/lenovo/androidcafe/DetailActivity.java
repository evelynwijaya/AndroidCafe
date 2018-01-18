package com.example.lenovo.androidcafe;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Menu menu = getIntent().getParcelableExtra("menu");

        FragmentManager fragmentManager = getFragmentManager();
        FragmentDetail fragmentDetail = (FragmentDetail) fragmentManager.findFragmentById(R.id.fragmentD);
        fragmentDetail.displayData(menu);

    }
}
