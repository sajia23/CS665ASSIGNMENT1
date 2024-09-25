package edu.bu.met.cs665;

import java.util.Random;
/**
 * This is the PaymentMethod enum class.
 * It provides method to show different payment method.
 */
public enum PaymentMethod {
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS,

    ZELLE,
    PAPYPAL;
    public static PaymentMethod randomPaymentMethod() {
        int pick = new Random().nextInt(PaymentMethod.values().length);
        return PaymentMethod.values()[pick];
    }
}
