package com.basith.cbseapp.Models;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppModel {

    public static AppModel sharedInstance = new AppModel();

    public boolean isProduction = true;

    public int ITEMS_PER_AD = 9;

    public AppModel(){

    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ){
            return true;
        }
        else {
            return false;
        }
    }
}
