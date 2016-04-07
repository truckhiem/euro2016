package com.khiemtran.euro2016.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by khiem.tran on 05/04/2016.
 */
public class EuroApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        EuroApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return EuroApplication.context;
    }
}
