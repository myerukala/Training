package com.cognizant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    List<Item> itemsList = new ArrayList<>();

    public int isCartEmpty() {
        return itemsList.size();
    }
    
    public void addItems(Item... items) {
        itemsList.addAll(Arrays.asList(items));
    }

    public int itemCount() {
        return itemsList.size();
    }

    public double getSubTotal() {
         double sum = 0.0;
            for (Item i : itemsList) {
                sum += i.getPrice() * i.getQuantity();
            }
            return sum;
        }

    public int quantity() {
        int iCount = 0;
        for (Item i : itemsList) {
            iCount = iCount + i.getQuantity();
        }
        return iCount;
    }


    public void removeItem(Item cartItem) {
        itemsList.remove(cartItem);
    }


    public String displayItemizedList() {
        String strListOfItems = "";
        for (Item i : itemsList) {
            strListOfItems += "[" + "Item :" + i.getName().toString() +","+ "Price :" + i.getPrice() +","+ "Quantity :" + i.getQuantity() + "]";
        }
        return strListOfItems;
    }

    public int removeItemQuantity(Item ItemsQ) {

        int itemCount = 0;
        for (Item i : itemsList) {
            itemCount = i.getQuantity() - (ItemsQ.getQuantity());
        }
        return itemCount;
    }

    public String displayHighlightedSaleItems() {

        String strOnSaleItems = "";
        for (Item i : itemsList) {
            if (i.isOnSale()) {
                strOnSaleItems += "[" + "Item :" + i.getName() + "]";
            }
        }
        return strOnSaleItems;

    }
}