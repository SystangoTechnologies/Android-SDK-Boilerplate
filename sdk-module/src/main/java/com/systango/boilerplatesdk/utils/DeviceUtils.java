package com.systango.boilerplatesdk.utils;

import android.os.Build;

import com.systango.boilerplatesdk.BuildConfig;

/**
 * Created by Mohit Rajput on 3/12/18.
 * It contains utility methods related to phone or tablet
 */

public class DeviceUtils {
    /**
     * Returns device's OS.
     *
     * @return Android always
     */
    public static String getDeviceOs() {
        return "Android";
    }

    /**
     * @return Device's manufacturer and model as concatenated string
     */
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        }
        return manufacturer + " " + model;
    }

    public static String getUserAgent() {
        return getDeviceName() + "/" + BuildConfig.VERSION_NAME;
    }
}
