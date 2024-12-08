/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: SubscriberBase.java
 * Description: This interface defines the contract for Subscribers in the Observer pattern.
 */
package edu.bu.met.cs665;

import java.util.List;

public interface SubscriberBase {
    /**
     * Updates the subscriber with new receipt and beverage information
     * @param receipt the receipt for the completed order
     * @param list the list of prepared beverages
     */
    void updateSelf(Receipt receipt, List<Beverage> list);
}
