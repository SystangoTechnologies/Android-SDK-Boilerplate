package com.systango.boilerplatesdk.main;

import com.systango.boilerplatesdk.listener.Feature1ResponseListener;

/**
 * Created by Mohit Rajput on 3/12/18.
 * TODO: Insert javadoc information here
 */

interface SystangoClient {
    void feature1Method(String fieldName, Feature1ResponseListener feature1ResponseListener);
}
