package com.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionImpl;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragment.FirstFragment;
import fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFragemnt;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragemnt = findViewById(R.id.btnFragment);
        btnFragemnt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status) {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.fragmentContainer, firstFragment);
            fragmentTransaction.commit();
            btnFragemnt.setText("Load second fragment");
            status = false;

        } else {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.fragmentContainer, secondFragment);
            fragmentTransaction.commit();
            btnFragemnt.setText("Load second fragment");
            status = true;
        }



    }
}
