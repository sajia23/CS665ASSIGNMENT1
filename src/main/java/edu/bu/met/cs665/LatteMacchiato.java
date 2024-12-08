/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: LatteMacchiato.java
 * Description: This class represents a Latte Macchiato beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class LatteMacchiato implements Beverage{
    private List<String> cookingLog;
    /**
     * Constructs a new Latte Macchiato and initializes its cooking instructions
     */
    public LatteMacchiato() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }
    /**
     * Gets the name of the beverage
     * @return the string "Latte Macchiato"
     */
    @Override
    public String getName() {
        return "Latte Macchiato";
    }

    /**
     * Implements the cooking instructions specific to Latte Macchiato
     */
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Latte Macchiato capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
