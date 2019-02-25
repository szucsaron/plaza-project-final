package com.codecool.plaza.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlazaImpl implements  Plaza {
    /*
        You're going to create an actual implementation of the Plaza interface, you can call it anything, we'llcall it
        PlazaImpl. _ This implementation stores the shops available in a plaza in a list. You don't need to create multiple
        implementation of a _Plaza for now.

        -List<Shop> shops
        +PlazaImpl()
     */

    private Map<String, Shop> shopNames= new HashMap<>();
    private boolean open = false;
    public List<Shop> getShops() {
        return new ArrayList<Shop>();
    }
    public void addShop(Shop shop) {

        shopNames.put(shop.getName(), shop);
    }
    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        if (!open) {
            throw new PlazaIsClosedException();
        }
        if (shopNames.containsKey(shop.getName())) {
            shopNames.remove(shop.getName());

        } else {
            throw new NoSuchShopException();
        }
    }
    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        if (!open) {
            throw new PlazaIsClosedException();
        }
        if (shopNames.containsKey(name)) {
            return shopNames.get(name);
        } else {
            throw new NoSuchShopException();
        }
    }
    public boolean isOpen() {
        return open;
    }
    public void open() {
        open = true;
    }
    public void close() {
        open = false;
    }
    public String toString() {
        return "";
    }
}
