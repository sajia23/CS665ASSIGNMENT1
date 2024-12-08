/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Machine.java
 * Description: This class represents a beverage vending machine that implements the Publisher interface
 * for the Observer pattern. It handles order processing and beverage preparation.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Machine implements PublisherBase{

    private HashMap<String, SubscriberBase> customerList;
    private HashMap<String, Receipt> receiptList;
    private HashMap<String, List<Beverage>> cookedBeverageList;
    public Machine() {
        customerList = new HashMap<>();
        receiptList = new HashMap<>();
        cookedBeverageList = new HashMap<>();
    }

    /**
     * Processes a customer's order and creates the corresponding receipt and beverages
     * @param customer the customer placing the order
     * @throws InstantiationException if there's an error creating beverage instances
     * @throws IllegalAccessException if there's an error accessing beverage classes
     */
    public void placeTheOrder(Customer customer) throws InstantiationException, IllegalAccessException {
        this.subscribe(customer);
        if(customer == null) {return;}
        int amount = 0;

        for(Item item : customer.getShoppingCart()) {
            amount += MenuAndInventory.getPrice(item.getBeverageType());
        }
        Receipt receipt = new Receipt(customer.getName(), customer.getPaymentMethod(), amount, customer.getShoppingCart());
        receiptList.put(customer.getName(), receipt);

        Order order = new Order(customer.getName(), customer.getShoppingCart());
        implementTheOrder(order, receipt);
    }

    /**
     * Implements the order by creating the requested beverages
     * @param order the order to be implemented
     * @param receipt the receipt for the order
     * @throws InstantiationException if there's an error creating beverage instances
     * @throws IllegalAccessException if there's an error accessing beverage classes
     */
    // private void implementTheOrder(Order order, Receipt receipt) throws InstantiationException, IllegalAccessException {
    //     List<Beverage> beverageList = new ArrayList<>();
    //     for(Item item : order.getItemList()) {
    //         for(int i = 0; i < item.getBeverageNum(); i++) {
    //             Class clz = MenuAndInventory.getClassMapping().get(item.getBeverageType());
    //             beverageList.add((Beverage) clz.newInstance());
    //         }
    //     }
    //     cookedBeverageList.put(order.getName(), beverageList);
    //     notifySubscribers(order.getName());
    //     this.unsubscribe(order.getName());
    // }
    private void implementTheOrder(Order order, Receipt receipt) throws InstantiationException, IllegalAccessException {
        List<Beverage> beverageList = new ArrayList<>();
        for(Item item : order.getItemList()) {
            for(int i = 0; i < item.getBeverageNum(); i++) {
                // 创建基础饮料
                Class clz = MenuAndInventory.getClassMapping().get(item.getBeverageType());
                Beverage beverage = (Beverage) clz.newInstance();
                
                // 添加调味品
                if (item.getCondimentType().equals("Milk")) {
                    beverage = new MilkDecorator(beverage, item.getCondimentNum());
                } else if (item.getCondimentType().equals("Sugar")) {
                    beverage = new SugarDecorator(beverage, item.getCondimentNum());
                }
                
                beverageList.add(beverage);
            }
        }
        cookedBeverageList.put(order.getName(), beverageList);
        notifySubscribers(order.getName());
        this.unsubscribe(order.getName());
    }

    public HashMap<String, Integer> getMenu() {
        return MenuAndInventory.getMenuMapping();
    }

    @Override
    public void subscribe(SubscriberBase o) {
        Customer c = (Customer) o;
        customerList.put(c.getName(), c);
    }

    @Override
    public void unsubscribe(String name) {
        customerList.remove(name);
    }

    @Override
    public void notifySubscribers(String name) {
        Customer c = (Customer)customerList.get(name);
        c.updateSelf(receiptList.get(name), cookedBeverageList.get(name));
    }
}
