import java.util.Scanner;

public class BankAccount {
	
	// Private fields
	private int pin; 
	private double balance;
	private int failedAttempts;
	private boolean isLocked;
	
	// Default constructor
	public BankAccount() {
		pin = 1738;
		balance = 0;
		failedAttempts = 0;
		isLocked = false;
	}
	
	// Parameterized constructor
	public BankAccount(int pin, double balance, int failedAttempts, boolean isLocked) {
		this.pin = pin;
		this.balance = balance;
		this.failedAttempts = failedAttempts;
		this.isLocked = isLocked;
	}
	
	// Deposit method
	public void deposit(double amount) {
		if (isLocked) {
			System.out.println("Account Locked. Please contact the bank.");
		} else {
			balance += amount;
			System.out.println("Successfully deposited $" + amount);
		}
	}
	
	// View balance method
	public double viewBalance() {
		return balance;
	}
	
	// Change PIN method
	public void setPIN(int newPin) {
		this.pin = newPin;
		System.out.println("PIN successfully changed.");
	}
	
	// Withdraw method
	public boolean withdraw(int enteredPin, double amount) {
		if (isLocked) {
			System.out.println("Account is locked.");
			return false;
		}
		
		// Check PIN
		if (enteredPin != this.pin) {
			failedAttempts += 1;
			System.out.println("Incorrect PIN.");
			if (failedAttempts >= 3) {
				isLocked = true;
				System.out.println("TOO MANY ATTEMPTS: Account is now locked.");
			}
			return false;
		}
		
		// Check balance if PIN is correct
		if (amount > balance) {
			System.out.println("Insufficient Funds");
			return false;
		}
		
		if ((enteredPin == this.pin) && (amount <= balance)) {
			failedAttempts = 0;
			balance -= amount;
			System.out.println("Withdrawal successful.");
			return true;
		}
		
		return isLocked;
	}

	public static void main(String[] args) {
		// Prompt for user input
		Scanner scnr = new Scanner(System.in);
		
		// Create bank account object
		BankAccount bankAccount = new BankAccount();
		
		// Prompt user to enter password
		System.out.print("Enter your PIN to login: ");
		int loginPin = scnr.nextInt();
		
		int userChoice = 0;
		
		if (loginPin == bankAccount.pin) {
			while (userChoice != 5) {
				System.out.println("\n--- Bank Menu ---");
                System.out.println("1: Deposit");
                System.out.println("2: Withdraw");
                System.out.println("3: View Balance");
                System.out.println("4: Change PIN");
                System.out.println("5: Exit");
                System.out.print("Selection: ");
                
                // Prompt user for choice
    			userChoice = scnr.nextInt();
    			
    			if (userChoice == 1) {
    				System.out.print("Enter amount to deposit: ");
    				double amount = scnr.nextDouble();
    				
    				// Deposit user entered amount 
    				bankAccount.deposit(amount);
    				
    			} else if (userChoice == 2) {
    				System.out.print("Re-enter your PIN: ");
    				int enteredPin = scnr.nextInt();
    				
    				System.out.print("Amount to withdraw: ");
    				int amount = scnr.nextInt();
    				
    				// Withdraw user entered amount 
    				bankAccount.withdraw(enteredPin, amount);
    				
    			} else if (userChoice == 3) {
    				System.out.println("Current Balance: $" + bankAccount.viewBalance());
    			
    			} else if (userChoice == 4) {
    				int newPin = 0;
    				System.out.print("Enter new PIN: ");
    				newPin = scnr.nextInt();
    				bankAccount.setPIN(newPin);				
    			}
				
			}
			System.out.println("Thanks for using our ATM.");
		}
		else {
			System.out.println("Wrong PIN. Failed to login.");
		}		
	}
}
