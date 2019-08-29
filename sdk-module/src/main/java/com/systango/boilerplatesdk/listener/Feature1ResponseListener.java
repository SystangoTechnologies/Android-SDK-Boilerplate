package com.systango.boilerplatesdk.listener;

import com.systango.boilerplatesdk.network.response.SampleResponse;

/**
 * Created by Mohit Rajput on 4/12/18.
 * Callback of feature 1 method
 */

public interface Feature1ResponseListener {
    void onFeature1Response(SampleResponse sampleResponse);
}
