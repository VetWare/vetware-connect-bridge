package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Date;
import java.util.Objects;

public class OrderSummary {

    private Integer orderId;
    private Date date;
    private String purchaseOrderNumber;
    private String status;
    private Date updatedOn;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSummary summary = (OrderSummary) o;
        return Objects.equals(orderId, summary.orderId) &&
                Objects.equals(date, summary.date) &&
                Objects.equals(purchaseOrderNumber, summary.purchaseOrderNumber) &&
                Objects.equals(status, summary.status) &&
                Objects.equals(updatedOn, summary.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, date, purchaseOrderNumber, status, updatedOn);
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", status='" + status + '\'' +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
