import java.util.Scanner;
import models.Order;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== DELI-cious ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
                    order.startOrder(scanner);
                    break;
                case "0":
                    running = false;
                    System.out.println("Thanks for visiting DELI-cious!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
