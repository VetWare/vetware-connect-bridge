package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class UnauthorizedException extends ConnectAPIException {

    public UnauthorizedException() {
        super("You're unauthorized to access this resource. Possible causes are incorrect authentication headers.");
    }
}
