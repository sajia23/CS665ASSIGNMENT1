package edu.bu.met.cs665;

import java.util.List;

/**
 * This Receipt class.
 */
public class Receipt {
    private String customerName;
    private PaymentMethod paymentMethod;
    private int amount;
    private List<Item> itemList;

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

    public Receipt(String customerName, PaymentMethod paymentMethod, Integer amount, List<Item> itemList) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.itemList = itemList;
    }

}
