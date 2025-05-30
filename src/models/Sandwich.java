package models;

import java.util.*;

public class Sandwich {
    private String size;
    private String bread;
    private boolean toasted;
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> regulars = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public void build(Scanner scanner) {
        System.out.print("Choose size (4\" / 8\" / 12\"): ");
        size = scanner.nextLine();

        System.out.print("Choose bread (white / wheat / rye / wrap): ");
        bread = scanner.nextLine();

        System.out.print("Toasted? (yes/no): ");
        toasted = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Add meats (comma separated, e.g., ham,bacon): ");
        meats = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Add cheeses (comma separated): ");
        cheeses = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Add regular toppings (comma separated): ");
        regulars = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Add sauces (comma separated): ");
        sauces = Arrays.asList(scanner.nextLine().split(","));
    }

    public double getPrice() {
        double base = switch (size) {
            case "4\"" -> 5.50;
            case "8\"" -> 7.00;
            case "12\"" -> 8.50;
            default -> 0;
        };

        double meatPrice = switch (size) {
            case "4\"" -> meats.size() * 1.00;
            case "8\"" -> meats.size() * 2.00;
            case "12\"" -> meats.size() * 3.00;
            default -> 0;
        };

        double cheesePrice = switch (size) {
            case "4\"" -> cheeses.size() * 0.75;
            case "8\"" -> cheeses.size() * 1.50;
            case "12\"" -> cheeses.size() * 2.25;
            default -> 0;
        };

        return base + meatPrice + cheesePrice;
    }

    public String toString() {
        return String.format("%s %s Sandwich%s\nMeats: %s\nCheeses: %s\nToppings: %s\nSauces: %s\nPrice: $%.2f\n",
                size, bread, toasted ? " (Toasted)" : "",
                meats, cheeses, regulars, sauces, getPrice());
    }
}
