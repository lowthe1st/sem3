package se.kth.iv1350.possystem.controller;

import java.util.List;
import se.kth.iv1350.possystem.integration.ExternalAccountingSystem;
import se.kth.iv1350.possystem.integration.ExternalInventorySystem;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.Payment;
import se.kth.iv1350.possystem.model.Sale;
import se.kth.iv1350.possystem.model.SaleDTO;

/**
 * The Controller handles all interactions between the view,
 * the model, and the external systems in the POS system.
 */
public class Controller {
    private final ExternalAccountingSystem accounting;
    private final ExternalInventorySystem inventory;
    private final Printer printer;
    private Sale sale;

    /**
     * Creates a new instance of Controller.
     *
     * @param printer The external printer system.
     * @param accounting The external accounting system.
     * @param inventory The external inventory system.
     */
    public Controller(Printer printer, ExternalAccountingSystem accounting, ExternalInventorySystem inventory) {
        this.printer = printer;
        this.accounting = accounting;
        this.inventory = inventory;
        inventory.initializeStoreItems(); // Better method name
    }

    /**
     * Starts a new sale. This method must be called first.
     *
     * @return A DTO containing the initial sale state.
     */
    public SaleDTO startSale() {
        this.sale = new Sale();
        return sale.getSaleInformation();
    }

    /**
     * Adds an item to the current sale.
     *
     * @param barCode The barcode identifying the item.
     * @param quantity The quantity of the item.
     * @return A DTO with updated sale information, or null if the item is not found or not in stock.
     */
    public SaleDTO enterItem(int barCode, int quantity) {
        Item item = inventory.search(barCode);
        if (item == null || item.getStoreQuantity() < quantity) {
            return null;
        }

        sale.addItem(item, quantity);
        return sale.getSaleInformation();
    }

    /**
     * Ends the sale and updates the inventory accordingly.
     *
     * @return A DTO containing final sale information.
     */
    public SaleDTO endSale() {
        List<Item> items = sale.getItems();
        List<Integer> quantities = sale.getCustomerItemsQuantity();

        for (int i = 0; i < items.size(); i++) {
            Item soldItem = items.get(i);
            int quantitySold = quantities.get(i);

            inventory.updateItemQuantity(soldItem.getID(), quantitySold);
        }

        return sale.getSaleInformation();
    }

    /**
     * Registers the payment, calculates change, and updates the accounting system.
     *
     * @param amount The amount paid by the customer.
     * @return A Payment object containing the change and payment status.
     */
    public Payment pay(double amount) {
        double totalPrice = sale.getTotalPrice();
        double change = amount - totalPrice;
        String paymentMessage = "Approved";

        if (change >= 0) {
            accounting.update(amount - change);
        } else {
            paymentMessage = "Too little money";
            change = 0;
        }

        return new Payment(change, paymentMessage);
    }

    /**
     * Prints the receipt for the current sale using the external printer.
     */
    public void printReceipt() {
        printer.print(sale.getReceipt(sale));
    }
}