package com.systango.boilerplatesdk.network.interceptor;

import com.systango.boilerplatesdk.constants.KeyConstants;
import com.systango.boilerplatesdk.utils.DeviceUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mohit Rajput on 3/12/18.
 * Common interceptor for Retrofit requests
 */

public class CommonInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader(KeyConstants.USER_AGENT, DeviceUtils.getUserAgent())
                .addHeader(KeyConstants.PLATFORM, DeviceUtils.getDeviceOs())
                .build();
        return chain.proceed(request);
    }
}
