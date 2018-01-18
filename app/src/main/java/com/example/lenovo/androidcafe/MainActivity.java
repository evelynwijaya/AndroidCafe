package com.example.lenovo.androidcafe;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements FragmentCommunicator {
    private boolean netOk;
    private boolean isDualPane = false;
    private FragmentDetail fragmentDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netOk = NetworkHelper.hasNetworkAccess(this);
        Toast.makeText(this, "Network OK: "+ netOk, Toast.LENGTH_SHORT).show();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentDetail = (FragmentDetail) fragmentManager.findFragmentById(R.id.fragmentD);

        View fragmentDView = findViewById(R.id.fragmentD);
        isDualPane =fragmentDView !=null && fragmentDView.getVisibility() == View.VISIBLE;


    }

    @Override
    public void displayDetail(Menu menu) {

        if (isDualPane){
            fragmentDetail.displayData(menu);
        }else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("menu", menu);
            startActivity(intent);
        }

    }
}
