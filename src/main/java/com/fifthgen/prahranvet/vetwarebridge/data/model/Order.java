package com.fifthgen.prahranvet.vetwarebridge.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("PurchaseOrderNumber")
    private String purchaseOrderNumber;

    @JsonProperty("Sender")
    private Sender sender;

    @JsonProperty("AdditionalOrderInstructions")
    private AdditionalOrderInstructions additionalOrderInstructions;

    @JsonProperty("ShipTo")
    private Address shipTo;

    @JsonProperty("OrderLines")
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
}
