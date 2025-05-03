package se.kth.iv1350.possystem.startup;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.integration.ExternalAccountingSystem;
import se.kth.iv1350.possystem.integration.ExternalInventorySystem;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.view.View;

/**
 * Starts the application. Creates all parts of the system and runs a fake sale.
 */
public class Main {

    /**
     * Entry point of the program. No command-line arguments are used.
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalAccountingSystem accounting = new ExternalAccountingSystem();
        ExternalInventorySystem inventory = new ExternalInventorySystem();

        Controller controller = new Controller(printer, accounting, inventory);
        View view = new View(controller);

        view.runFakeExecution(); // Runs a hardcoded example sale
    }
}
