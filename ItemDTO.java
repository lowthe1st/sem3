package se.kth.iv1350.possystem.model;

/**
 * A Data Transfer Object (DTO) that carries immutable information about an item.
 */
public class ItemDTO {
    private final String itemName;
    private final double price;
    private final double VAT;
    private final int barCode;

    /**
     * Creates a new instance of ItemDTO.
     *
     * @param itemName The name of the item.
     * @param price The price of the item.
     * @param VAT The VAT rate applied to the item.
     * @param barCode The unique barcode that identifies the item.
     */
    public ItemDTO(String itemName, double price, double VAT, int barCode) {
        this.itemName = itemName;
        this.price = price;
        this.VAT = VAT;
        this.barCode = barCode;
    }

    /**
     * Returns the name of the item.
     *
     * @return The item's name.
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Returns the price of the item.
     *
     * @return The item's price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the VAT for the item.
     *
     * @return The item's VAT.
     */
    public double getVAT() {
        return this.VAT;
    }

    /**
     * Returns the barcode of the item.
     *
     * @return The item's barcode.
     */
    public int getBarCode() {
        return this.barCode;
    }
}
