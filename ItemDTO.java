package se.kth.iv1350.possystem.model;

/**
 * A simple container for item data like name, price, VAT, and barcode.
 * This object is used to transfer item info without exposing logic.
 */
public class ItemDTO {
    private final String itemName;
    private final double price;
    private final double VAT;
    private final int barCode;

    /**
     * Creates a new item data object.
     *
     * @param itemName The name of the item.
     * @param price The item's price (before VAT).
     * @param VAT VAT value applied to the item.
     * @param barCode Unique barcode used to identify the item.
     */
    public ItemDTO(String itemName, double price, double VAT, int barCode) {
        this.itemName = itemName;
        this.price = price;
        this.VAT = VAT;
        this.barCode = barCode;
    }

    /**
     * Gets the item's name.
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Gets the item's price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the VAT amount for the item.
     */
    public double getVAT() {
        return this.VAT;
    }

    /**
     * Gets the item's barcode.
     */
    public int getBarCode() {
        return this.barCode;
    }
}
