/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: Beverage.java
 * Description: This interface defines the contract for all beverage types in the system.
 */
package edu.bu.met.cs665;

import java.util.HashMap;

public interface Beverage {
    /**
     * Gets the name of the beverage
     * @return the name of the beverage as a String
     */
    public String getName();

    /**
     * Defines the cooking instructions for the beverage
     */
    public void cookBeverageInstructions();

    /**
     * Calculates the cost of the beverage
     * @return the cost of the beverage as a double
     */
    public double cost();
}
