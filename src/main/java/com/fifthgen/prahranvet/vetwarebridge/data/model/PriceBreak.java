package com.fifthgen.prahranvet.vetwarebridge.data.model;

public class PriceBreak {

    private Integer quantity;
    private Double price;

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

    @Override
    public String toString() {
        return "PriceBreak{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
