package com.systango.boilerplatesdk.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohit Rajput on 25/4/18.
 * Base response of all other API responses. Do not make setters here and in child responses.
 */

class BaseResponse {
    @SerializedName("baseField")
    private String baseField;

    @SerializedName("error")
    private String error;

    public String getBaseField() {
        return baseField;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
