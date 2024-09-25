package edu.bu.met.cs665;

import java.util.List;

public class Receipt {
    private String customerName;
    private PaymentMethod paymentMethod;
    private int amount;
    private List<Item> beverageList;

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
        return beverageList;
    }

    public Receipt(String customerName, PaymentMethod paymentMethod, Integer amount, List<Item> itemList) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.beverageList = beverageList;
    }

}
