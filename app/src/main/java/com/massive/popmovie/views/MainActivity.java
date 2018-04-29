package com.massive.popmovie.views;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.massive.popmovie.R;
import com.massive.popmovie.views.fragments.GridFragment;

public class MainActivity extends AppCompatActivity {
    android.app.Fragment GridFragment;
    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        GridFragment = fm.findFragmentByTag(TAG_RETAINED_FRAGMENT);

        if (GridFragment == null) {
            GridFragment = new GridFragment();
            fm.beginTransaction().replace(R.id.FragmentContainer, GridFragment, TAG_RETAINED_FRAGMENT).commit();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().remove(GridFragment).commit();
        }

    }

}