package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class YellowTea implements Beverage{
    private List<String> cookingLog;
    public YellowTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverage();
    }
    @Override
    public String getName() {
        return "Yellow Tea";
    }

    @Override
    public void cookBeverage() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Yellow Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
