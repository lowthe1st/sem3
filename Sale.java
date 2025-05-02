package se.kth.iv1350.possystem.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sale transaction involving one customer and one or more items.
 * Handles item registration, price and VAT calculation, and generates sale information.
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
     * Creates a new Sale instance and initializes the item list and sale timestamp.
     */
    public Sale() {
        this.timeOfSale = LocalTime.now();
        this.items = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        this.saleInformation = new SaleDTO(timeOfSale, 0, 0, items);
    }

    /**
     * Returns the list of items added to the sale.
     *
     * @return A list of all items in the sale.
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Returns the quantity for each item in the sale.
     * The index in this list corresponds to the index in the items list.
     *
     * @return List of item quantities.
     */
    public List<Integer> getCustomerItemsQuantity() {
        return this.itemQuantities;
    }

    /**
     * Returns a data object with the current sale information.
     *
     * @return A SaleDTO with the latest data.
     */
    public SaleDTO getSaleInformation() {
        return this.saleInformation;
    }

    /**
     * Adds an item to the sale, or updates the quantity if it already exists.
     *
     * @param item The item to add.
     * @param quantity The number of units to add.
     */
    public void addItem(Item item, int quantity) {
        updateTotalVAT(item.getItemDTO().getVAT(), quantity);
        updateTotalPrice(item.getItemDTO().getPrice(), item.getItemDTO().getVAT(), quantity);
        handleDuplicateOrNewItem(item, quantity);
    }

    /**
     * Creates and returns a receipt based on the current sale state.
     *
     * @param sale The completed sale.
     * @return The generated receipt.
     */
    public Receipt getReceipt(Sale sale) {
        this.receipt = new Receipt(sale.getSaleInformation());
        return receipt;
    }

    /**
     * Updates the total price based on the item's price and VAT.
     *
     * @param price The unit price of the item.
     * @param vat The VAT rate of the item.
     * @param quantity The number of items sold.
     */
    private void updateTotalPrice(double price, double vat, int quantity) {
        this.totalPrice += (price + vat) * quantity;
        updateSaleInformation();
    }

    /**
     * Updates the total VAT amount for the sale.
     *
     * @param vat The VAT rate per item.
     * @param quantity The number of items.
     */
    private void updateTotalVAT(double vat, int quantity) {
        this.totalVAT += vat * quantity;
        updateSaleInformation();
    }

    /**
     * Adds the item to the item list, or increases quantity if already added.
     *
     * @param item The item being processed.
     * @param quantity The number of units being added.
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
     * Updates the SaleDTO object with the latest sale data.
     */
    private void updateSaleInformation() {
        this.saleInformation = new SaleDTO(timeOfSale, totalVAT, totalPrice, items);
    }
}


