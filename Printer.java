package se.kth.iv1350.possystem.integration;

import se.kth.iv1350.possystem.model.Receipt;
import se.kth.iv1350.possystem.model.Item;

/**
 * Simulates an external printer that prints out a receipt after a sale.
 */
public class Printer {

    /**
     * Creates a new printer instance.
     */
    public Printer() {
        // Nothing needed here right now.
    }

    /**
     * Prints a receipt with the sale details.
     *
     * @param receipt The receipt to print.
     */
    public void print(Receipt receipt) {
        System.out.println("-------- Receipt --------");
        System.out.println("Printing receipt...");
        System.out.println("Date and time of purchase: " + receipt.getTimeOfSale());
        System.out.println("Store: " + receipt.getNameOfStore());
        System.out.println("Total discount: " + receipt.getTotalDiscount());

        double totalVAT = 0;
        double totalPrice = 0;

        System.out.println("Items:");
        for (Item item : receipt.getNameOfItems()) {
            String itemName = item.getItemDTO().getItemName();
            double price = item.getItemDTO().getPrice();
            double vat = item.getItemDTO().getVAT();

            System.out.println("- " + itemName + " " + String.format("%.2f", price) + " SEK");
            totalVAT += vat;
            totalPrice += price;
        }

        System.out.println("Total price: " + String.format("%.2f", totalPrice));
        System.out.println("Total VAT: " + String.format("%.2f", totalVAT));
        System.out.println("--------------------------");
    }
}



