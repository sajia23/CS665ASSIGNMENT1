package edu.bu.met.cs665;

import java.util.List;
/**
 * This is Subscriber interface for Observer Pattern.
 */
public interface SubscriberBase {

    void updateSelf(Receipt receipt, List<Beverage> list);

}
