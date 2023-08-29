package assignment5;
import java.util.*;

public class bank {
    public static void main(String[] args) {
        // Declare accounts.
        ArrayList<CheckingAccount> Check = new ArrayList<CheckingAccount>();
        Check.add(new CheckingAccount("Kirk","David","dkirk@dcccd.edu",10000.0));
        Check.add(new CheckingAccount("Spock","Mister","tribbles@starfleet.gov",500.0));
        Check.add(new CheckingAccount("Scott","Hulu","hulu@aol.com",75.0));

        ArrayList<LoanAccount> Loan = new ArrayList<LoanAccount>();
        Loan.add(new LoanAccount("Zeus","Apollo","apollo@gmail.com",5000));
        Loan.add(new LoanAccount("Einstein","Amy","amy@yahoo.com",1000));
        Loan.add(new LoanAccount("Caesar","Julie","julie@hotmail.com",500));

        // Scanner
        Scanner in = new Scanner(System.in);
        Scanner next = new Scanner(System.in);

        // Selection variable.
        int selection = 11;
        String menu;

        while (selection != 0) {
            // Main loop.
            System.out.println("====================================================");
            System.out.println("| Bank of Eastfield System Menu");
            System.out.println("| Make a Selection");
            System.out.println("| ");
            System.out.println("| 1 Show Bank Information");
            System.out.println("| 2 Print All Checking Accounts");
            System.out.println("| 3 Deposit Money");
            System.out.println("| 4 Withdraw Money");
            System.out.println("| 5 Print All Loan Accounts");
            System.out.println("| 6 Make Loan");
            System.out.println("| 7 Make Payment");
            System.out.println("| 8 Add Customer");
            System.out.println("| 9 Delete Customer");
            System.out.println("| 0 Exit System");
            System.out.println("====================================================");
            System.out.print("| Selection >> ");
            selection = in.nextInt();
            System.out.println();

            if (selection == 1) {
                System.out.println("====================================================");
                System.out.println("| Bank Information");
                System.out.println("| ");
                System.out.println("| Total Bank Balance " + Check.get(0).BankBalance);
                System.out.println("| Total Bank Customers " + Check.get(0).NumberCustomers);
                System.out.println("====================================================");
            } else if (selection == 2) {
                // TODO: Option 2
            } else if (selection == 3) {
                // TODO: Option 3
            } else if (selection == 4) {
                // TODO: Option 4
            } else if (selection == 5) {
                // TODO: Option 5
            } else if (selection == 6) {
                // TODO: Option 6
            } else if (selection == 7) {
                // TODO: Option 7
            } else if (selection == 8) {
                // TODO: Option 8
            } else if (selection == 9) {
                // TODO: Option 9
            } else if (selection == 0) {
                System.out.println("====================================================");
                System.out.println("| System Exit Successful");
                System.out.println("====================================================");
            } else {
                System.out.println("====================================================");
                System.out.println("| Invalid Selection");
                System.out.println("| ");
                System.out.println("| Please Make Another Selection");
                System.out.println("====================================================");
                System.out.println();
            }
            if (selection >= 1 && selection <= 9) {
                System.out.print("| Press Enter to Return to System Menu >> ");
                menu = next.nextLine();
                System.out.println();
            }
        }
    }
}

class Customer {
    // Variables
    String FName;
    String LName;
    String Email;
    int CustomerTransactions;
    static double BankBalance;
    static int NumberCustomers;

}

class CheckingAccount extends Customer {
    // Variables
    private double CheckingBalance;

    // Constructor
    CheckingAccount(String theLName, String theFName, String theEmail, double OpeningDeposit) {
        // Initialize customer info.
        LName = theLName;
        FName = theFName;
        Email = theEmail;
        CheckingBalance = OpeningDeposit;

        // Update bank info.
        BankBalance += OpeningDeposit;
        NumberCustomers++;
    }

    // Methods
    public double getCheckingBalance() {
        return CheckingBalance;
    }

    void Deposit(double Amount) {
        CheckingBalance += Amount;
        CustomerTransactions++;
        BankBalance += Amount;
    }

    void Withdraw(double Amount) {
        if (CheckingBalance - Amount < 0.00) {
            CheckingBalance -= 25;
        }
        CheckingBalance -= Amount;
        CustomerTransactions++;
        BankBalance -= Amount;
    }
}

class LoanAccount extends Customer {
    // Variables
    private double LoanBalance;

    // Constructor
    LoanAccount(String theLName, String theFName, String theEmail, double OpeningLoan) {
        // Initialize customer info.
        LName = theLName;
        FName = theFName;
        Email = theEmail;
        LoanBalance = OpeningLoan * 1.25;

        // Update bank info.
        BankBalance -= LoanBalance;
        NumberCustomers++;
    }

    // Methods
    public double getLoanBalance() {
        return LoanBalance;
    }

    void MakeLoan(double Amount) {
        LoanBalance += Amount * 1.25;
        CustomerTransactions++;
        BankBalance -= Amount * 1.25;
    }

    void MakePayment(double Amount) {
        LoanBalance -= Amount;
        if (LoanBalance <= 0) {
            System.out.println("Your loan has been paid off.");
        }
        CustomerTransactions++;
        BankBalance += Amount;
    }
}