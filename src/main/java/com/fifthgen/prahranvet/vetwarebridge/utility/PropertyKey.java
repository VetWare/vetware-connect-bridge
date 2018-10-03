package com.fifthgen.prahranvet.vetwarebridge.utility;

public enum PropertyKey {
    CLIENT("client"),
    PRACTICE_NAME("practice-name"),
    ACCOUNT_CODE("account-code"),
    USER_ID("user-id"),
    CLIENT_TOKEN("client-token"),
    USER_TOKEN("user-token"),
    API_URL("api-url");

    private final String key;

    PropertyKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
