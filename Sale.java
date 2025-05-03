package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sale made to a customer.
 * It keeps track of items, their quantities, total price and VAT.
 */
public class Sale {
    private final LocalTime timeOfSale;
    private final List<Item> items;
    private final List<Integer> itemQuantities;
    private double totalVAT;
    private double totalPrice;
    private SaleDTO saleInformation;
    private Receipt receipt;

    /**
     * Creates a new sale and sets the time it started.
     */
    public Sale() {
        this.timeOfSale = LocalTime.now();
        this.items = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        this.saleInformation = new SaleDTO(timeOfSale, 0, 0, items);
    }

    /**
     * Returns all items added during the sale.
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Returns the quantity for each item.
     * Index in this list matches index in the item list.
     */
    public List<Integer> getCustomerItemsQuantity() {
        return this.itemQuantities;
    }

    /**
     * Returns current information about the sale.
     */
    public SaleDTO getSaleInformation() {
        return this.saleInformation;
    }

    /**
     * Adds an item to the sale. If it's already in the list, the quantity is increased.
     */
    public void addItem(Item item, int quantity) {
        updateTotalVAT(item.getItemDTO().getVAT(), quantity);
        updateTotalPrice(item.getItemDTO().getPrice(), item.getItemDTO().getVAT(), quantity);
        handleDuplicateOrNewItem(item, quantity);
    }

    /**
     * Returns a receipt based on this sale.
     */
    public Receipt getReceipt(Sale sale) {
        this.receipt = new Receipt(sale.getSaleInformation());
        return receipt;
    }

    private void updateTotalPrice(double price, double vat, int quantity) {
        this.totalPrice += (price + vat) * quantity;
        updateSaleInformation();
    }

    private void updateTotalVAT(double vat, int quantity) {
        this.totalVAT += vat * quantity;
        updateSaleInformation();
    }

    /**
     * If the item has already been added, the quantity is updated.
     * Otherwise, it is added as a new item.
     */
    private void handleDuplicateOrNewItem(Item item, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarCode() == item.getBarCode()) {
                itemQuantities.set(i, itemQuantities.get(i) + quantity);
                return;
            }
        }
        items.add(item);
        itemQuantities.add(quantity);
        updateSaleInformation();
    }

    /**
     * Updates the SaleDTO to reflect the current state of the sale.
     */
    private void updateSaleInformation() {
        this.saleInformation = new SaleDTO(timeOfSale, totalVAT, totalPrice, items);
    }
}
