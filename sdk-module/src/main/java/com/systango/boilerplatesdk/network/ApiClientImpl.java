package com.systango.boilerplatesdk.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.systango.boilerplatesdk.network.interceptor.CommonInterceptor;
import com.systango.boilerplatesdk.network.interfaces.ApiClient;
import com.systango.boilerplatesdk.network.interfaces.CommonApiInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohit Rajput on 3/12/18.
 * Provides API interface of retrofit
 */

public class ApiClientImpl implements ApiClient {

    private static ApiClientImpl apiClientImpl = null;
    private static CommonApiInterface commonApiInterface;

    private ApiClientImpl() {
    }

    public static ApiClientImpl getApiClientImpl() {
        if (apiClientImpl == null) {
            apiClientImpl = new ApiClientImpl();
        }
        return apiClientImpl;
    }

    @Override
    public CommonApiInterface getCommonApiInterface() {
        if (commonApiInterface == null) {
            commonApiInterface = createRetrofitInstance(ClientType.COMMON).create(CommonApiInterface.class);
        }
        return commonApiInterface;
    }

    private Interceptor getInterceptor(ClientType clientType) {
        if (clientType == ClientType.COMMON) {
            return new CommonInterceptor();
        }
        return null;
    }

    private OkHttpClient createOkHttpClient(ClientType clientType) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(getInterceptor(clientType)).build();
        return okHttpClient;
    }

    private Retrofit createRetrofitInstance(ClientType clientType) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getApiUrl(clientType))
                .client(createOkHttpClient(clientType))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    private String getApiUrl(ClientType clientType) {
        if (clientType == ClientType.COMMON) {
            return ApiUrls.BASE_URL;
        }
        return null;
    }

    private enum ClientType {COMMON}
}
