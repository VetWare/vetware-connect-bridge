package com.fifthgen.prahranvet.vetwarebridge.data.model;


import java.util.Arrays;
import java.util.Date;

public class Product {

    private String productCode;
    private String description;
    private Double listPrice;
    private Double price;
    private Boolean gst;
    private PriceBreak[] priceBreak;
    private Double rrp;
    private Integer stockAvailable;
    private Date eta;
    private String[] barcode;
    private String picture;
    private String manufacturer;
    private String manufacturerCode;
    private Double weight;
    private Double length;
    private Double breadth;
    private Double height;
    private Integer dispensingUnit;
    private String unitOfMeasure;
    private String therapeuticIndex;
    private String dangerousGoodsClass;
    private Boolean discontinued;
    private Boolean specialOrder;
    private Boolean nonReturnable;
    private String poisonSchedule;
    private String infoSheetUrl;
    private String msdsUrl;
    private String url;
    private Date createdOn;
    private Date updatedOn;

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

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getGst() {
        return gst;
    }

    public void setGst(Boolean gst) {
        this.gst = gst;
    }

    public PriceBreak[] getPriceBreak() {
        return priceBreak;
    }

    public void setPriceBreak(PriceBreak[] priceBreak) {
        this.priceBreak = priceBreak;
    }

    public Double getRrp() {
        return rrp;
    }

    public void setRrp(Double rrp) {
        this.rrp = rrp;
    }

    public Integer getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Integer stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public String[] getBarcode() {
        return barcode;
    }

    public void setBarcode(String[] barcode) {
        this.barcode = barcode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getBreadth() {
        return breadth;
    }

    public void setBreadth(Double breadth) {
        this.breadth = breadth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getDispensingUnit() {
        return dispensingUnit;
    }

    public void setDispensingUnit(Integer dispensingUnit) {
        this.dispensingUnit = dispensingUnit;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getTherapeuticIndex() {
        return therapeuticIndex;
    }

    public void setTherapeuticIndex(String therapeuticIndex) {
        this.therapeuticIndex = therapeuticIndex;
    }

    public String getDangerousGoodsClass() {
        return dangerousGoodsClass;
    }

    public void setDangerousGoodsClass(String dangerousGoodsClass) {
        this.dangerousGoodsClass = dangerousGoodsClass;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Boolean getSpecialOrder() {
        return specialOrder;
    }

    public void setSpecialOrder(Boolean specialOrder) {
        this.specialOrder = specialOrder;
    }

    public Boolean getNonReturnable() {
        return nonReturnable;
    }

    public void setNonReturnable(Boolean nonReturnable) {
        this.nonReturnable = nonReturnable;
    }

    public String getPoisonSchedule() {
        return poisonSchedule;
    }

    public void setPoisonSchedule(String poisonSchedule) {
        this.poisonSchedule = poisonSchedule;
    }

    public String getInfoSheetUrl() {
        return infoSheetUrl;
    }

    public void setInfoSheetUrl(String infoSheetUrl) {
        this.infoSheetUrl = infoSheetUrl;
    }

    public String getMsdsUrl() {
        return msdsUrl;
    }

    public void setMsdsUrl(String msdsUrl) {
        this.msdsUrl = msdsUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", listPrice=" + listPrice +
                ", price=" + price +
                ", gst=" + gst +
                ", priceBreak=" + Arrays.toString(priceBreak) +
                ", rrp=" + rrp +
                ", stockAvailable=" + stockAvailable +
                ", eta=" + eta +
                ", barcode=" + Arrays.toString(barcode) +
                ", picture='" + picture + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                ", weight=" + weight +
                ", length=" + length +
                ", breadth=" + breadth +
                ", height=" + height +
                ", dispensingUnit=" + dispensingUnit +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", therapeuticIndex='" + therapeuticIndex + '\'' +
                ", dangerousGoodsClass='" + dangerousGoodsClass + '\'' +
                ", discontinued=" + discontinued +
                ", specialOrder=" + specialOrder +
                ", nonReturnable=" + nonReturnable +
                ", poisonSchedule='" + poisonSchedule + '\'' +
                ", infoSheetUrl='" + infoSheetUrl + '\'' +
                ", msdsUrl='" + msdsUrl + '\'' +
                ", url='" + url + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
