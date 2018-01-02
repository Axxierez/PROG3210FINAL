package com.example.alex.prog3210final;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Alex on 2018-01-01.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService
    {

    private static final String TAG = "FirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        //Getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token in logcat
        Log.e(TAG, "Refreshed token: " + refreshedToken);

    }

    private void sendRegistrationToServer(String token) {
        //You can implement this method to store the token on your server
        //Not required for current project
    }
}
