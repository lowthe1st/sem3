package se.kth.iv1350.possystem.model;

/**
 * Represents an item that exists in the store’s inventory.
 * Stores product info and how many are available.
 */
public class Item {
    private final ItemDTO itemDTO;
    private final int barCode;
    private int storeQuantity;

    /**
     * Creates a new item in the system.
     *
     * @param barCode The barcode that identifies the item.
     * @param itemDTO Object with details like name, price and VAT.
     * @param quantity How many units are in stock.
     */
    public Item(int barCode, ItemDTO itemDTO, int quantity) {
        this.barCode = barCode;
        this.itemDTO = itemDTO;
        this.storeQuantity = quantity;
    }

    /**
     * Gets the item’s basic info (name, price, etc).
     */
    public ItemDTO getItemDTO() {
        return this.itemDTO;
    }

    /**
     * Returns this item’s barcode.
     */
    public int getBarCode() {
        return this.barCode;
    }

    /**
     * Returns how many units are in stock.
     */
    public int getStoreQuantity() {
        return this.storeQuantity;
    }

    /**
     * Updates the quantity after a sale.
     *
     * @param amountSold The number of units sold.
     */
    public void updateQuantity(int amountSold) {
        this.storeQuantity -= amountSold;
    }
}
