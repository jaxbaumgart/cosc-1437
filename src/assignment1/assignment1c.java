package assignment1;
import java.util.Scanner;

public class assignment1c {
    public static void main(String[] args) {
        // Declare scanner.
        Scanner in = new Scanner(System.in);
        
        // Ask user for amount.
        System.out.print("How much money do I owe you? >> ");
        double amount = in.nextDouble();
        System.out.println();
        
        // Declare bill denominations.
        int hundreds = 0;
        int fifties = 0;
        int twenties = 0;
        int tens = 0;
        int fives = 0;
        int ones = 0;
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        int pennies = 0;
        
        // Calculate number of bills, coins needed.
        while (amount / 100 >= 1) {
            hundreds++;
            amount -= 100;
        }
        while (amount / 50 >= 1) {
            fifties++;
            amount -= 50;
        }
        while (amount / 20 >= 1) {
            twenties++;
            amount -= 20;
        }
        while (amount / 10 >= 1) {
            tens++;
            amount -= 10;
        }
        while (amount / 5 >= 1) {
            fives++;
            amount -= 5;
        }
        while (amount / 1 >= 1) {
            ones++;
            amount -= 1;
        }
        while (amount / 0.25 >= 1) {
            quarters++;
            amount -= 0.25;
        }
        while (amount / 0.1 >= 1) {
            dimes++;
            amount -= 0.1;
        }
        while (amount / 0.05 >= 1) {
            nickles++;
            amount -= 0.05;
        }
        while (amount / 0.01 >= 1) {
            pennies++;
            amount -= 0.01;
        }
        
        // Print denominations
        System.out.println("You will be paid in these denominations:");
        System.out.println("Hundred Dollar Bills: " + hundreds);
        System.out.println("Fifty Dollar Bills: " + fifties);
        System.out.println("Twenty Dollar Bills: " + twenties);
        System.out.println("Ten Dollar Bills: " + tens);
        System.out.println("Five Dollar Bills: " + fives);
        System.out.println("One Dollar Bills: " + ones);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickles: " + nickles);
        System.out.println("Pennies: " + pennies);
    }
}
