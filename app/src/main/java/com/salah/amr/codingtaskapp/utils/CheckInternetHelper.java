package com.salah.amr.codingtaskapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Amr Salah on 2/1/2018.
 */

public class CheckInternetHelper {

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
