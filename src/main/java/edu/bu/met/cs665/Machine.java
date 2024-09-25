package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This is the Machine class implementing Publisher interface.
 * It will receive order from customers and make beverages to customers.
 * Also, it can notify customers to receive beverages.
 */
public class Machine implements PublisherBase{

    private HashMap<String, SubscriberBase> customerList;
    private HashMap<String, Receipt> receiptList;
    private HashMap<String, List<Beverage>> cookedBeverageList;
    public Machine() {
        customerList = new HashMap<>();
        receiptList = new HashMap<>();
        cookedBeverageList = new HashMap<>();
    }

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

    private void implementTheOrder(Order order, Receipt receipt) throws InstantiationException, IllegalAccessException {
        List<Beverage> beverageList = new ArrayList<>();
        for(Item item : order.getItemList()) {
            for(int i = 0; i < item.getBeverageNum(); i++) {
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
