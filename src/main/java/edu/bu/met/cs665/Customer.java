package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Customer implements SubscriberBase {

    private String name;
    private List<Beverage> receivedBeverageList;

    private List<Receipt> receiptList;
    private List<Item> shoppingCart;

    private PaymentMethod paymentMethod;

    public Customer(){
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
    public List<Item> addToShoppingCart(List<Item> items) {
        for(int i = 0; i < items.size(); i ++) {
            if (!MenuAndInventory.getMenuMapping().containsKey(items.get(i).getBeverageType())) return null;
            if (!MenuAndInventory.getMenuMapping().containsKey(items.get(i).getCondimentType())) return null;
            if (items.get(i).getCondimentNum() > 3) return null;
            shoppingCart.add(items.get(i));
        }
        return shoppingCart;
    }

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
