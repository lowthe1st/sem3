package se.kth.iv1350.possystem.view;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.model.Payment;
import se.kth.iv1350.possystem.model.SaleDTO;
import se.kth.iv1350.possystem.model.Item;

import java.util.List;

/**
 * Represents the user interface (UI) of the application.
 * Simulates a hardcoded execution of a sale by calling system operations through the controller.
 */
public class View {
    private final Controller controller;

    /**
     * Creates a new instance of View that uses the given controller for all system interactions.
     *
     * @param controller The controller to interact with other layers of the application.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Performs a simulated sale by invoking system operations in the correct order.
     * Prints out each step to the console.
     */
    public void runFakeExecution() {
        controller.startSale();
        System.out.println("Starting a new sale\n");

        System.out.println("Scan items");

        SaleDTO saleDTO = controller.enterItem(1, 10);
        printItemInfo(saleDTO, 0);

        saleDTO = controller.enterItem(2, 1);
        printItemInfo(saleDTO, 1);

        controller.endSale();
        System.out.println("Sale ended\n");

        System.out.println("--------Receipt--------");
        controller.print();

        double totalPrice = saleDTO.getTotalPrice();
        Payment payment = controller.pay(200);
        if (!payment.getMessage().isEmpty()) {
            System.out.println(payment.getMessage());
        }
        System.out.println("Change: " + String.format("%.2f", payment.getChange()) + " SEK");
    }

    /**
     * Prints details of a single item from a SaleDTO.
     *
     * @param saleDTO The current sale state.
     * @param index The index of the item to print.
     */
    private void printItemInfo(SaleDTO saleDTO, int index) {
        List<Item> items = saleDTO.getItems();
        Item item = items.get(index);
        String name = item.getItemDTO().getItemName();
        double price = item.getItemDTO().getPrice();
        double vat = item.getItemDTO().getVAT();
        int barCode = item.getItemDTO().getBarCode();

        System.out.println("Item ID: " + barCode);
        System.out.println("Item: " + name + " " + price + " SEK");
        System.out.println("Item VAT: " + vat + " SEK");
        System.out.println("Running total including VAT: " + String.format("%.2f", saleDTO.getTotalPrice()) + " SEK\n");
    }
}
