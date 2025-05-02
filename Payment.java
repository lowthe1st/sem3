package se.kth.iv1350.possystem.model;

/**
 * Represents the result of a customer's payment,
 * including the change to be returned and a status message.
 */
public class Payment {
    private final double change;
    private final String message;

    /**
     * Creates a new Payment instance.
     *
     * @param change The amount of change to return to the customer.
     * @param message A status message related to the payment (e.g. "Approved", "Too little money").
     */
    public Payment(double change, String message) {
        this.change = change;
        this.message = message;
    }

    /**
     * Returns the amount of change to give back to the customer.
     *
     * @return The change amount.
     */
    public double getChange() {
        return this.change;
    }

    /**
     * Returns the payment status message.
     *
     * @return A message describing the payment result.
     */
    public String getMessage() {
        return this.message;
    }
}


