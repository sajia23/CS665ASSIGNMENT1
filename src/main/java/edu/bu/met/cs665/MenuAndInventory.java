/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: MenuAndInventory.java
 * Description: This enum manages the menu items, prices, and beverage classes for the vending machine system.
 * It provides utility methods for accessing menu information and generating random selections.
 */
package edu.bu.met.cs665;

import java.util.HashMap;
import org.apache.commons.lang3.RandomUtils;

public enum MenuAndInventory {

    ESPRESSO("Espresso", 3, Espresso.class),
    AMERICANO("Americano", 3, Americano.class),
    LATTE_MACCHIATO("Latte Macchiato", 3, LatteMacchiato.class),
    BLACK_TEA("Black Tea", 3, BlackTea.class),
    GREEN_TEA("Green Tea", 3, GreenTea.class),
    YELLOW_TEA("Yellow Tea", 3, YellowTea.class),
    MILK("Milk", 0, null),
    SUGAR("Sugar", 0, null);

    private final String key;
    private final Integer price;
    //private final Class bclass;
    private final Class beverageClass;
    private static HashMap<String, Integer> menuMapping;
    private static HashMap<String, Class> classMapping;

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return price;
    }
    public Class getBeverageClass() {
        return beverageClass;
    }
    /**
     * Gets the price for a specific menu item
     * @param name the name of the menu item
     * @return the price of the item
     */
    public static Integer getPrice(String name) {
        if(menuMapping == null){
            initMenuMapping();
        }
        return menuMapping.get(name);
    }
    /**
     * Randomly selects a beverage item from the menu
     * @return a random beverage MenuAndInventory item
     */
    public static MenuAndInventory randomBeverageItem() {
        int pick = RandomUtils.nextInt(0, 6);
        return MenuAndInventory.values()[pick];
    }
    public static MenuAndInventory randomCondimentItem() {
        int pick = RandomUtils.nextInt(6, MenuAndInventory.values().length);
        return MenuAndInventory.values()[pick];
    }
    private static void initMenuMapping() {
        menuMapping = new HashMap<String, Integer>();
        for(MenuAndInventory item : values()){
            menuMapping.put(item.getKey(), item.getValue());
        }
    }
    private static void initClassMapping() {
        classMapping = new HashMap<String, Class>();
        for(MenuAndInventory item : values()){
            classMapping.put(item.getKey(), item.getBeverageClass());
        }
    }
    public static HashMap<String, Integer> getMenuMapping() {
        if(menuMapping == null){
            initMenuMapping();
        }
        return menuMapping;
    }
    public static HashMap<String, Class> getClassMapping() {
        if(classMapping == null){
            initClassMapping();
        }
        return classMapping;
    }
    MenuAndInventory(String key, Integer price, Class beverageClass) {
        this.key = key;
        this.price = price;
        this.beverageClass = beverageClass;
    }
}
