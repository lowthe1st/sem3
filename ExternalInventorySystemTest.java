package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the ExternalInventorySystem using Banan eko 2.15kg and Felix Potatisbullar.
 */
public class ExternalInventorySystemTest {
    private ExternalInventorySystem inventory;

    @BeforeEach
    public void setUp() {
        inventory = new ExternalInventorySystem();
        inventory.initializeStoreItems(); // Adds sample items to the store
    }

    @Test
    public void testSearchBananEko() {
        Item result = inventory.search(1); // Banan barcode
        assertNotNull(result, "Banan eko 2.15kg should be found.");
        assertEquals("Banan eko 2.15kg", result.getItemDTO().getItemName(), "Name mismatch.");
    }

    @Test
    public void testSearchFelixPotatisbullar() {
        Item result = inventory.search(2); // Potatisbullar barcode
        assertNotNull(result, "Felix Potatisbullar should be found.");
        assertEquals("Felix Potatisbullar", result.getItemDTO().getItemName(), "Name mismatch.");
    }

    @Test
    public void testUpdateBananStockAfterSale() {
        Sale sale = new Sale();
        sale.addItem(inventory.search(1), 2); // 2 bananas sold
        inventory.updateItemQuantity(1, 2);

        Item updated = inventory.search(1);
        assertEquals(98, updated.getStoreQuantity(), "Banana stock not updated correctly.");
    }

    @Test
    public void testUpdatePotatisbullarStockAfterSale() {
        Sale sale = new Sale();
        sale.addItem(inventory.search(2), 1); // 1 potatisbullar sold
        inventory.updateItemQuantity(2, 1);

        Item updated = inventory.search(2);
        assertEquals(99, updated.getStoreQuantity(), "Potatisbullar stock not updated correctly.");
    }

    @Test
    public void testSearchInvalidItem() {
        Item result = inventory.search(999); // Unknown barcode
        assertNull(result, "Should return null for non-existent item.");
    }
}
