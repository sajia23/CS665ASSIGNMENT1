package edu.bu.met.cs665;

import java.util.HashMap;

public enum MenuAndInventory {

    ESPRESSO("Espresso", 3, Espresso.class),
    AMERICANO("Americano", 3, Americano.class),
    LATTE_MACCHIATO("Latte Macchiato", 3, LatteMacchiato.class),
    BLACK_TEA("Black Tea", 3, BlackTea.class),
    GREEN_TEA("Green Tea", 3, GreenTea.class),
    YELLOW_TEA("Yellow Tea", 3, YellowTea.class),
    MILK("Milk", 0, null),
    SUGAR("Sugar", 3, null);

    private final String key;
    private final Integer value;
    //private final Class bclass;

    private final Class beverageClass;

    private static HashMap<String, Integer> menuMapping;
    private static HashMap<String, Class> classMapping;

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }

    public Class getBeverageClass() {
        return beverageClass;
    }
    public static Integer getPrice(String name) {
        if(menuMapping == null){
            initMenuMapping();
        }
        return menuMapping.get(name);
    }
    public static Class getClass(String name) {
        if(classMapping == null){
            initClassMapping();
        }
        return classMapping.get(name);
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
    MenuAndInventory(String key, Integer value, Class beverageClass) {
        this.key = key;
        this.value = value;
        this.beverageClass = beverageClass;
    }
}
