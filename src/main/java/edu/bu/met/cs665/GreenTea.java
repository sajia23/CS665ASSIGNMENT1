/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: GreenTea.java
 * Description: This class represents a Green Tea beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class GreenTea implements Beverage {
    private List<String> cookingLog;
    /**
     * Constructs a new Green Tea and initializes its cooking instructions
     */
    public GreenTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }
    /**
     * Gets the name of the beverage
     * @return the string "Green Tea"
     */
    @Override
    public String getName() {
        return "Green Tea";
    }
    /**
     * Implements the cooking instructions specific to Green Tea
     */
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Green Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
