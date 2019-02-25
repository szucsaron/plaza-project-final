package com.codecool.plaza.api;

import java.util.List;

public interface Shop {
    /*
        The Shop interface defines how users can interact with a shop that stores products. Product is an abstract
        class (see below) and Shop objects can store objects like these. Users can add new products to a shop and
        increase the number of items in shop by their barcodes. Most methods of a shop throws ShopIsClosedException
        when the shop is closed.

        +String getName()
        +String getOwner()
        +boolean isOpen()
        +void open()
        +void close()
        +List<Product> getProducts() throws ShopIsClosedException
        +Product findByName(String name) throws NoSuchProductException, ShopIsClosedException
        +float getPrice(long barcode) throws NoSuchProductException, ShopIsClosedException
        +boolean hasProduct(long barcode) throws ShopIsClosedException
        +void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException
        +void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException
        +Product buyProduct(long barcode) throws NoSuchProductException, OutOfStockException, ShopIsClosedException
        +List<Product> buyProducts(long barcode, int quantity) throws NoSuchProductException, OutOfStockException, ShopIsClosedException
        +String toString()
     */

    public String getName();

    public String getOwner();

    public boolean isOpen();

    public void open();

    public void close();

    public List<Product> getProducts() throws ShopIsClosedException;

    public Product findByName(String name) throws NoSuchProductException, ShopIsClosedException;

    public float getPrice(long barcode) throws NoSuchProductException, ShopIsClosedException;

    public boolean hasProduct(long barcode) throws ShopIsClosedException;

    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException;

    public void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException;

    public Product buyProduct(long barcode) throws NoSuchProductException, OutOfStockException, ShopIsClosedException;

    public List<Product> buyProducts(long barcode, int quantity) throws NoSuchProductException, OutOfStockException, ShopIsClosedException;

    public String toString();
}
