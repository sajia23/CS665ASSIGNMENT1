/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Receipt.java
 * Description: This class represents a transaction receipt containing order details and payment information.
 */
package edu.bu.met.cs665;

import java.util.List;


public class Receipt {
    private String customerName;
    private PaymentMethod paymentMethod;
    private int amount;
    private List<Item> itemList;

    /**
     * Constructs a new Receipt with order details
     * @param customerName the name of the customer
     * @param paymentMethod the payment method used
     * @param amount the total amount paid
     * @param itemList the list of items purchased
     */
    public Receipt(String customerName, PaymentMethod paymentMethod, Integer amount, List<Item> itemList) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.itemList = itemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public int getAmount() {
        return amount;
    }

    public List<Item> getBeverageList() {
        return itemList;
    }

}
