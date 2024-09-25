package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the LatteMacchiato class one of beverage type.
 */
public class LatteMacchiato implements Beverage{
    private List<String> cookingLog;
    public LatteMacchiato() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }
    @Override
    public String getName() {
        return "Latte Macchiato";
    }

    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Latte Macchiato capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
