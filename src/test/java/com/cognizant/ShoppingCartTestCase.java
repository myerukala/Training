package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTestCase
{

    @Test
    void testInitialCartEmpty()
    {
        //Setup
        ShoppingCart shopping = new ShoppingCart();

        //Execution

        int expected = 0;
        int actual = shopping.getValue();

        //Assert
        assertEquals(expected,actual);
    }
}
