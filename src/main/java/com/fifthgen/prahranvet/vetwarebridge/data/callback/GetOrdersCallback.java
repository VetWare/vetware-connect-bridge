package com.fifthgen.prahranvet.vetwarebridge.data.callback;

import org.apache.http.HttpResponse;

public interface GetOrdersCallback extends ConnectCallback {

    @Override
    void onCompleted(HttpResponse response);

    @Override
    void onFailed(Exception e);

    @Override
    void onCancelled();
}
