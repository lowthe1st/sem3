package se.kth.iv1350.possystem.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.integration.ExternalAccountingSystem;
import se.kth.iv1350.possystem.integration.ExternalInventorySystem;
import se.kth.iv1350.possystem.integration.Printer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the View class to ensure the simulated run does not throw errors.
 */
public class ViewTest {

    private View view;

    @BeforeEach
    public void setUp() {
        Printer printer = new Printer();
        ExternalAccountingSystem accounting = new ExternalAccountingSystem();
        ExternalInventorySystem inventory = new ExternalInventorySystem();
        inventory.initializeStoreItems(); // Important: preload items

        Controller controller = new Controller(printer, accounting, inventory);
        view = new View(controller);
    }

    /**
     * Verifies that the simulated execution runs without throwing exceptions.
     */
    @Test
    public void testRunFakeExecutionDoesNotCrash() {
        assertDoesNotThrow(() -> view.runFakeExecution(), "runFakeExecution() should not throw any exceptions.");
    }
}

