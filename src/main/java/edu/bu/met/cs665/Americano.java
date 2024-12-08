/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Americano.java
 * Description: This class represents an Americano beverage type and implements the beverage preparation process.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class Americano implements Beverage {

    private List<String> cookingLog;

    /**
     * Constructs a new Americano and initializes its cooking instructions
     */
    public Americano() {
        this.cookingLog = new ArrayList<String>();
        this.cookBeverageInstructions();
    }

    /**
     * Gets the name of the beverage
     * @return the string "Americano"
     */
    @Override
    public String getName() {
        return "Americano";
    }

    /**
     * Implements the cooking instructions specific to Americano
     */
    @Override
    public void cookBeverageInstructions() {
        cookingLog.add("Heat the water ...");
        cookingLog.add("Put in the Americano capsule ...");
        cookingLog.add("Heat the water for 1 minute ...");
        cookingLog.add("Add condiment to the beverage ...");
        cookingLog.add("Finished!");
    }

    @Override
    public double cost() {
        return 3.0;
    }
}
