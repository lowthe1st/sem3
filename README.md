# IV1350 Seminar 3 – Point of Sale System

Description

This project is a simplified Point of Sale (POS) system developed in Java for the course IV1350: Object-Oriented Design at Stockholm University (VT2025). It follows principles of object-oriented programming such as high cohesion, low coupling, and layered architecture.

The system simulates a checkout process, where a cashier can:
- Start a new sale
- Register items (such as Banan eko 2.15kg and Felix Potatisbullar)
- View a running total including VAT
- Finalize the sale
- Handle payment and calculate change
- Print a receipt

All operations are triggered via hardcoded method calls in the `View` class. Output is printed directly to the console.

Project Structure

The project is divided into the following packages:

- controller – Handles coordination between the view, model, and integration layers
- model – Contains the business logic (Sale, Item, Receipt, and related DTOs)
- integration – Simulates external systems such as the inventory, accounting system, and printer
- view – Contains the simulated user interface (`runFakeExecution`)
- startup – Includes the main class that launches the program

How to Run?

1. Clone the repository:
https://github.com/lowthe1st/sem3.git

2. Open the project in NetBeans or another Java IDE.

3. Run `Main.java`
