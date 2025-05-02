/package se.kth.iv1350.possystem.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Sale class using real POS items.
 */
public class SaleTest {
    private Sale sale;

    private final String bananaName = "Banan eko 2.15kg";
    private final double bananaPrice = 49.24;
    private final double bananaVAT = 2.95;
    private final int bananaBarCode = 101;

    private final String potatisbullarName = "Felix Potatisbullar";
    private final double potatisbullarPrice = 17.90;
    private final double potatisbullarVAT = 2.15;
    private final int potatisbullarBarCode = 203;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }

    @Test
    public void testGetItemsInitiallyEmpty() {
        List<Item> result = sale.getItems();
        assertTrue(result.isEmpty(), "Expected item list to be empty initially.");
    }

    @Test
    public void testGetCustomerItemsQuantityInitiallyEmpty() {
        List<Integer> result = sale.getCustomerItemsQuantity();
        assertTrue(result.isEmpty(), "Expected customer item quantity list to be empty initially.");
    }

    @Test
    public void testGetSaleInformationNotNull() {
        SaleDTO result = sale.getSaleInformation();
        assertNotNull(result, "Expected SaleDTO to be initialized.");
    }

    @Test
    public void testAddBananaItemUpdatesListsAndTotals() {
        ItemDTO bananaDTO = new ItemDTO(bananaName, bananaPrice, bananaVAT, bananaBarCode);
        Item bananaItem = new Item(bananaBarCode, bananaDTO, 100);
        int quantity = 2;

        sale.addItem(bananaItem, quantity);

        List<Item> items = sale.getItems();
        List<Integer> quantities = sale.getCustomerItemsQuantity();
        SaleDTO info = sale.getSaleInformation();

        assertEquals(1, items.size(), "Should contain exactly one item after adding.");
        assertEquals(quantity, quantities.get(0), "Stored quantity should match the added quantity.");
        assertEquals((bananaPrice + bananaVAT) * quantity, info.getTotalPrice(), 0.01, "Total price not calculated correctly.");
        assertEquals(bananaVAT * quantity, info.getTotalVAT(), 0.01, "Total VAT not calculated correctly.");
    }

    @Test
    public void testAddTwoDifferentItems() {
        ItemDTO bananaDTO = new ItemDTO(bananaName, bananaPrice, bananaVAT, bananaBarCode);
        ItemDTO potatisDTO = new ItemDTO(potatisbullarName, potatisbullarPrice, potatisbullarVAT, potatisbullarBarCode);

        Item bananaItem = new Item(bananaBarCode, bananaDTO, 100);
        Item potatisItem = new Item(potatisbullarBarCode, potatisDTO, 100);

        sale.addItem(bananaItem, 1);
        sale.addItem(potatisItem, 1);

        List<Item> items = sale.getItems();
        assertEquals(2, items.size(), "Should contain two items.");
    }

    @Test
    public void testGetReceiptReturnsNotNull() {
        Receipt result = sale.getReceipt(sale);
        assertNotNull(result, "Receipt should not be null.");
    }
}

