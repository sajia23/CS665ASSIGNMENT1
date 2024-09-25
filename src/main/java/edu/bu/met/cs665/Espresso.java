package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is the Espresso class one of beverage type.
 */
public class Espresso implements Beverage{

    private List<String> cookingLog;
    public Espresso() {
        cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Espresso capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
