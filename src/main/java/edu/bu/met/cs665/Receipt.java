package edu.bu.met.cs665;

import java.util.List;

public class Receipt {
    private String customerName;
    private PaymentMethod paymentMethod;
    private Integer amount;
    private List<Item> beverageList;

    public Receipt(String customerName, PaymentMethod paymentMethod, Integer amount, List<Item> itemList) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.beverageList = beverageList;
    }

}
