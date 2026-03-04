import java.util.Scanner;

public class ReplaceNegatives {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        final int MAX_NUM;
        int[] userNumbers;
        int i;

        // Ask user for input
        System.out.println("How many numbers do you want stored in array: (e.g 8, 5 or 1) ");
        MAX_NUM = scnr.nextInt();

        // Create array with user defined size
        userNumbers = new int[MAX_NUM];

        // Prompt user to enter int to store in each array position
        for (i = 0; i < userNumbers.length; ++i) {
            System.out.println("Enter value for position " + (i + 1) + ".");
            userNumbers[i] = scnr.nextInt();
        }

        // Convert negatives to zero
        for (i = 0; i < userNumbers.length; ++i) {
            if (userNumbers[i] < 0) {
                userNumbers[i] = 0;
            }
        }

        // Print results to console
        for (i = 0; i < userNumbers.length; ++i) {
            System.out.println("You entered the following numbers: ");
            for (i = 0; i < userNumbers.length; ++i) {
                System.out.println("In position " + (i + 1) + ", you entered " + userNumbers[i]);
            }
        }
    }
}