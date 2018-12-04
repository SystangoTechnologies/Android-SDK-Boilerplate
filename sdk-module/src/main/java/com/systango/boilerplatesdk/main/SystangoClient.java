package com.systango.boilerplatesdk.main;

import com.systango.boilerplatesdk.listener.OnFeature1ResponseListener;

/**
 * Created by Mohit Rajput on 3/12/18.
 * TODO: Insert javadoc information here
 */

interface SystangoClient {
    void feature1Method(String fieldName, OnFeature1ResponseListener onFeature1ResponseListener);
}
