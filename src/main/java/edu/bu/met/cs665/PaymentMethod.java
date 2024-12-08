/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/19/2024
 * File Name: PaymentMethod.java
 * Description: This enum defines available payment methods and provides utility methods for payment selection.
 */
package edu.bu.met.cs665;

import java.util.Random;

public enum PaymentMethod {
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS,

    ZELLE,
    PAPYPAL;
    /**
     * Randomly selects a payment method
     * @return a randomly selected PaymentMethod
     */
    public static PaymentMethod randomPaymentMethod() {
        int pick = new Random().nextInt(PaymentMethod.values().length);
        return PaymentMethod.values()[pick];
    }
}
