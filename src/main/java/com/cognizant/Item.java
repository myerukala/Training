package com.cognizant;

public class Item {
    private String itemName;
    private double price;
    private int quantity;
    private boolean onSale;

    public Item(String itemName, double price, int quantity, boolean onSale) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.onSale = onSale;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public boolean equals(Object o) {
        return this.itemName.equals(((Item) o).itemName);
    }

}
