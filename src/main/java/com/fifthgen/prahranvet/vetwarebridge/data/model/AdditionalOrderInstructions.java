package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Date;
import java.util.Objects;

public class AdditionalOrderInstructions {

    private String notes;
    private String deliveryInstructions;
    private Boolean includeInvoiceWithGoods;
    private Date requestedDeliveryDate;
    private Boolean shipWithNextOrder;
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

    public Boolean getIncludeInvoiceWithGoods() {
        return includeInvoiceWithGoods;
    }

    public void setIncludeInvoiceWithGoods(Boolean includeInvoiceWithGoods) {
        this.includeInvoiceWithGoods = includeInvoiceWithGoods;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalOrderInstructions that = (AdditionalOrderInstructions) o;
        return Objects.equals(notes, that.notes) &&
                Objects.equals(deliveryInstructions, that.deliveryInstructions) &&
                Objects.equals(includeInvoiceWithGoods, that.includeInvoiceWithGoods) &&
                Objects.equals(requestedDeliveryDate, that.requestedDeliveryDate) &&
                Objects.equals(shipWithNextOrder, that.shipWithNextOrder) &&
                Objects.equals(pickUp, that.pickUp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes, deliveryInstructions, includeInvoiceWithGoods, requestedDeliveryDate, shipWithNextOrder, pickUp);
    }

    @Override
    public String toString() {
        return "AdditionalOrderInstructions{" +
                "notes='" + notes + '\'' +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                ", includeInvoiceWithGoods=" + includeInvoiceWithGoods +
                ", requestedDeliveryDate=" + requestedDeliveryDate +
                ", shipWithNextOrder=" + shipWithNextOrder +
                ", pickUp=" + pickUp +
                '}';
    }
}
