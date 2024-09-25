package edu.bu.met.cs665;

import java.util.List;
/**
 * This is the Order class.
 * It stores customer's name and items.
 */
public class Order {
    private String name;
    private List<Item> itemList;

    public Order(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

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
