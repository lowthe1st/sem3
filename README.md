# IV1350 Seminar 3 – Point of Sale System

## Description
This project is a simplified **Point of Sale (POS)** system implemented in Java as part of the IV1350 Object-Oriented Design course at Stockholm University. It is based on the design created in Seminar 2 and follows object-oriented best practices such as high cohesion, low coupling, and encapsulation.

The POS system simulates a checkout flow with:
- Start of sale
- Item registration (e.g., *Banan eko 2.15kg*, *Felix Potatisbullar*)
- Calculation of running total including VAT
- Sale finalization and payment
- Receipt printing

All operations are simulated via hardcoded calls in the `View` class.

## Project Structure

| Package | Description |
|--------|-------------|
| `controller` | Handles communication between view, model, and integration layers |
| `model` | Contains business logic (`Sale`, `Item`, `Receipt`, etc.) |
| `integration` | Simulates external systems (inventory, accounting, printer) |
| `view` | Simulated UI via `runFakeExecution()` |
| `startup` | Contains `Main.java` to start the system |

##  How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/lowthe1st/possystem-seminar3.git
   cd possystem-seminar3
