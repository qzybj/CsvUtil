package com.brady.csvutil.model;

/**
 * Created by Clair
 *
 * @date 2017/8/9
 * @description
 */
public class ProductInfo {
    private String name;
    private String property;
    private String artNo;
    private String barcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getArtNo() {
        return artNo;
    }

    public void setArtNo(String artNo) {
        this.artNo = artNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
