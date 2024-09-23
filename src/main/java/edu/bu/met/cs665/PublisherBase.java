package edu.bu.met.cs665;

public interface PublisherBase {
    void subscribe(SubscriberBase o);

    void unsubscribe(String name);

    void notifySubscribers(String name);
}
