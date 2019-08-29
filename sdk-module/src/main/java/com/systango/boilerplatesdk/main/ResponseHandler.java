package com.systango.boilerplatesdk.main;

import com.systango.boilerplatesdk.listener.Feature1ResponseListener;
import com.systango.boilerplatesdk.network.interfaces.UrlPathKey;
import com.systango.boilerplatesdk.network.response.SampleResponse;

import retrofit2.Response;

/**
 * Created by Mohit Rajput on 29/8/19.
 */
class ResponseHandler {
    private Feature1ResponseListener feature1ResponseListener;

    void setFeature1ResponseListener(Feature1ResponseListener feature1ResponseListener) {
        this.feature1ResponseListener = feature1ResponseListener;
    }

    void handleResponse(String apiUrl, Response response, Throwable throwable) {
        if (apiUrl.contains(UrlPathKey.POST_API_URL)) {
            onFeature1Response(response, throwable);
        }
    }

    private void onFeature1Response(Response response, Throwable throwable) {
        SampleResponse sampleResponse;
        if (throwable != null) {
            sampleResponse = new SampleResponse();
            sampleResponse.setError(throwable.getMessage());
        } else {
            sampleResponse = (SampleResponse) response.body();
        }
        if (feature1ResponseListener != null)
            feature1ResponseListener.onFeature1Response(sampleResponse);
    }
}
