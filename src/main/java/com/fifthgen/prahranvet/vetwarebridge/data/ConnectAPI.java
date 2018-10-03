package com.fifthgen.prahranvet.vetwarebridge.data;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fifthgen.prahranvet.vetwarebridge.Application;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.ConnectCallback;
import com.fifthgen.prahranvet.vetwarebridge.utility.ConnectionManager;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyKey;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyManager;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;

public class ConnectAPI {

    public static final String AUTHORIZE = "/";
    public static final String ORDERS = "/orders";
    public static final String ORDER = "/order";

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

    public void get(String path, ConnectCallback callback) {
        HttpGet getRequest = new HttpGet(apiUrl + path);
        getRequest.setHeaders(setUpHeaders());

        ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
        connectionManager.connect(getRequest, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                callback.onCompleted(result);
            }

            @Override
            public void failed(Exception ex) {
                callback.onFailed(ex);
            }

            @Override
            public void cancelled() {
                callback.onCancelled();
            }
        });
    }

    public void post(String path, JSONPObject body, ConnectCallback callback) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(apiUrl + path);
        httpPost.setHeaders(setUpHeaders());

        if (body != null)
            httpPost.setEntity(new StringEntity(body.toString()));

        ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
        connectionManager.connect(httpPost, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                callback.onCompleted(result);
            }

            @Override
            public void failed(Exception ex) {
                callback.onFailed(ex);
            }

            @Override
            public void cancelled() {
                callback.onCancelled();
            }
        });
    }
}
