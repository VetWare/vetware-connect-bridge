package com.fifthgen.prahranvet.vetwarebridge.data.model;

import java.util.Arrays;
import java.util.Objects;

public class OrderError {

    private String purchaseOrderNumber;
    private String[] errors;

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderError that = (OrderError) o;
        return Objects.equals(purchaseOrderNumber, that.purchaseOrderNumber) &&
                Arrays.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(purchaseOrderNumber);
        result = 31 * result + Arrays.hashCode(errors);
        return result;
    }

    @Override
    public String toString() {
        return "OrderError{" +
                "purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", errors=" + Arrays.toString(errors) +
                '}';
    }
}
