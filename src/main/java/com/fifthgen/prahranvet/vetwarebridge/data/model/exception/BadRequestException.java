package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class BadRequestException extends ConnectAPIException {

    public BadRequestException() {
        super("You've sent a bad request to the server. Possible causes are missing request headers.");
    }
}
