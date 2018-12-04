package com.systango.boilerplatesdk.network;


import com.systango.boilerplatesdk.BuildConfig;

/**
 * Created by Mohit Rajput on 16/4/18.
 * This file contains path of all REST web services
 */

public interface ApiUrls {
    String BASE_URL = BuildConfig.BASE_URL;

    //Server APIs
    String COMMON_PATH_SERVER = "/api/";
    String POST_API_URL = COMMON_PATH_SERVER + "api_path";
}
