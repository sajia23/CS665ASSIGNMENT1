package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class Customer implements SubscriberBase {

    private String name;
    private List<Beverage> receivedBeverageList;

    private List<Receipt> receiptList;
    private List<Item> shoppingCart;

    private PaymentMethod paymentMethod;

    public Customer(){
        name = RandomStringUtils.random(10, true, true);
        paymentMethod = PaymentMethod.randomPaymentMethod();
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
    public List<Item> addToShoppingCart(Item item) {
        if(!MenuAndInventory.getMenuMapping().containsKey(item.getBeverageType())) return null;
        if(!MenuAndInventory.getMenuMapping().containsKey(item.getCondimentType())) return null;
        if(item.getCondimentNum() > 3) return null;
        shoppingCart.add(item);
        return shoppingCart;
    }

    public List<Beverage> addARandomDrink() {
        return null;
    }

    @Override
    public void updateSelf(Receipt receipt, List<Beverage> beverageList) {
        this.receivedBeverageList.addAll(beverageList);
        this.receiptList.add(receipt);

    }
}
