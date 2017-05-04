package com.sitthirat.gel2202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sitthirat.gel2202.fragment.MainFragment;
import com.sitthirat.gel2202.fragment.SecondFragment;
import com.sitthirat.gel2202.fragment.WebFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_container, MainFragment.newInstance())
                .commit();
    }

    @Override
    public void onStartButtonClick() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, SecondFragment.newInstance())
                .commit();
    }

}
