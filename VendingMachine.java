import java.util.Scanner;

public class VendingMachine {
	private int inventoryCount;
	private double itemPrice;
	private double currentBalance;
	
	// Default constructor
	public VendingMachine() {
		this.inventoryCount = 20;
		this.itemPrice = 0.0;
		this.currentBalance = 0.0;
	}
	
	// Parameterized constructor
	public VendingMachine(int inventoryCount, double itemPrice, double currentBalance) {
		this.inventoryCount = inventoryCount;
		this.itemPrice = itemPrice;
		this.currentBalance = currentBalance;
	}
	
	// Setters
	public void insertMoney(double amount) {
		currentBalance += amount;
		System.out.println("$" + amount + " inserted, " + "New balance is " + currentBalance);
	}
	
	// Re-stock vending machine - Caps at 20
	 public void restock(int amount) {
		 if (inventoryCount < 20) {
			 System.out.println("Re-stock notification sent to admin.");
		 }
	 }
	
	// Getters
	 public int getInventory() {
		 return inventoryCount;
	 }
	 
	 public String pressBuyButton() {
		 if (inventoryCount > 0 && currentBalance >= itemPrice) {
			 double change = 0;
			 change = currentBalance - itemPrice;
			 inventoryCount--;
			 return "Purchase successful. Your change is: " + change;
		 } else {
			 return "Unable to purchase item. Please try again.";
		 }
		 
	 }
	 
	 public double getBalance() {
			return currentBalance;
	}

	public static void main(String[] args) {
		int userOption = 0;
		int snacks = 0;
		int moneyInserted = 0;
		
		// Create vending machine instance
		VendingMachine snackVendor = new VendingMachine(20, 10, 200);
		
		// Scanner for user input
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\n --- VENDING MACHINE ---");
		System.out.println("1. Buy Snack | 2. Insert Money | 3. Exit");
		
		System.out.println("Your Option: ");
		userOption = scnr.nextInt();
		
		while (userOption != 3) {
			if (userOption == 1) {
				// Print results to user				
				System.out.println(snackVendor.pressBuyButton());
				System.out.println("Snacks remaining: " + snackVendor.getInventory());
			} else if (userOption == 2) {
				System.out.println("Current Balance: " + snackVendor.getBalance());
				
				System.out.println("Insert amount: ");
				moneyInserted = scnr.nextInt();
				snackVendor.insertMoney(moneyInserted);
			} else {
				System.out.println("Error! Choose from one of options above.");
			}
			
			System.out.println("\n1. Buy | 2. Insert Money | 3. Exit");
	        System.out.print("Next Option: ");
	        userOption = scnr.nextInt();
		}
		System.out.println("Thanks for using our vending machine. Bye!!"); 
	}
}
