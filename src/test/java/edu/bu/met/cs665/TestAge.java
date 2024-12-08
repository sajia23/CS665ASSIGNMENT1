package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: TestAge.java
 * Description: This class contains unit tests for the beverage vending machine system.
 */

public class TestAge {

    public TestAge() {
    }

    /**
     * Generates a list of legal order items for testing
     * @param num the number of different items to generate
     * @return List of randomly generated legal order items
     */
    public List<Item> generateLegalMultiOrderItems(Integer num) {
        HashMap<String, Item> cartItemList = new HashMap<>();
        //List<Item> cartItemList = new ArrayList<>();
        while(cartItemList.size() < num) {
            MenuAndInventory beverageItem = MenuAndInventory.randomBeverageItem();
            MenuAndInventory condimentItem = MenuAndInventory.randomCondimentItem();
            Item item = new Item();
            item.setBeverageType(beverageItem.getKey());
            item.setBeverageNum(RandomUtils.nextInt(1, 100));
            item.setCondimentType(condimentItem.getKey());
            item.setCondimentNum(RandomUtils.nextInt(0,4));
            if(cartItemList.containsKey(beverageItem.getKey())) {
                cartItemList.get(beverageItem.getKey()).setBeverageNum(cartItemList.get(beverageItem.getKey()).getBeverageNum() + item.getBeverageNum());
            }
            cartItemList.put(item.getBeverageType(), item);
        }
        return new ArrayList<>(cartItemList.values());
    }

    /**
     * Tests ordering a single drink
     */
    @Test
    public void BuyOneDrink() throws InstantiationException, IllegalAccessException {
        HashMap<String, Integer> beverageNameToNum = new HashMap<String, Integer>();

        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(1);
        customer.addToShoppingCart(items);
        Machine machine = new Machine();
        machine.placeTheOrder(customer);

        List<Beverage> receivedBeverages = customer.getReceivedBeverageList();
        List<Receipt> receiptList = customer.getReceipts();
        for(int i = 0; i < receivedBeverages.size(); i ++) {
            beverageNameToNum.put(receivedBeverages.get(i).getName(), beverageNameToNum.getOrDefault(receivedBeverages.get(i).getName(), 0) + 1);
        }

        assertEquals(receiptList.size(), 1);
        assertEquals(receiptList.get(0).getCustomerName(), customer.getName());
        int amount = 0;
        for(int i = 0; i < items.size(); i ++) {
            amount += MenuAndInventory.getPrice(items.get(i).getBeverageType());
        }
        assertEquals(receiptList.get(0).getAmount(), amount);
        assertEquals(receiptList.get(0).getPaymentMethod(), customer.getPaymentMethod());

        //check if the beverage num of each type matches order
        for(int i = 0; i < items.size(); i ++) {
            assertEquals(beverageNameToNum.containsKey(items.get(i).getBeverageType()), true);
            assertEquals(beverageNameToNum.get(items.get(i).getBeverageType()), items.get(i).getBeverageNum());
        }
    }

    /**
     * Tests ordering multiple drinks
     */
    @Test
    public void BuyMultiDrink() throws InstantiationException, IllegalAccessException {
        HashMap<String, Integer> beverageNameToNum = new HashMap<String, Integer>();

        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(3);
        customer.addToShoppingCart(items);
        Machine machine = new Machine();
        machine.placeTheOrder(customer);

        List<Beverage> receivedBeverages = customer.getReceivedBeverageList();
        List<Receipt> receiptList = customer.getReceipts();
        for(int i = 0; i < receivedBeverages.size(); i ++) {
            beverageNameToNum.put(receivedBeverages.get(i).getName(), beverageNameToNum.getOrDefault(receivedBeverages.get(i).getName(), 0) + 1);
        }

        assertEquals(receiptList.size(), 1);
        assertEquals(receiptList.get(0).getCustomerName(), customer.getName());
        int amount = 0;
        for(int i = 0; i < items.size(); i ++) {
            amount += MenuAndInventory.getPrice(items.get(i).getBeverageType());
        }
        assertEquals(receiptList.get(0).getAmount(), amount);
        assertEquals(receiptList.get(0).getPaymentMethod(), customer.getPaymentMethod());


        //check if the beverage num of each type matches order
        for(int i = 0; i < items.size(); i ++) {
            assertEquals(beverageNameToNum.containsKey(items.get(i).getBeverageType()), true);
            assertEquals(beverageNameToNum.get(items.get(i).getBeverageType()), items.get(i).getBeverageNum());
        }
    }

    /**
     * Tests validation of condiment quantity restrictions
     */
    @Test
    public void BuyOneDrinkWithWrongNumOfCondiments() {
        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(1);
        items.get(0).setCondimentNum(4);
        customer.addToShoppingCart(items);
        assertEquals(customer.getShoppingCart().size(), 0);

    }

    /**
     * Tests validation of beverage type restrictions
     */
    @Test
    public void BuyOneDrinkWithWrongBeverageType() {
        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(1);
        items.get(0).setBeverageType("CocaCola");
        customer.addToShoppingCart(items);
        assertEquals(customer.getShoppingCart().size(), 0);
    }

    //Could not add item to shopping cart which is wrong type of beverage.
    @Test
    public void BuyMultiDrinkWithOneWrongBeverageType() {
        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(2);
        items.get(0).setBeverageType("CocaCola");
        customer.addToShoppingCart(items);
        assertEquals(customer.getShoppingCart().size(), 1);
    }

    //Could not add item to shopping cart with wrong type of condiments.
    @Test
    public void BuyOneDrinkWithWrongCondimentType() {
        Customer customer = new Customer();
        List<Item> items = generateLegalMultiOrderItems(1);
        items.get(0).setCondimentType("CocaCola");
        customer.addToShoppingCart(items);
        assertEquals(customer.getShoppingCart().size(), 0);
    }














}
