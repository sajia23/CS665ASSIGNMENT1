package edu.bu.met.cs665;

public interface PublisherBase {
    void subscribe(SubscriberBase o);

    void unsubscribe(SubscriberBase o);

    void notifySubscribers(String name);
}
