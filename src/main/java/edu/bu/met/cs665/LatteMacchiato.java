package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class LatteMacchiato implements Beverage{
    private List<String> cookingLog;
    public LatteMacchiato() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverage();
    }
    @Override
    public String getName() {
        return "Latte Macchiato";
    }

    @Override
    public void cookBeverage() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Latte Macchiato capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
