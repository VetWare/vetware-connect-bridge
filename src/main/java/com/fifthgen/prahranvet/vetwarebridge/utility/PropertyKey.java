package com.fifthgen.prahranvet.vetwarebridge.utility;

public enum PropertyKey {
    CLIENT("client"),
    PRACTICE_NAME("practice-name"),
    NAME("name"),
    EMAIL("email"),
    STREET_ADDRESS("street-address"),
    SUBURB("suburb"),
    STATE("state"),
    POSTCODE("postcode"),
    COUNTRY("country"),
    ACCOUNT_CODE("account-code"),
    USER_ID("user-id"),
    CLIENT_TOKEN("client-token"),
    USER_TOKEN("user-token"),
    API_URL("api-url"),
    PO_CNT("po-cnt"),
    LAST_SAVE_DIR("last-save-dir");

    private final String key;

    PropertyKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
