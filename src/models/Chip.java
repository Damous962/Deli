package models;

import java.util.Scanner;

public class Chip {
    private String type;

    public void choose(Scanner scanner) {
        System.out.print("Enter chip type: ");
        type = scanner.nextLine();
    }

    public double getPrice() {
        return 1.50;
    }

    public String toString() {
        return String.format("Chips: %s - $%.2f", type, getPrice());
    }
}

