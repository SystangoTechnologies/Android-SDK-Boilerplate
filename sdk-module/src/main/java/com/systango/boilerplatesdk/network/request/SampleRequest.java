package com.systango.boilerplatesdk.network.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohit Rajput on 3/12/18.
 */

public class SampleRequest extends BaseRequest {

    @SerializedName("fieldName")
    private String fieldName;

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
