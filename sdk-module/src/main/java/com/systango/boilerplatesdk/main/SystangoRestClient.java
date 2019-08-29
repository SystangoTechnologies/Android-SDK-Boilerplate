package com.systango.boilerplatesdk.main;

import com.systango.boilerplatesdk.listener.Feature1ResponseListener;
import com.systango.boilerplatesdk.network.ApiClientImpl;
import com.systango.boilerplatesdk.network.BaseResponseCallback;
import com.systango.boilerplatesdk.network.request.SampleRequest;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohit Rajput on 3/12/18.
 * This client initialize SDK with a valid APK and contains number of feature methods
 */

public class SystangoRestClient implements SystangoClient {
    private String apiKey;
    private ResponseHandler responseHandler = new ResponseHandler();
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
            responseHandler.handleResponse(apiUrl, response, throwable);
        }
    };

    public SystangoRestClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void feature1Method(String fieldName, Feature1ResponseListener feature1ResponseListener) {
        responseHandler.setFeature1ResponseListener(feature1ResponseListener);
        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setFieldName(fieldName);
        ApiClientImpl.getApiClientImpl().getCommonApiInterface().postApiMethod(apiKey, sampleRequest).enqueue(baseResponseCallback);
    }
}
