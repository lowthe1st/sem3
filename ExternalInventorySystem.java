package se.kth.iv1350.possystem.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.ItemDTO;

/**
 * Simulates the store's external inventory system.
 * Contains a hardcoded list of available items.
 */
public class ExternalInventorySystem {
    private final List<Item> storeItems = new ArrayList<>();
    private final List<ItemDTO> itemDTOs = new ArrayList<>();

    /**
     * Creates the inventory system. Items are added later.
     */
    public ExternalInventorySystem() {
        // No items added in constructor, handled separately.
    }

    /**
     * Returns all items currently in the store.
     */
    public List<Item> getStoreItems() {
        return new ArrayList<>(this.storeItems); // Return copy to protect list
    }

    /**
     * Adds some example items to the inventory.
     * This simulates loading from a real database.
     */
    public void initializeStoreItems() {
        itemDTOs.add(new ItemDTO("Banan eko 2.15kg", 49.24, 2.95, 1));
        itemDTOs.add(new ItemDTO("Felix Potatisbullar", 17.90, 2.15, 2));
        itemDTOs.add(new ItemDTO("Fish 100g", 20.0, 6.0, 3));

        storeItems.add(new Item(1, itemDTOs.get(0), 100));
        storeItems.add(new Item(2, itemDTOs.get(1), 100));
        storeItems.add(new Item(3, itemDTOs.get(2), 100));
    }

    /**
     * Looks up an item in the inventory by barcode.
     *
     * @param barCode The item's barcode.
     * @return The item if found, otherwise null.
     */
    public Item search(int barCode) {
        for (Item item : storeItems) {
            if (item.getBarCode() == barCode) {
                return item;
            }
        }
        return null;
    }

    /**
     * Reduces the quantity of an item after it's sold.
     *
     * @param barCode The barcode of the sold item.
     * @param quantitySold How many were sold.
     */
    public void updateItemQuantity(int barCode, int quantitySold) {
        for (Item item : storeItems) {
            if (item.getBarCode() == barCode) {
                item.updateQuantity(quantitySold);
                break;
            }
        }
    }
}
