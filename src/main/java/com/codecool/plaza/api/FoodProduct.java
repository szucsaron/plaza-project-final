package com.codecool.plaza.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProduct extends Product {
    /*
            -int calories
            -Date bestBefore
            +FoodProduct(long barcode, String name, String manufacturer, int calories, Date bestBefore)
            +boolean isStillConsumable()
            +int getCalories()
            +String toString()
         */
    int calories;
    Date bestBefore;


    public FoodProduct(long barcode, String name, String manufacturer, int calories, Date bestBefore) {
        super(barcode, name, manufacturer);
        this.calories = calories;
        this.bestBefore = bestBefore;
    }

    public boolean isStillConsumable() {
        DateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentdate = new Date();
        return (currentdate.getTime() < bestBefore.getTime());
    }

    public int getCalories() {
        return calories;
    }

    public String toString() {
        return (name);
    }
}
