/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: YellowTea.java
 * Description: This class represents a Yellow Tea beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class YellowTea implements Beverage{
    private List<String> cookingLog;
    /**
     * Constructs a new Yellow Tea and initializes its cooking instructions
     */
    public YellowTea() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }

    /**
     * Gets the name of the beverage
     * @return the string "Yellow Tea"
     */
    @Override
    public String getName() {
        return "Yellow Tea";
    }

    /**
     * Implements the cooking instructions specific to Yellow Tea
     */
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Yellow Tea capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }
}
