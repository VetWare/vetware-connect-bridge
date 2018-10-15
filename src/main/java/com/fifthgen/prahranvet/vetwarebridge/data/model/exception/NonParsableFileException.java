package com.fifthgen.prahranvet.vetwarebridge.data.model.exception;

import java.io.IOException;

public class NonParsableFileException extends OrderFileException {

    public NonParsableFileException() {
        super("Couldn't parse the order file.");
    }

    public NonParsableFileException(IOException e) {
        super("Couldn't parse the order file. CSV parser returned: " + e.getLocalizedMessage());
    }
}
