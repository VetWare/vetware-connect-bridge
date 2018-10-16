package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Objects;

public class OrderPlaced {

    private Integer orderId;
    private String confirmationUrl;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getConfirmationUrl() {
        return confirmationUrl;
    }

    public void setConfirmationUrl(String confirmationUrl) {
        this.confirmationUrl = confirmationUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPlaced that = (OrderPlaced) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(confirmationUrl, that.confirmationUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, confirmationUrl);
    }

    @Override
    public String toString() {
        return "OrderPlaced{" +
                "orderId=" + orderId +
                ", confirmationUrl='" + confirmationUrl + '\'' +
                '}';
    }
}
