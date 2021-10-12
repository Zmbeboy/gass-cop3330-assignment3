/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Eric Gass
 */

package ex44;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void objectFound()
    {
        App test = new App();

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setName("TestObject1");
        product1.setPrice(15.00);
        product1.setQuantity(3);

        product2.setName("TestObject2");
        product2.setPrice(45.00);
        product2.setQuantity(7);

        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);

        Data data = new Data();
        data.setProducts(products);

        assertEquals(true,test.objectFound("TestObject1",data));
        assertEquals(false,test.objectFound("TestObject3",data));
    }
}