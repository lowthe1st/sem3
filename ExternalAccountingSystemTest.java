package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ExternalAccountingSystem class.
 */
public class ExternalAccountingSystemTest {
    private ExternalAccountingSystem accountingSystem;

    /**
     * Sets up a fresh accounting system for each test.
     */
    @BeforeEach
    public void setUp() {
        accountingSystem = new ExternalAccountingSystem();
    }

    /**
     * Tests that the store balance increases correctly after a banana sale.
     */
    @Test
    public void testUpdateWithBananEko() {
        double totalPrice = 49.24; // Banan eko 2.15kg
        double initialBalance = accountingSystem.getStoreBalance();
        accountingSystem.update(totalPrice);
        assertEquals(initialBalance + totalPrice, accountingSystem.getStoreBalance(),
                "Store balance should be updated correctly after banana sale.");
    }

    /**
     * Tests that no change happens if no amount is paid.
     */
    @Test
    public void testUpdateWithZero() {
        double initialBalance = accountingSystem.getStoreBalance();
        accountingSystem.update(0.0);
        assertEquals(initialBalance, accountingSystem.getStoreBalance(),
                "Store balance should remain the same when updated with 0.");
    }
}
