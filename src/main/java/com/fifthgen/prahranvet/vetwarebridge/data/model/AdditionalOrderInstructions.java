package com.fifthgen.prahranvet.vetwarebridge.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AdditionalOrderInstructions {

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("DeliveryInstructions")
    private String deliveryInstructions;

    @JsonProperty("IncludeInvoiceWithDelivery")
    private Boolean includeInvoiceWithDelivery;

    @JsonProperty("RequestedDeliveryDate")
    private Date requestedDeliveryDate;

    @JsonProperty("ShipWithNextOrder")
    private Boolean shipWithNextOrder;

    @JsonProperty("PickUp")
    private Boolean pickUp;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public Boolean getIncludeInvoiceWithDelivery() {
        return includeInvoiceWithDelivery;
    }

    public void setIncludeInvoiceWithDelivery(Boolean includeInvoiceWithDelivery) {
        this.includeInvoiceWithDelivery = includeInvoiceWithDelivery;
    }

    public Date getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    public void setRequestedDeliveryDate(Date requestedDeliveryDate) {
        this.requestedDeliveryDate = requestedDeliveryDate;
    }

    public Boolean getShipWithNextOrder() {
        return shipWithNextOrder;
    }

    public void setShipWithNextOrder(Boolean shipWithNextOrder) {
        this.shipWithNextOrder = shipWithNextOrder;
    }

    public Boolean getPickUp() {
        return pickUp;
    }

    public void setPickUp(Boolean pickUp) {
        this.pickUp = pickUp;
    }
}
