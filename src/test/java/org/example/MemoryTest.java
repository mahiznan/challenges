package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MemoryTest {

    @Test
    public void testSimpleMemory() {
        final Customer customer;
        customer = new Customer("Rajesh");
        assertEquals("Rajesh", customer.getName());
        customer.setName("Ranju");
        assertEquals("Ranju", customer.getName());
    }
}
