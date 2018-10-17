package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

public class BadDestinationFileException extends OrderFileException {

    public BadDestinationFileException() {
        super("Destination file cannot be written to. Make sure the file is writable.");
    }
}
