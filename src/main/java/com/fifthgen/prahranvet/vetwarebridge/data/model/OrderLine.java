package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Objects;

public class OrderLine {

    private String lineItemNumber;
    private String productCode;
    private String description;
    private Integer quantity;
    private Double price;
    private Boolean critical;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(lineItemNumber, orderLine.lineItemNumber) &&
                Objects.equals(productCode, orderLine.productCode) &&
                Objects.equals(description, orderLine.description) &&
                Objects.equals(quantity, orderLine.quantity) &&
                Objects.equals(price, orderLine.price) &&
                Objects.equals(critical, orderLine.critical) &&
                Objects.equals(notes, orderLine.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineItemNumber, productCode, description, quantity, price, critical, notes);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "lineItemNumber='" + lineItemNumber + '\'' +
                ", productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", critical=" + critical +
                ", notes='" + notes + '\'' +
                '}';
    }
}
