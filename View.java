package se.kth.iv1350.possystem.view;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.model.Payment;
import se.kth.iv1350.possystem.model.SaleDTO;
import se.kth.iv1350.possystem.model.Item;

import java.util.List;

/**
 * This class represents the user interface.
 * It simulates a hardcoded sale by calling the controller's methods in the correct order.
 */
public class View {
    private final Controller controller;

    /**
     * Creates a new view that uses the given controller to interact with the rest of the system.
     *
     * @param controller The controller used to connect to other layers.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Simulates a complete sale from start to finish.
     * Prints the flow to the console to show how the system behaves.
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
     * Prints information about a specific item from the sale.
     *
     * @param saleDTO The current state of the sale.
     * @param index The index of the item in the list.
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
