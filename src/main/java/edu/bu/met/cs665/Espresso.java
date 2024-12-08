/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Espresso.java
 * Description: This class represents an Espresso beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Espresso implements Beverage {

    private List<String> cookingLog;

    /**
     * Constructs a new Espresso and initializes its cooking instructions
     */
    public Espresso() {
        cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }

    /**
     * Gets the name of the beverage
     * @return the string "Espresso"
     */
    @Override
    public String getName() {
        return "Espresso";
    }

    /**
     * Implements the cooking instructions specific to Espresso
     */
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Espresso capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
