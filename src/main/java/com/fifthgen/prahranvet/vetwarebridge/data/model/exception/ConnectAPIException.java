package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public abstract class ConnectAPIException extends Exception {

    public ConnectAPIException(String msg) {
        super(msg);
    }
}
