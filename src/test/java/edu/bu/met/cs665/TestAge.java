package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestAge {

    public TestAge() {
    }

    public List<Item> generateLegalMultiOrderItems(Integer numOfEachBeverage) {
        List<Item> cartItemList = new ArrayList<>();
        for(int i = 0; i < numOfEachBeverage; i ++) {
            MenuAndInventory beverageItem = MenuAndInventory.randomBeverageItem();
            MenuAndInventory condimentItem = MenuAndInventory.randomCondimentItem();
            Item item = new Item();
            item.setBeverageType(beverageItem.getKey());
            item.setBeverageNum(RandomUtils.nextInt(1, 100));
            item.setCondimentType(condimentItem.getKey());
            item.setCondimentNum(RandomUtils.nextInt(0,4));
            cartItemList.add(item);
        }
        return cartItemList;
    }

    @Test
    public void BuyADrink() throws InstantiationException, IllegalAccessException {
        HashMap<String, Integer> beverageNameToNum = new HashMap<String, Integer>();

        Customer customer = new Customer();
        List<Item> order = generateLegalMultiOrderItems(1);
        customer.addToShoppingCart(order);
        Machine machine = new Machine();
        machine.placeTheOrder(customer);

        List<Beverage> receivedBeverages = customer.getReceivedBeverageList();
        List<Receipt> receiptList = customer.getReceipts();
        for(int i = 0; i < receivedBeverages.size(); i ++) {
            beverageNameToNum.put(receivedBeverages.get(i).getName(), beverageNameToNum.getOrDefault(receivedBeverages.get(i).getName(), 0) + 1);
        }

        assertEquals(receiptList.size(), 1);

        //check if the beverage num of each type matches order
        for(int i = 0; i < order.size(); i ++) {
            assertEquals(beverageNameToNum.containsKey(order.get(i).getBeverageType()), true);
            assertEquals(beverageNameToNum.get(order.get(i).getBeverageType()), order.get(i).getBeverageNum());
        }
    }














}
