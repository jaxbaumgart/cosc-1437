// Assignment 2c DONE
package assignment2;
import java.util.Scanner;

public class roman {
    public static void main(String[] args) {
        // Initialize scanner.
        Scanner in = new Scanner(System.in);
        // Ask user for roman numeral and feed into RomanToDecimal function; print result.
        System.out.print("Enter a roman numeral >> ");
        String roman = in.nextLine().toUpperCase();
        System.out.println(roman + " in decimal form is " + RomanToDecimal(roman) + ".");
    }

    public static int RomanToDecimal(String R) {
        // Decimal set to 0.
        int decimal = 0;
        // Check first digit without special cases to avoid exception.
        if (R.charAt(0) == 'M') {
                decimal += 1000;
        } if (R.charAt(0) == 'D') {
                decimal += 500;
        } if (R.charAt(0) == 'C') {
                decimal += 100;
        } if (R.charAt(0) == 'L') {
                decimal += 50;
        } if (R.charAt(0) == 'X') {
                decimal += 10;
        } if (R.charAt(0) == 'V') {
                decimal += 5;
        } if (R.charAt(0) == 'I') {
            decimal += 1;
        }
        // Check rest of digits with special cases.
        for (int i = 1; i < R.length(); i++) {
            if (R.charAt(i) == 'M') {
                if (R.charAt(i - 1) == 'C') {
                    decimal += 800;
                } else {
                    decimal += 1000;
                }
            } if (R.charAt(i) == 'D') {
                if (R.charAt(i - 1) == 'C') {
                    decimal += 300;
                } else {
                    decimal += 500;
                }
            } if (R.charAt(i) == 'C') {
                if (R.charAt(i - 1) == 'X') {
                    decimal += 80;
                } else {
                    decimal += 100;
                }
            } if (R.charAt(i) == 'L') {
                if (R.charAt(i - 1) == 'X') {
                    decimal += 30;
                } else {
                    decimal += 50;
                }
            } if (R.charAt(i) == 'X') {
                if (R.charAt(i - 1) == 'I') {
                    decimal += 8;
                } else {
                    decimal += 10;
                }
            } if (R.charAt(i) == 'V') {
                if (R.charAt(i - 1) == 'I') {
                    decimal += 3;
                } else {
                    decimal += 5;
                }
            } if (R.charAt(i) == 'I') {
                decimal += 1;
            }
        }
        // Return final decimal.
        return decimal;
    }
}
