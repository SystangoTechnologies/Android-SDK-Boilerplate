package com.systango.boilerplatesdk.network.interfaces;

/**
 * Created by Mohit Rajput on 3/12/18.
 */

public interface ApiClient {
    int TIMEOUT_IN_SECONDS = 120;

    CommonApiInterface getCommonApiInterface();
}
