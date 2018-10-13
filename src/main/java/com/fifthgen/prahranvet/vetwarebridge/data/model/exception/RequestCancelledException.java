package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class RequestCancelledException extends ConnectAPIException {

    public RequestCancelledException() {
        super("HttpRequest cancelled.");
    }
}
