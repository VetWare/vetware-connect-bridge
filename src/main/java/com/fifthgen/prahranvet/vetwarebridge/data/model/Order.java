package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Arrays;
import java.util.Objects;

public class Order {

    private String id;
    private String status;
    private String purchaseOrderNumber;
    private Sender sender;
    private AdditionalOrderInstructions additionalOrderInstructions;
    private Address shipTo;
    private OrderLine[] orderLines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public AdditionalOrderInstructions getAdditionalOrderInstructions() {
        return additionalOrderInstructions;
    }

    public void setAdditionalOrderInstructions(AdditionalOrderInstructions additionalOrderInstructions) {
        this.additionalOrderInstructions = additionalOrderInstructions;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public OrderLine[] getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(OrderLine[] orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(status, order.status) &&
                Objects.equals(purchaseOrderNumber, order.purchaseOrderNumber) &&
                Objects.equals(sender, order.sender) &&
                Objects.equals(additionalOrderInstructions, order.additionalOrderInstructions) &&
                Objects.equals(shipTo, order.shipTo) &&
                Arrays.equals(orderLines, order.orderLines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, status, purchaseOrderNumber, sender, additionalOrderInstructions, shipTo);
        result = 31 * result + Arrays.hashCode(orderLines);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", sender=" + sender +
                ", additionalOrderInstructions=" + additionalOrderInstructions +
                ", shipTo=" + shipTo +
                ", orderLines=" + Arrays.toString(orderLines) +
                '}';
    }
}
