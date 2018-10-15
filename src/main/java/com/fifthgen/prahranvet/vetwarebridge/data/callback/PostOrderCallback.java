package com.fifthgen.prahranvet.vetwarebridge.data.callback;

import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderPlaced;

public interface PostOrderCallback extends ConnectCallback {

    void onCompleted(OrderPlaced orderPlaced);

    @Override
    void onFailed(Exception e);
}
