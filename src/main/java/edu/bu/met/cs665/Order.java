/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Order.java
 * Description: This class represents a customer order containing customer information and ordered items.
 */
package edu.bu.met.cs665;

import java.util.List;

public class Order {
    private String name;
    private List<Item> itemList;

    /**
     * Constructs a new Order with customer name and items
     * @param name the customer's name
     * @param itemList the list of items ordered
     */
    public Order(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    /**
     * Gets the customer's name
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
