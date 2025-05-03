package se.kth.iv1350.possystem.integration;

/**
 * Simulates the store’s external accounting system.
 * Keeps track of how much money the store has received.
 */
public class ExternalAccountingSystem {
    private double storeBalance;

    /**
     * Creates a new accounting system with a starting balance.
     */
    public ExternalAccountingSystem() {
        this.storeBalance = 200.0;
    }

    /**
     * Updates the store balance when a sale is completed.
     *
     * @param totalPrice The amount received from the customer.
     */
    public void update(double totalPrice) {
        this.storeBalance += totalPrice;
    }

    /**
     * Gets the current balance of the store.
     */
    public double getStoreBalance() {
        return this.storeBalance;
    }
}
