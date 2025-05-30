package models;

import java.util.Scanner;

public class Drink {
    private String size;
    private String flavor;

    public void choose(Scanner scanner) {
        System.out.print("Choose drink size (small / medium / large): ");
        size = scanner.nextLine();
        System.out.print("Enter drink flavor: ");
        flavor = scanner.nextLine();
    }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public String toString() {
        return String.format("Drink: %s %s - $%.2f", size, flavor, getPrice());
    }
}
