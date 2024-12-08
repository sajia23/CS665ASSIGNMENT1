/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: BlackTea.java
 * Description: This class represents a Black Tea beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class BlackTea implements Beverage {
    private List<String> cookingLog;
    /**
     * Constructs a new Black Tea and initializes its cooking instructions
     */
    public BlackTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }
    /**
     * Gets the name of the beverage
     * @return the string "Black Tea"
     */
    @Override
    public String getName() {
        return "Black Tea";
    }
    /**
     * Implements the cooking instructions specific to Black Tea
     */ 
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Black Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
