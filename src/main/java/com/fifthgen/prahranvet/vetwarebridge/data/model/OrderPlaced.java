package com.fifthgen.prahranvet.vetwarebridge.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderPlaced {

    @JsonProperty("OrderId")
    private Integer orderId;

    @JsonProperty("ConfirmationURL")
    private String confirmationURL;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getConfirmationURL() {
        return confirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        this.confirmationURL = confirmationURL;
    }
}
