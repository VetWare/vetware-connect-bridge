package com.fifthgen.prahranvet.vetwarebridge.data.callback;

import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;

public interface GetOrdersCallback extends ConnectCallback {

    void onCompleted(OrderSummary[] orderSummaries);

    @Override
    void onFailed(Exception e);
}
