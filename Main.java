package se.kth.iv1350.possystem.startup;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.integration.ExternalAccountingSystem;
import se.kth.iv1350.possystem.integration.ExternalInventorySystem;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.view.View;

/**
 * Starts the entire application. Contains the {@code main} method that initializes
 * the system and triggers a simulated sale through the view.
 */
public class Main {

    /**
     * The main method used to launch the Point of Sale application.
     * No command-line arguments are required.
     *
     * @param args This application does not use any command-line arguments.
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalAccountingSystem accounting = new ExternalAccountingSystem();
        ExternalInventorySystem inventory = new ExternalInventorySystem();

        Controller controller = new Controller(printer, accounting, inventory);
        View view = new View(controller);

        view.runFakeExecution(); // Simulated sale
    }
}
