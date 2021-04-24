package com.cognizant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShoppingCartTestCase {

    //Setup
    ShoppingCart shopping;

    @BeforeEach
    void setUp() {
        shopping = new ShoppingCart();
    }

    @Test
    void testInitialCartEmpty() {
        //Assert
        assertEquals(0, shopping.isCartEmpty());
    }

    @Test
    void testCartAddItemsSubTotal() {
        shopping.addItems(new Item("Cloths", 10.00, 2,false));
        assertEquals(20.00, shopping.getSubTotal());
        shopping.addItems(new Item("Stationary", 5.00, 3,false));
        assertEquals(35.00, shopping.getSubTotal());
    }


    @Test
    void testCartQuantity() {
        shopping.addItems(new Item("Cloths", 10.00, 2,false));
        assertEquals(2, shopping.quantity());
        shopping.addItems(new Item("Fruits", 2.00, 5,false));
        shopping.addItems(new Item("Snacks", 1.00, 3,false));
        assertEquals(10, shopping.quantity());
    }


    @Test
    void testItemizedList() {

        String actualListItems = "[Item :Cloths,Price :2.0,Quantity :3][Item :Fruits,Price :5.0,Quantity :2][Item :Snacks,Price :1.0,Quantity :5]";
        shopping.addItems(new Item("Cloths", 2.00, 3,false));
        shopping.addItems(new Item("Fruits", 5.00, 2,false));
        shopping.addItems(new Item("Snacks", 1.00, 5,false));
        assertEquals(actualListItems, shopping.displayItemizedList());
    }

    @Test
    void testRemoveCartItem() {

        shopping.addItems(new Item("Cookies", 2.00, 5,false));
        shopping.addItems(new Item("Mango", 1.00, 10,false));
        shopping.removeItem(new Item("Mango", 1.00, 10,false));
        shopping.addItems(new Item("Apple", 1.00, 2,false));
        assertEquals(2, shopping.itemCount());

        String actualListItems = "[Item :Cookies,Price :2.0,Quantity :5][Item :Apple,Price :1.0,Quantity :2]";
        assertEquals(actualListItems, shopping.displayItemizedList());
    }


    @Test
    void testAdjustItemQuantity() {

        shopping.addItems(new Item("Cookies", 2.00, 5,false));
        int actual = shopping.removeItemQuantity(new Item("Cookies", 2.00, 1,false));
        assertEquals(4, actual);
    }

    @Test
    void testHighlightedSaleItems() {

        String actualListItems = "[Item :Mango][Item :Oranges]";
        shopping.addItems(new Item("Mango", 5.00, 5,true));
        shopping.addItems(new Item("Cookies", 3.00, 5,false));
        shopping.addItems(new Item("Oranges", 2.00, 5,true));

        assertEquals(actualListItems, shopping.displayHighlightedSaleItems());
    }

}
