/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Customer.java
 * Description: This class represents a customer who can place orders and receive beverages.
 * It implements the Observer pattern through the SubscriberBase interface.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;


public class Customer implements SubscriberBase {

    private String name;
    private List<Beverage> receivedBeverageList;

    private List<Receipt> receiptList;
    private List<Item> shoppingCart;

    private PaymentMethod paymentMethod;

    public Customer() {
        name = RandomStringUtils.random(10, true, true);
        shoppingCart = new ArrayList<>();
        paymentMethod = PaymentMethod.randomPaymentMethod();
        receiptList = new ArrayList<>();
        receivedBeverageList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Adds items to the customer's shopping cart if they meet the menu and condiment restrictions
     * @param items List of items to be added to the shopping cart
     */
    public void addToShoppingCart(List<Item> items) {
        for(int i = 0; i < items.size(); i++) {
            if (!MenuAndInventory.getMenuMapping().containsKey(items.get(i).getBeverageType())) {continue;}
            if (!MenuAndInventory.getMenuMapping().containsKey(items.get(i).getCondimentType())) {continue;}
            if (items.get(i).getCondimentNum() > 3) {continue;}
            shoppingCart.add(items.get(i));
        }
    }

    /**
     * Updates the customer's received beverages and receipts when notified by the publisher
     * @param receipt the receipt for the completed order
     * @param beverageList list of prepared beverages
     */
    @Override
    public void updateSelf(Receipt receipt, List<Beverage> beverageList) {
        this.receivedBeverageList.addAll(beverageList);
        this.receiptList.add(receipt);
    }

    public List<Beverage> getReceivedBeverageList() {
        return receivedBeverageList;
    }

    public List<Receipt> getReceipts() {
        return receiptList;
    }
}
