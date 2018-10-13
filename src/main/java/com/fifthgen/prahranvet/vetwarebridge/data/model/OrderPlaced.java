package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Objects;

public class OrderPlaced {

    private Integer orderId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPlaced that = (OrderPlaced) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(confirmationURL, that.confirmationURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, confirmationURL);
    }

    @Override
    public String toString() {
        return "OrderPlaced{" +
                "orderId=" + orderId +
                ", confirmationURL='" + confirmationURL + '\'' +
                '}';
    }
}
