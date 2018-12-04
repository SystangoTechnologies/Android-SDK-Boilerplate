package com.systango.boilerplatesdk.network.interfaces;

import com.systango.boilerplatesdk.constants.KeyConstants;
import com.systango.boilerplatesdk.network.request.SampleRequest;
import com.systango.boilerplatesdk.network.response.SampleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static com.systango.boilerplatesdk.network.ApiUrls.POST_API_URL;

/**
 * Created by Mohit Rajput on 3/12/18.
 * Retrofit API interface
 */
public interface CommonApiInterface {
    @POST(POST_API_URL)
    Call<SampleResponse> postApiMethod(@Header(KeyConstants.HEADER_API_KEY) String apiKey, @Body SampleRequest sampleRequest);
}
