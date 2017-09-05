package mx.javiercruzweb.sharedpreferencesingletonsample.activities;

import android.support.multidex.MultiDexApplication;

import mx.javiercruzweb.sharedpreferencesingletonsample.utils.GlobalSettings;

/**
 * Created by javiercruz on 05/09/17.
 */

public class SharedPreferenceSingletonSampleApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        //init sharedpreference singleton
        GlobalSettings.getInstance(getApplicationContext());

    }
}
