package com.codecool.plaza.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop {
    /*
        The ShopImpl class is the actual implementation of a Shop interface. You need no multiple implementations
        of the interface, this one is enough. The class has a Map which stores barcodes matched against ShopEntryImpl
        objects (see below). The class must implement all methods defined by the Shop interface.

        -String name
        -String owner
        -Map<Long, ShopImpl.ShopEntryImpl> products
        +ShopImpl(String name, String owner)
     */

    private String name;
    private String owner;
    private boolean open = false;
    private Map<Long, ShopEntryImpl> products = new HashMap<>();

    public ShopImpl(String name, String owner) {
        this.name = name;
        this.owner = owner;
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

    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    public Product findByName(String str) throws NoSuchProductException, ShopIsClosedException {
        return new ClothingProduct(0, "asdas", "fasf", "sdfasdf", "asdfasd");
    }

    public float getPrice(long barcode) {
        return 0;
    }

    public boolean hasProduct(long barcode) {
        return false;
    }

    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException {
        long barcode = product.getBarcode();
        if (products.containsKey(barcode)) {
            throw new ProductAlreadyExistsException();
        }
        products.put(barcode, new ShopEntryImpl(product, quantity, price));

    }

    public void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException {
        products.get(barcode).increaseQuantity(quantity);

    }

    public Product buyProduct(long barcode) throws NoSuchProductException, OutOfStockException, ShopIsClosedException {
        if (!products.containsKey(barcode)) {
            throw new NoSuchProductException();
        }
        if (!open) {
            throw new ShopIsClosedException();
        }
        ShopEntryImpl shopEntryImpl = products.get(barcode);
        Product product = shopEntryImpl.getProduct();
        shopEntryImpl.decreaseQuantity(1);
        return product;
    }

    public List<Product> buyProducts(long barcode, int quantity) throws NoSuchProductException, OutOfStockException, ShopIsClosedException {
        List<Product> lst = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lst.add(buyProduct(barcode));
        }
        return lst;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stored Products:");
        for (ShopEntryImpl shopEntryImpl : this.products.values()) {
            Product product = shopEntryImpl.getProduct();
            builder.append("barcode :" + product.getBarcode()).append("\n");
            builder.append("name :" + product.getName()).append("\n");
            builder.append("quantity :" + shopEntryImpl.getQuantity()).append("\n\n");
        }

        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    private class ShopEntryImpl {
        /*
            A ShopImpl. ShopEntryImpl is an inner class of the ShopImpl class. The class itself is private (watch out).
            Meaning this class isn't exposed to the "public", only the ShopImpl class supposed to know about it.
            The ShopImpl stores several instances of this class in a map.

            Each ShopEntryImpl instance contains data related to a Product : how much of that product is in the shop,
            what is the price of the product in a particular shop (each shop set their own price). When a user buys a
            product the relevant ShopEntryImpl is updated (quantity decreased), when the user adds new products to a
            shop or resupplies a product the entry is updated accordingly (quantity increased).
            -Product product
            -int quantity
            -float price
            -ShopEntryImpl(Product product, int quantity, float price)
            +Product getProduct()
            +void setProduct(Product product)
            +int getQuantity()
            +void setQuantity(int quantity)
            +void increaseQuantity(int amount)
            +void decreaseQuantity(int amount)
            +float getPrice()
            +void setPrice(int price)
            +String toString()
         */
        private Product product;
        private int quantity;
        private float price;

        public ShopEntryImpl(Product product, int quantity, float price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public Product getProduct() {
            return product;
        }


        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void increaseQuantity(int amount) {
            quantity += amount;
        }

        public void decreaseQuantity(int amount) throws OutOfStockException {
            if (quantity <= 0) {
                throw new OutOfStockException();
            }
            quantity -= amount;

        }

        public float getPrice() {
            return this.price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return "";
        }
    }
}
