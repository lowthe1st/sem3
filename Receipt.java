package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.List;

/**
 * Represents the receipt of a completed sale.
 * Contains time, item list, prices, VAT and store information.
 */
public class Receipt {
    private final SaleDTO saleInformation;
    private final LocalTime timeOfSale;
    private final String storeName = "Grabbarna Grus"; // Anpassat enligt tidigare input
    private final double totalDiscount;
    private final double totalVAT;
    private final double totalPrice;
    private final List<Item> soldItems;

    /**
     * Creates a new Receipt for a completed sale.
     *
     * @param saleInformation A DTO containing sale data at the time of completion.
     */
    public Receipt(SaleDTO saleInformation) {
        this.saleInformation = saleInformation;
        this.timeOfSale = LocalTime.now();
        this.totalVAT = saleInformation.getTotalVAT();
        this.totalPrice = saleInformation.getTotalPrice();
        this.soldItems = saleInformation.getItems();
        this.totalDiscount = 0; // Set explicitly for now (no discount logic yet)
    }

    /**
     * Returns the time when the sale was completed.
     *
     * @return The sale's timestamp.
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }

    /**
     * Returns the total price of the sale.
     *
     * @return The total price including VAT.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Returns the list of items that were sold in this sale.
     *
     * @return A list of sold items.
     */
    public List<Item> getSoldItems() {
        return this.soldItems;
    }

    /**
     * Returns the name of the store.
     *
     * @return The name of the store.
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * Returns the total discount applied to the sale.
     *
     * @return The total discount value.
     */
    public double getTotalDiscount() {
        return this.totalDiscount;
    }

    /**
     * Returns the total VAT for the sale.
     *
     * @return The total VAT amount.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
}
