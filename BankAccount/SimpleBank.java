import java.util.Scanner;

public class SimpleBank {
    // Topic 4 & 7: Using Arrays as "Databases" for names and balances
    static String[] names = {"Alice", "Bob", "Charlie"};
    static double[] balances = {1000.0, 500.0, 250.0};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Single-Class Bank!");

        // Topic 6: While Loop for the Menu
        while (running) {
            System.out.println("\n1. View All\n2. Withdraw\n3. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            // Topic 5: Branches
            if (choice == 1) {
                displayAccounts(); // Calling a static method
            } 
            else if (choice == 2) {
                System.out.print("Enter Account ID (0-2): ");
                int id = input.nextInt();
                
                // Topic 5: Validation Branching
                if (id >= 0 && id < names.length) {
                    System.out.print("Amount to withdraw: ");
                    double amount = input.nextDouble();
                    
                    // Topic 8: Method with multiple parameters
                    performWithdraw(id, amount);
                } else {
                    System.out.println("Invalid ID.");
                }
            } 
            else if (choice == 3) {
                running = false;
                System.out.println("System Shutdown.");
            }
        }
    }

    // Topic 3 & 8: Static Method to display data
    public static void displayAccounts() {
        System.out.println("\n--- Current Balances ---");
        // Topic 6 & 7: Loop through the arrays
        for (int i = 0; i < names.length; i++) {
            System.out.println("ID " + i + ": " + names[i] + " - $" + balances[i]);
        }
    }

    // Topic 8 & 9: Method Continued (Logic for updating array data)
    public static void performWithdraw(int id, double amount) {
        if (amount > 0 && amount <= balances[id]) {
            balances[id] -= amount; // Topic 4: Updating a double value
            System.out.println("Withdrawal successful! New balance: $" + balances[id]);
        } else {
            System.out.println("Error: Insufficient funds.");
        }
    }
}