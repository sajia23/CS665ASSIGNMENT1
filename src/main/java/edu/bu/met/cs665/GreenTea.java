package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the GreenTea class one of beverage type.
 */
public class GreenTea implements Beverage {
    private List<String> cookingLog;
    public GreenTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }
    @Override
    public String getName() {
        return "Green Tea";
    }

    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Green Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
