package com.github.nikhilbhutani.firebase_one;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by win Nikhil Bhutani on 7/2/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

         //Initialize Firebase
        Firebase.setAndroidContext(this);


    }
}
