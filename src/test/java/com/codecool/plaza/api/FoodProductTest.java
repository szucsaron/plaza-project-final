package com.codecool.plaza.api;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {
    @Test
    void isStillConsumable() {
        Date date = new Date();
        date = new Date(date.getTime());
        FoodProduct foodProduct = new FoodProduct(12345, "", "", 0, new Date(date.getTime() - 10000));
        assertFalse(foodProduct.isStillConsumable());
        foodProduct = new FoodProduct(12345, "", "", 0, new Date(date.getTime() + 10000));
        assertTrue(foodProduct.isStillConsumable());

    }

    @Test
    void testCalories() {
        Date date = new Date();
        date = new Date(date.getTime());
        FoodProduct foodProduct = new FoodProduct(12345, "", "", 0, new Date(date.getTime() - 10000));
        assertFalse(foodProduct.isStillConsumable());
        foodProduct = new FoodProduct(12345, "", "", 0, new Date(date.getTime() + 10000));
        assertTrue(foodProduct.isStillConsumable());
    }

}
