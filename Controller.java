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
 * Handles all communication between the view and the rest of the system.
 */
public class Controller {
    private final ExternalAccountingSystem accounting;
    private final ExternalInventorySystem inventory;
    private final Printer printer;
    private Sale sale;

    /**
     * Creates a new controller.
     *
     * @param printer The printer used for printing receipts.
     * @param accounting The accounting system used to update store balance.
     * @param inventory The inventory system containing store items.
     */
    public Controller(Printer printer, ExternalAccountingSystem accounting, ExternalInventorySystem inventory) {
        this.printer = printer;
        this.accounting = accounting;
        this.inventory = inventory;
        inventory.initializeStoreItems(); // Loads example items into the system
    }

    /**
     * Starts a new sale.
     */
    public SaleDTO startSale() {
        this.sale = new Sale();
        return sale.getSaleInformation();
    }

    /**
     * Adds an item to the sale.
     *
     * @param barCode The barcode of the item.
     * @param quantity How many the customer wants.
     * @return Updated sale info, or null if item isn't found or out of stock.
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
     * Ends the sale and updates inventory quantities.
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
     * Handles payment and updates accounting.
     *
     * @param amount The amount the customer paid.
     * @return A payment object showing change and status.
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
     * Prints the receipt for the finished sale.
     */
    public void printReceipt() {
        printer.print(sale.getReceipt(sale));
    }
}
