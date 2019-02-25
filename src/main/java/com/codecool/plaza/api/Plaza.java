package com.codecool.plaza.api;

import java.util.List;

public interface Plaza {
    /*
        The Plaza interface defines how can we interact with a plaza. Almost all methods throws a PlazaIsClosedException
        if we invoke a method when a Plaza instance isn't open yet. User's will be able to open and close a Plaza
        (see later).

        +List<Shop> getShops() throws PlazaIsClosedException
        +void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException
        +void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException
        +Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException
        +boolean isOpen()
        +void open()
        +void close()
        +String toString()
     */

    public List<Shop> getShops();

    public void addShop(Shop shop);

    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException;

    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException;

    public boolean isOpen();

    void open();

    void close();

    String toString();

}
