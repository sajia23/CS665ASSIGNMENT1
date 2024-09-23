package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Machine implements PublisherBase{

    //private List<Order> orderList;
    //private List<Order> finishedOrderList;
    //private HashMap<String, Integer> inventories;
    //private List<MenuIitem> menu;
    //private Menu
    private HashMap<String, SubscriberBase> customerList = new HashMap<>();
    private HashMap<String, Receipt> receiptList = new HashMap<>();
    private HashMap<String, List<Beverage>> cookedBeverageList = new HashMap<>();
    public Machine() {
        //orderList = new ArrayList<>();
        //inventories = new HashMap<String, Integer>();
        //condiments = new
    }
    public void placeTheOrder(Customer customer) throws InstantiationException, IllegalAccessException {
        this.subscribe(customer);
        if(customer == null) return;
        int amount = 0;
        //List<Beverage> beverages = new ArrayList<>();
        for(Item item : customer.getShoppingCart()) {
            amount += MenuAndInventory.getPrice(item.getBeverageType());
        }
        Receipt receipt = new Receipt(customer.getName(), customer.getPaymentMethod(), amount, customer.getShoppingCart());
        receiptList.put(customer.getName(), receipt);
        //orderList.add(new Order(customer.getName(), customer.getShoppingCart()));
        Order order = new Order(customer.getName(), customer.getShoppingCart());
        implementTheOrder(order, receipt);
        //return receipt;
    }

    private void implementTheOrder(Order order, Receipt receipt) throws InstantiationException, IllegalAccessException {
        List<Beverage> beverageList = new ArrayList<>();
        for(Item item : order.getItemList()) {
            for(int i = 0; i < item.getBeverageNum(); i ++) {
                Class clz = MenuAndInventory.getClassMapping().get(item.getBeverageType());
                beverageList.add((Beverage) clz.newInstance());
            }
        }
        cookedBeverageList.put(order.getName(), beverageList);
        notifySubscribers(order.getName());
        this.unsubscribe(order.getName());
    }
    public HashMap<String, Integer> getMenu() {
        return MenuAndInventory.getMenuMapping();
    }

//    public HashMap<String, Integer> AddInventory(String name, Integer amount) {
//        inventories.put(name, inventories.getOrDefault(name, 0) + amount);
//        return inventories;
//    }

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
