package se.kth.iv1350.possystem.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.ItemDTO;

/**
 * Simulates an external inventory system. Contains a hardcoded list
 * of items available in the store.
 */
public class ExternalInventorySystem {
    private final List<Item> storeItems = new ArrayList<>();
    private final List<ItemDTO> itemDTOs = new ArrayList<>();

    /**
     * Creates a new instance of the external inventory system.
     */
    public ExternalInventorySystem() {
        // Constructor left intentionally empty.
    }

    /**
     * Returns the current list of items available in the store.
     *
     * @return A list of all items in inventory.
     */
    public List<Item> getStoreItems() {
        return new ArrayList<>(this.storeItems); // Return copy for encapsulation
    }

    /**
     * Initializes the inventory with predefined items.
     * This simulates loading items from an external source.
     */
    public void initializeStoreItems() {
        itemDTOs.add(new ItemDTO("Apples 5kg", 130.0, 8, 123));
        itemDTOs.add(new ItemDTO("Ketchup", 10.0, 5, 234));
        itemDTOs.add(new ItemDTO("Fish 100g", 20.0, 6, 345));

        storeItems.add(new Item(1, itemDTOs.get(0), 100));
        storeItems.add(new Item(2, itemDTOs.get(1), 100));
        storeItems.add(new Item(3, itemDTOs.get(2), 100));
    }

    /**
     * Searches for an item in the inventory using its barcode.
     *
     * @param barCode The unique barcode that identifies the item.
     * @return The corresponding item if found; otherwise, null.
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
     * Updates the inventory quantity for a specific item.
     *
     * @param barCode The barcode of the item to update.
     * @param quantitySold The number of items sold to deduct from stock.
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

