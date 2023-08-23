// Assignment 2c DONE - not pretty lol
// TODO: Check for replacement for substring (CharAt throwing typeError)

package assignment2;
import java.util.Scanner;

public class roman {
    public static void main(String[] args) {
        // Initialize scanner.
        Scanner in = new Scanner(System.in);
        // Ask user for roman numeral and feed into RomanToDecimal function.
        System.out.print("Enter a roman numeral >> ");
        String roman = in.nextLine();
        System.out.println(roman + " in decimal form is " + RomanToDecimal(roman) + ".");
    }

    public static int RomanToDecimal(String R) {
        // Decimal set to 0.
        int decimal = 0;
        // Check first digit without special cases to avoid exception.
        if (R.substring(0, 1).equals("M")) {
                decimal += 1000;
        } if (R.substring(0, 1).equals("D")) {
                decimal += 500;
        } if (R.substring(0, 1).equals("C")) {
                decimal += 100;
        } if (R.substring(0, 1).equals("L")) {
                decimal += 50;
        } if (R.substring(0, 1).equals("X")) {
                decimal += 10;
        } if (R.substring(0, 1).equals("V")) {
                decimal += 5;
        } if (R.substring(0, 1).equals("I")) {
            decimal += 1;
        }
        // Check rest of digits with special cases.
        for (int i = 1; i < R.length(); i++) {
            if (R.substring(i, i + 1).equals("M")) {
                if (R.substring(i - 1, i).equals("C")) {
                    decimal += 800;
                } else {
                    decimal += 1000;
                }
            } if (R.substring(i, i + 1).equals("D")) {
                if (R.substring(i - 1, i).equals("C")) {
                    decimal += 300;
                } else {
                    decimal += 500;
                }
            } if (R.substring(i, i + 1).equals("C")) {
                if (R.substring(i - 1, i).equals("X")) {
                    decimal += 80;
                } else {
                    decimal += 100;
                }
            } if (R.substring(i, i + 1).equals("L")) {
                if (R.substring(i - 1, i).equals("X")) {
                    decimal += 30;
                } else {
                    decimal += 50;
                }
            } if (R.substring(i, i + 1).equals("X")) {
                if (R.substring(i - 1, i).equals("I")) {
                    decimal += 8;
                } else {
                    decimal += 10;
                }
            } if (R.substring(i, i + 1).equals("V")) {
                if (R.substring(i - 1, i).equals("I")) {
                    decimal += 3;
                } else {
                    decimal += 5;
                }
            } if (R.substring(i, i + 1).equals("I")) {
                decimal += 1;
            }
        }
        // Return final decimal.
        return decimal;
    }
}
