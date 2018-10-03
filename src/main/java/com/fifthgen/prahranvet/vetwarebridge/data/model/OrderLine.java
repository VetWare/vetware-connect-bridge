package com.fifthgen.prahranvet.vetwarebridge.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderLine {

    @JsonProperty("LineItemNumber")
    private String lineItemNumber;

    @JsonProperty("ProductCode")
    private String productCode;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("Price")
    private Double price;

    @JsonProperty("Critical")
    private Boolean critical;

    @JsonProperty("Notes")
    private String notes;

    public String getLineItemNumber() {
        return lineItemNumber;
    }

    public void setLineItemNumber(String lineItemNumber) {
        this.lineItemNumber = lineItemNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getCritical() {
        return critical;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
