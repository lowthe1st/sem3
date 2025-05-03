package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.List;

/**
 * Represents the receipt for a completed sale.
 * Contains time of sale, list of items, total price, VAT, and store name.
 */
public class Receipt {
    private final SaleDTO saleInformation;
    private final LocalTime timeOfSale;
    private final String storeName = "Grabbarna Grus"; // Store name shown on the receipt
    private final double totalDiscount;
    private final double totalVAT;
    private final double totalPrice;
    private final List<Item> soldItems;

    /**
     * Creates a new receipt based on the finished sale.
     * The information comes from the SaleDTO object.
     *
     * @param saleInformation Contains all details about the completed sale.
     */
    public Receipt(SaleDTO saleInformation) {
        this.saleInformation = saleInformation;
        this.timeOfSale = LocalTime.now();
        this.totalVAT = saleInformation.getTotalVAT();
        this.totalPrice = saleInformation.getTotalPrice();
        this.soldItems = saleInformation.getItems();
        this.totalDiscount = 0; // No discount logic yet
    }

    /**
     * Gets the time when the sale was completed.
     *
     * @return Time of sale.
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }

    /**
     * Gets the total price of the sale, including VAT.
     *
     * @return Total price.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Gets all items that were sold in this sale.
     *
     * @return List of sold items.
     */
    public List<Item> getSoldItems() {
        return this.soldItems;
    }

    /**
     * Gets the name of the store to show on the receipt.
     *
     * @return Store name.
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * Gets the total discount applied during the sale.
     *
     * @return Discount amount (currently always 0).
     */
    public double getTotalDiscount() {
        return this.totalDiscount;
    }

    /**
     * Gets the total VAT for the sale.
     *
     * @return VAT amount.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
}
