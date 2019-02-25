package com.codecool.plaza.api;

public abstract class Product {


    /*
            Represents products markated in shops. It's abstract, so you can supply your own implementation. Don't create
            lots of subclasses, 2-3 is enough, see the examples below - you can use these or create your own.

            #long barcode
            #String name
            #String manufacturer
            #Product(long barcode, String name, String manufacturer)
            +long getBarcode()
            +String getName()
            +String getManufacturer()
            +String toString()
         */
    protected long barcode;
    protected String name;

    public String getManufacturer() {
        return manufacturer;
    }

    protected String manufacturer;

    public Product(long barcode, String name, String manufacturer) {
        this.barcode = barcode;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public long getBarcode() {
        return barcode;
    }
}
