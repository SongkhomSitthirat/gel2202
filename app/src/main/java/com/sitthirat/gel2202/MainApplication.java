package com.sitthirat.gel2202;

import android.app.Application;

import com.sitthirat.gel2202.tool.Contextor;

/**
 * Created by prewsitthirat on 5/3/2017 AD.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
