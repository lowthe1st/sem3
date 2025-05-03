package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple object used to send sale information between different parts of the system.
 * It includes time of sale, total VAT, total price, and a list of sold items.
 */
public class SaleDTO {
    private final LocalTime time;
    private final double totalVAT;
    private final double totalPrice;
    private final List<Item> items;

    /**
     * Creates a new SaleDTO with the given data.
     *
     * @param time The time when the sale started.
     * @param totalVAT Total VAT from all items in the sale.
     * @param totalPrice Total price including VAT.
     * @param items The items included in the sale.
     */
    public SaleDTO(LocalTime time, double totalVAT, double totalPrice, List<Item> items) {
        this.time = time;
        this.totalVAT = totalVAT;
        this.totalPrice = totalPrice;
        this.items = new ArrayList<>(items); // Avoid exposing internal list
    }

    /**
     * Gets the time of the sale.
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     * Gets the total VAT.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    /**
     * Gets the total price including VAT.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Returns the list of items in the sale.
     */
    public List<Item> getItems() {
        return new ArrayList<>(this.items); // Return a copy to keep original safe
    }
}
