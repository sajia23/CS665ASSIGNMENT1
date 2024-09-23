package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class BlackTea implements Beverage{
    private List<String> cookingLog;
    public BlackTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverage();
    }
    @Override
    public String getName() {
        return "Black Tea";
    }

    @Override
    public void cookBeverage() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Black Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
