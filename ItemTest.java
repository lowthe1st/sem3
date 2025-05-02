package se.kth.iv1350.possystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Item class using "Banan eko 2.15kg" as test item.
 */
public class ItemTest {
    private Item item;
    private ItemDTO itemDTO;
    private final int barCode = 101;
    private final int quantity = 100;
    private final String itemName = "Banan eko 2.15kg";
    private final double price = 49.24;
    private final double VAT = 2.95;

    /**
     * Sets up a test item before each test.
     */
    @BeforeEach
    public void setUp() {
        itemDTO = new ItemDTO(itemName, price, VAT, barCode);
        item = new Item(barCode, itemDTO, quantity);
    }

    /**
     * Tests that the correct ItemDTO is returned.
     */
    @Test
    public void testGetItemDTO() {
        ItemDTO result = item.getItemDTO();
        assertEquals(itemDTO, result, "ItemDTO returned by getItemDTO() is incorrect.");
        assertEquals(itemName, result.getItemName(), "Item name mismatch.");
        assertEquals(price, result.getPrice(), 0.001, "Item price mismatch.");
    }

    /**
     * Tests that the barcode is returned correctly.
     */
    @Test
    public void testGetBarCode() {
        int result = item.getBarCode();
        assertEquals(barCode, result, "Barcode returned by getBarCode() is incorrect.");
    }

    /**
     * Tests that the store quantity is returned correctly.
     */
    @Test
    public void testGetStoreQuantity() {
        int result = item.getStoreQuantity();
        assertEquals(quantity, result, "Initial store quantity is incorrect.");
    }

    /**
     * Tests that the store quantity is reduced correctly after a sale.
     */
    @Test
    public void testUpdateQuantity() {
        int amountSold = 3;
        item.updateQuantity(amountSold);
        int result = item.getStoreQuantity();
        assertEquals(quantity - amountSold, result, "Store quantity not reduced correctly after update.");
    }
}
