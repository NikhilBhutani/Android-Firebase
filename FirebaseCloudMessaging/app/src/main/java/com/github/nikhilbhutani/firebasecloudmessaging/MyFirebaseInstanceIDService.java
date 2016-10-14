package com.github.nikhilbhutani.firebasecloudmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Nikhil Bhutani on 10/13/2016.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String LOG_TAG = "MyFirebaseInstanceIdService";

    @Override
    public void onTokenRefresh() {

        //Get updated InstanceID Token
        Log.d(LOG_TAG, "Refreshed Token "+FirebaseInstanceId.getInstance().getToken());

      // If you want to send messages to application instance or manage this apps on the server side
      //  sendRegistrationToServer(refreshedToken);
    }
}
