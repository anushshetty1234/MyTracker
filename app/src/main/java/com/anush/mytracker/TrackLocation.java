package com.anush.mytracker;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by ANUSH on 25-02-2018.
 */

public class TrackLocation implements LocationListener {

    public static Location location;
    public static boolean isRunning=false;

    public TrackLocation() {
    isRunning=true;
        location=new Location("not defined");
        location.setLatitude(0);
        location.setLongitude(0);
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location=location;

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
