package edu.bu.met.cs665;

import java.util.Random;

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
