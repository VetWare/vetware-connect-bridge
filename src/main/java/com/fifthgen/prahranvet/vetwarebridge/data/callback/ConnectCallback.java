package com.fifthgen.prahranvet.vetwarebridge.data.callback;

import org.apache.http.HttpResponse;

public interface ConnectCallback {

    void onCompleted(HttpResponse response);

    void onFailed(Exception e);

    void onCancelled();
}
