package utils;

import java.io.*;
import java.util.*;
import models.Sandwich;
import models.Drink;
import models.Chip;

public class ReceiptWriter {
    public static void write(String filename, List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        try {
            File folder = new File("receipts");
            if (!folder.exists()) folder.mkdir();

            FileWriter writer = new FileWriter("receipts/" + filename);
            double total = 0;

            writer.write("--- Receipt ---\n\n");
            for (Sandwich s : sandwiches) {
                writer.write(s.toString() + "\n");
                total += s.getPrice();
            }
            for (Drink d : drinks) {
                writer.write(d.toString() + "\n");
                total += d.getPrice();
            }
            for (Chip c : chips) {
                writer.write(c.toString() + "\n");
                total += c.getPrice();
            }
            writer.write(String.format("\nTotal: $%.2f\n", total));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
