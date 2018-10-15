package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class InvalidFileException extends OrderFileException {

    public InvalidFileException() {
        super("The order file appear to be malformed or is invalid.");
    }
}
