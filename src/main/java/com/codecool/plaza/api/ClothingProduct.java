package com.codecool.plaza.api;

public class ClothingProduct extends Product {


    /*
            -String material
            -String type
            +ClothingProduct(long barcode, String name, String manufacturer, String material, String type)
            +String getMaterial()
            +String getType()
            +String toString()
         */
    private String material;


    private String type;

    public ClothingProduct(long barcode, String name, String manufacturer, String material, String type) {
        super(barcode, name, manufacturer);
        this.material = material;
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

}
