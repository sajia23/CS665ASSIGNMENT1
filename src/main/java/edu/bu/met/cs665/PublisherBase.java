/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: PublisherBase.java
 * Description: This interface defines the contract for the Publisher in the Observer pattern.
 */
package edu.bu.met.cs665;


public interface PublisherBase {
    /**
     * Subscribes an observer to receive notifications
     * @param o the subscriber to add
     */
    void subscribe(SubscriberBase o);

    /**
     * Unsubscribes an observer by name
     * @param name the name of the subscriber to remove
     */
    void unsubscribe(String name);

    /**
     * Notifies subscribers of updates
     * @param name the name of the subscriber to notify
     */
    void notifySubscribers(String name);
}
