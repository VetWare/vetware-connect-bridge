package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class NotFoundException extends ConnectAPIException {

    public NotFoundException() {
        super("Resource not found. Possible causes are the query returned an empty data set.");
    }
}
