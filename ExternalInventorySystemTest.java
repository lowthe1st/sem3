package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.Sale;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ExternalInventorySystem using "Banan eko 2.15kg" and "Felix Potatisbullar".
 */
public class ExternalInventorySystemTest {
    private ExternalInventorySystem inventory;

    @BeforeEach
    public void setUp() {
        inventory = new ExternalInventorySystem();
        inventory.initializeStoreItems(); // Make sure bananas and potatisbullar are added
    }

    @Test
    public void testSearchBananEko() {
        Item result = inventory.search(101); // Banan
        assertNotNull(result, "Banan eko 2.15kg should exist in inventory.");
        assertEquals("Banan eko 2.15kg", result.getItemDTO().getItemName(), "Item name did not match.");
    }

    @Test
    public void testSearchFelixPotatisbullar() {
        Item result = inventory.search(203); // Potatisbullar
        assertNotNull(result, "Felix Potatisbullar should exist in inventory.");
        assertEquals("Felix Potatisbullar", result.getItemDTO().getItemName(), "Item name did not match.");
    }

    @Test
    public void testUpdateBananStockAfterSale() {
        Sale sale = new Sale();
        sale.addItem(inventory.search(101), 2); // Banan eko 2.15kg, 2 st
        inventory.updateItemQuantity(101, 2);

        Item updated = inventory.search(101);
        assertEquals(98, updated.getStoreQuantity(), "Banana stock was not reduced correctly.");
    }

    @Test
    public void testUpdatePotatisbullarStockAfterSale() {
        Sale sale = new Sale();
        sale.addItem(inventory.search(203), 1); // Felix Potatisbullar
        inventory.updateItemQuantity(203, 1);

        Item updated = inventory.search(203);
        assertEquals(99, updated.getStoreQuantity(), "Potatisbullar stock was not reduced correctly.");
    }

    @Test
    public void testSearchInvalidItem() {
        Item result = inventory.search(999);
        assertNull(result, "Searching for non-existent item should return null.");
    }
}
