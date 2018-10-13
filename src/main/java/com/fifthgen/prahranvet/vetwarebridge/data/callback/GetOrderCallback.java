package com.fifthgen.prahranvet.vetwarebridge.data.callback;

import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;

public interface GetOrderCallback extends ConnectCallback {

    void onCompleted(Order order);

    @Override
    void onFailed(Exception e);
}
