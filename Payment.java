package se.kth.iv1350.possystem.model;

/**
 * Holds info about a payment, like how much change to give and the payment status.
 */
public class Payment {
    private final double change;
    private final String message;

    /**
     * Creates a new payment result.
     *
     * @param change How much money to give back.
     * @param message A message like "Approved" or "Too little money".
     */
    public Payment(double change, String message) {
        this.change = change;
        this.message = message;
    }

    /**
     * Gets the change to return to the customer.
     */
    public double getChange() {
        return this.change;
    }

    /**
     * Gets the status message for the payment.
     */
    public String getMessage() {
        return this.message;
    }
}
