package se.kth.iv1350.possystem.integration;

/**
 * Simulates an external accounting system that handles the store's financial transactions.
 */
public class ExternalAccountingSystem {
    private double storeBalance;

    /**
     * Creates a new instance of the external accounting system with a starting balance.
     */
    public ExternalAccountingSystem() {
        this.storeBalance = 200.0;
    }

    /**
     * Updates the store balance by adding the total amount from a completed sale.
     *
     * @param totalPrice The total price received from the sale.
     */
    public void update(double totalPrice) {
        this.storeBalance += totalPrice;
    }

    /**
     * Returns the store's current balance.
     *
     * @return The store's total balance after transactions.
     */
    public double getStoreBalance() {
        return this.storeBalance;
    }
}

