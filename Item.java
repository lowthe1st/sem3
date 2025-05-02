package se.kth.iv1350.possystem.model;

/**
 * Represents a specific item in the store's inventory.
 * Contains product information and the current stock quantity.
 */
public class Item {
    private final ItemDTO itemDTO;
    private final int barCode;
    private int storeQuantity;

    /**
     * Creates a new instance of an Item.
     *
     * @param barCode The unique barcode identifying the item.
     * @param itemDTO The data transfer object containing item details.
     * @param quantity The initial quantity of the item in stock.
     */
    public Item(int barCode, ItemDTO itemDTO, int quantity) {
        this.barCode = barCode;
        this.itemDTO = itemDTO;
        this.storeQuantity = quantity;
    }

    /**
     * Returns the item’s data transfer object containing its description.
     *
     * @return The item’s DTO.
     */
    public ItemDTO getItemDTO() {
        return this.itemDTO;
    }

    /**
     * Returns the barcode of this item.
     *
     * @return The item's barcode.
     */
    public int getBarCode() {
        return this.barCode;
    }

    /**
     * Returns the quantity of this item currently in stock.
     *
     * @return The quantity available in store.
     */
    public int getStoreQuantity() {
        return this.storeQuantity;
    }

    /**
     * Reduces the store quantity based on the amount sold.
     *
     * @param amountSold The number of units sold.
     */
    public void updateQuantity(int amountSold) {
        this.storeQuantity -= amountSold;
    }
}
