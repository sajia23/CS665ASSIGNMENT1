package edu.bu.met.cs665;

import java.util.List;

public interface SubscriberBase {

    void updateSelf(Receipt receipt, List<Beverage> list);

}
