package com.systango.boilerplatesdk.network.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohit Rajput on 3/12/18.
 * Base request of all other API requests. Do not make getters here and in child responses.
 */

class BaseRequest {
    @SerializedName("baseField")
    private String baseField;

    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }
}
