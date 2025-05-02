package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A data transfer object (DTO) containing information about a completed sale.
 * Includes the time of sale, total VAT, total price, and the list of items sold.
 */
public class SaleDTO {
    private final LocalTime time;
    private final double totalVAT;
    private final double totalPrice;
    private final List<Item> items;

    /**
     * Creates a new instance of SaleDTO.
     *
     * @param time The time when the sale was initiated.
     * @param totalVAT The total VAT accumulated from all sold items.
     * @param totalPrice The total price including VAT for the entire sale.
     * @param items The list of items sold during the sale.
     */
    public SaleDTO(LocalTime time, double totalVAT, double totalPrice, List<Item> items) {
        this.time = time;
        this.totalVAT = totalVAT;
        this.totalPrice = totalPrice;
        this.items = new ArrayList<>(items); // Defensively copied
    }

    /**
     * Returns the time of the sale.
     *
     * @return The sale's timestamp.
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     * Returns the total VAT for the sale.
     *
     * @return The total VAT amount.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    /**
     * Returns the total price of the sale including VAT.
     *
     * @return The total price.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Returns a copy of the list of items sold.
     *
     * @return A list containing the sold items.
     */
    public List<Item> getItems() {
        return new ArrayList<>(this.items); // Defensive copy
    }
}
