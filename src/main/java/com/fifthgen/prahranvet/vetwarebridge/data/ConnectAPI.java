package com.fifthgen.prahranvet.vetwarebridge.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fifthgen.prahranvet.vetwarebridge.Application;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrderCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrdersCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.PostOrderCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderPlaced;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.BadRequestException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.NotFoundException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.RequestCancelledException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.UnauthorizedException;
import com.fifthgen.prahranvet.vetwarebridge.utility.ConnectionManager;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyKey;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class ConnectAPI {

    private static final String AUTHORIZE = "/";
    private static final String ORDERS = "/orders";
    private static final String ORDER = "/orders/%d";
    private static final String PRODUCT = "/product";

    private final String client;
    private final String practiceName;

    private final String accountCode;
    private final String userId;
    private final String clientToken;
    private final String userToken;

    private final String apiUrl;

    public ConnectAPI(PropertyManager propertyManager) {
        client = propertyManager.getProperty(PropertyKey.CLIENT.getKey());
        practiceName = propertyManager.getProperty(PropertyKey.PRACTICE_NAME.getKey());

        accountCode = propertyManager.getProperty(PropertyKey.ACCOUNT_CODE.getKey());
        userId = propertyManager.getProperty(PropertyKey.USER_ID.getKey());
        clientToken = propertyManager.getProperty(PropertyKey.CLIENT_TOKEN.getKey());
        userToken = propertyManager.getProperty(PropertyKey.USER_TOKEN.getKey());

        apiUrl = propertyManager.getProperty(PropertyKey.API_URL.getKey());
    }

    /**
     * Setup the default headers required by every API request.
     *
     * @return An array of required <code>{@link Header}</code> objects.
     */
    private Header[] setUpHeaders() {
        Header[] headers = new Header[9];
        headers[0] = new BasicHeader(HttpHeaders.ACCEPT, "application/json");
        headers[1] = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        headers[2] = new BasicHeader("Api-Version", "1");
        headers[3] = new BasicHeader("User-Auth", userToken);
        headers[4] = new BasicHeader("Client", client);
        headers[5] = new BasicHeader("Client-Auth", clientToken);
        headers[6] = new BasicHeader("Practice", practiceName);
        headers[7] = new BasicHeader("User", userId);
        headers[8] = new BasicHeader("Account-Code", accountCode);

        return headers;
    }

    public void getOrders(GetOrdersCallback callback) {
        HttpGet getRequest = new HttpGet(apiUrl + ORDERS);
        getRequest.setHeaders(setUpHeaders());

        ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
        connectionManager.connect(getRequest, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                switch (result.getStatusLine().getStatusCode()) {
                    case 200:
                        HttpEntity entity = result.getEntity();
                        ObjectMapper mapper = new ObjectMapper();

                        try {
                            callback.onCompleted(mapper.readValue(EntityUtils.toString(entity), OrderSummary[].class));
                            return;
                        } catch (IOException e) {
                            String msg = "Couldn't convert entity into OrderSummary[]";
                            Logger.getGlobal().severe(msg + ": \n" + e.getLocalizedMessage());
                            callback.onFailed(e);
                        }
                    case 400:
                        Logger.getGlobal().severe("400 - Bad request");
                        callback.onFailed(new BadRequestException());
                    case 401:
                        Logger.getGlobal().severe("401 - Unauthorized");
                        callback.onFailed(new UnauthorizedException());
                    case 404:
                        Logger.getGlobal().severe("404 - Not found");
                        callback.onFailed(new NotFoundException());
                }
            }

            @Override
            public void failed(Exception ex) {
                Logger.getGlobal().severe("Exception in request: \n" + ex.getLocalizedMessage());
                callback.onFailed(ex);
            }

            @Override
            public void cancelled() {
                Logger.getGlobal().warning("Request cancelled");
                callback.onFailed(new RequestCancelledException());
            }
        });
    }

    public void getOrder(int orderId, GetOrderCallback callback) {
        HttpGet getRequest = new HttpGet(apiUrl + String.format(ORDER, orderId));
        getRequest.setHeaders(setUpHeaders());

        ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
        connectionManager.connect(getRequest, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                switch (result.getStatusLine().getStatusCode()) {
                    case 200:
                        HttpEntity entity = result.getEntity();
                        ObjectMapper mapper = new ObjectMapper();

                        try {
                            callback.onCompleted(mapper.readValue(EntityUtils.toString(entity), Order.class));
                            return;
                        } catch (IOException e) {
                            String msg = "Couldn't convert entity into Order";
                            Logger.getGlobal().severe(msg + ": \n" + e.getLocalizedMessage());
                            callback.onFailed(e);
                        }
                    case 400:
                        Logger.getGlobal().severe("400 - Bad request");
                        callback.onFailed(new BadRequestException());
                    case 401:
                        Logger.getGlobal().severe("401 - Unauthorized");
                        callback.onFailed(new UnauthorizedException());
                    case 404:
                        Logger.getGlobal().severe("404 - Not found");
                        callback.onFailed(new NotFoundException());
                }
            }

            @Override
            public void failed(Exception ex) {
                Logger.getGlobal().severe("Exception in request: \n" + ex.getLocalizedMessage());
                callback.onFailed(ex);
            }

            @Override
            public void cancelled() {
                Logger.getGlobal().warning("Request cancelled");
                callback.onFailed(new RequestCancelledException());
            }
        });
    }

    public void postOrder(PostOrderCallback callback) {
        HttpPost postRequest = new HttpPost(apiUrl + ORDERS);
        postRequest.setHeaders(setUpHeaders());

        ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
        connectionManager.connect(postRequest, new FutureCallback<HttpResponse>() {

            @Override
            public void completed(HttpResponse result) {
                switch (result.getStatusLine().getStatusCode()) {
                    case 201:
                        HttpEntity entity = result.getEntity();
                        ObjectMapper mapper = new ObjectMapper();

                        try {
                            callback.onCompleted(mapper.readValue(EntityUtils.toString(entity), OrderPlaced.class));
                            return;
                        } catch (IOException e) {
                            String msg = "Couldn't convert entity into OrderPlaced";
                            Logger.getGlobal().severe(msg + ": \n" + e.getLocalizedMessage());
                            callback.onFailed(e);
                        }
                    case 400:
                        Logger.getGlobal().severe("400 - Bad request");
                        callback.onFailed(new BadRequestException());
                    case 401:
                        Logger.getGlobal().severe("401 - Unauthorized");
                        callback.onFailed(new UnauthorizedException());
                    case 404:
                        Logger.getGlobal().severe("404 - Not found");
                        callback.onFailed(new NotFoundException());
                }
            }

            @Override
            public void failed(Exception ex) {
                Logger.getGlobal().severe("Exception in request: \n" + ex.getLocalizedMessage());
                callback.onFailed(ex);
            }

            @Override
            public void cancelled() {
                Logger.getGlobal().warning("Request cancelled");
                callback.onFailed(new RequestCancelledException());
            }
        });
    }
}
