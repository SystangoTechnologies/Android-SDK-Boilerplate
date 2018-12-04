package com.systango.boilerplatesdk.main;

import com.systango.boilerplatesdk.listener.OnFeature1ResponseListener;
import com.systango.boilerplatesdk.network.ApiClientImpl;
import com.systango.boilerplatesdk.network.BaseResponseCallback;
import com.systango.boilerplatesdk.network.interfaces.UrlPathKey;
import com.systango.boilerplatesdk.network.request.SampleRequest;
import com.systango.boilerplatesdk.network.response.SampleResponse;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohit Rajput on 3/12/18.
 * This client initialize SDK with a valid APK and contains number of feature methods
 */

public class SystangoRestClient implements SystangoClient {
    private String apiKey;
    private OnFeature1ResponseListener onFeature1ResponseListener;
    private BaseResponseCallback baseResponseCallback = new BaseResponseCallback() {
        @Override
        public void success(Call call, Response response) {

        }

        @Override
        public void unauthenticated(Call call, Response response) {

        }

        @Override
        public void commonCallback(Call call, Response response, Throwable throwable) {
            String apiUrl = call.request().url().toString();
            if (apiUrl.contains(UrlPathKey.POST_API_URL)) {
                onFeature1Response(response, throwable);
            }
        }
    };

    public SystangoRestClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void feature1Method(String fieldName, OnFeature1ResponseListener onFeature1ResponseListener) {
        this.onFeature1ResponseListener = onFeature1ResponseListener;
        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setFieldName(fieldName);
        ApiClientImpl.getApiClientImpl().getCommonApiInterface().postApiMethod(apiKey, sampleRequest).enqueue(baseResponseCallback);
    }

    private void onFeature1Response(Response response, Throwable throwable) {
        SampleResponse sampleResponse;
        if (throwable != null) {
            sampleResponse = new SampleResponse();
            sampleResponse.setError(throwable.getMessage());
        } else {
            sampleResponse = (SampleResponse) response.body();
        }
        if (onFeature1ResponseListener != null)
            onFeature1ResponseListener.onFeature1Response(sampleResponse);
    }
}
