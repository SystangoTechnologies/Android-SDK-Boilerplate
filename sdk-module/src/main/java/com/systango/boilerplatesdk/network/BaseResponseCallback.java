package com.systango.boilerplatesdk.network;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohit Rajput on 3/12/18.
 * Base response callback for Retrofit's API response
 */

public abstract class BaseResponseCallback<T> implements Callback<T> {

    public final static int CODE_SESSION_EXPIRED = 401;
    private int retryCount;

    public BaseResponseCallback() {
    }

    @Override
    public void onResponse(Call call, Response response) {
        int code = response.code();
        if (code >= 200 && code < 300) {
            success(call, response);
        } else if (code == CODE_SESSION_EXPIRED) {
            unauthenticated(call, response);
        }
        commonCallback(call, response, null);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
// Open this comment if you want APIs retry automatically on socket time out.
//            if (retryCount < 3) {
//                call.clone().enqueue(this);
//                retryCount++;
//            } else {
//                retryCount = 0;
//            }
        }
        commonCallback(call, null, t);
    }

    /**
     * Called for [200, 300) responses.
     */
    public abstract void success(Call call, Response<T> response);

    /**
     * Called when session gets expired of currently logged-in user. It is based on status code {@link #CODE_SESSION_EXPIRED}
     */
    public abstract void unauthenticated(Call call, Response<?> response);

    /**
     * Called every time to perform common tasks i.e. dismiss a progress dialog
     */
    public abstract void commonCallback(Call call, Response<?> response, Throwable throwable);
}
