package com.codecool.plaza.cmdprog;

import com.codecool.plaza.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args) {
        CmdProgram cmdProgram = new CmdProgram();
        cmdProgram.run();
        experiment();
    }

    public static void experiment() {
        PlazaImpl plaza = new PlazaImpl();
        plaza.open();
        ShopImpl shop = new ShopImpl("bót", "jancsi");
        ShopImpl shop2 = new ShopImpl("üzlet", "irén");

        plaza.addShop(shop);
        plaza.addShop(shop2);
        shop.open();

        Product p1 = new ClothingProduct(123456, "cheap jacket", "ASDFASD Inc.", "owlskin", "jacket");
        Product p2 = new ClothingProduct(234344, "generic t-shirt", "Padlizsán Industries", "wool", "t-shirt");

        try {
            shop.addNewProduct(p1, 1, 10);
            shop.addNewProduct(p2, 1, 10);

            shop.buyProduct(123456);

        } catch (PlazaMasterException e) {
            System.out.println(e);
        }

        System.out.println(shop);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date foodDate = null;
        try {
            foodDate = simpleDateFormat.parse("2019-02-08");

        } catch (ParseException e) {
            System.out.println(e);
        }


        FoodProduct fp = new FoodProduct(12456, "cheese", "dfsd", 1312, foodDate);
        System.out.println(fp.isStillConsumable());

        Cat cat1 = new Cat("aaow", 1);
        Cat cat2 = new Cat("abaa", 2);
        System.out.println(cat1.compareTo(cat2));


    }
}
