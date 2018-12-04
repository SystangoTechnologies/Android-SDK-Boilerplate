package com.systango.boilerplatesdk.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohit Rajput on 3/12/18.
 */

public class SampleResponse extends BaseResponse {
    @SerializedName("fieldName")
    String fieldName;

    public String getFieldName() {
        return fieldName;
    }
}
