package models;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import utils.ReceiptWriter;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();

    public void startOrder(Scanner scanner) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n-- Order Menu --");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Sandwich sandwich = new Sandwich();
                    sandwich.build(scanner);
                    sandwiches.add(sandwich);
                    break;
                case "2":
                    Drink drink = new Drink();
                    drink.choose(scanner);
                    drinks.add(drink);
                    break;
                case "3":
                    Chip chip = new Chip();
                    chip.choose(scanner);
                    chips.add(chip);
                    break;
                case "4":
                    displayOrder();
                    System.out.print("Confirm order? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        saveReceipt();
                        ordering = false;
                    }
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void displayOrder() {
        double total = 0;
        System.out.println("\n--- Order Summary ---");

        for (Sandwich s : sandwiches) {
            total += s.getPrice();
            System.out.println(s);
        }
        for (Drink d : drinks) {
            total += d.getPrice();
            System.out.println(d);
        }
        for (Chip c : chips) {
            total += c.getPrice();
            System.out.println(c);
        }

        System.out.printf("Total: $%.2f\n", total);
    }

    private void saveReceipt() {
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        ReceiptWriter.write(filename, sandwiches, drinks, chips);
        System.out.println("Receipt saved as " + filename);
    }
}

