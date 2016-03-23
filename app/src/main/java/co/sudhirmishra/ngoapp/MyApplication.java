package co.sudhirmishra.ngoapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by FDUSER on 24-Feb-16.
 */
public class MyApplication extends Application {

    private  static  MyApplication  myInstance ;

    @Override
    public void onCreate() {
        super.onCreate();

        myInstance = this;
    }

    public static MyApplication getInstance() {

        return myInstance;

    }

    public static Context getAppContext() {

        return myInstance.getApplicationContext();

    }
}
