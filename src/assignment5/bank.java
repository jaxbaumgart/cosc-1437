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
        Scanner sscanner = new Scanner(System.in);
        Scanner iscanner = new Scanner(System.in);

        // Selection variable.
        int selection = 11;
        String menu;

        // Main loop.
        while (selection != 0) {
            // Main menu.
            System.out.println("====================================================");
            System.out.println("| Bank Of Eastfield System Menu");
            System.out.println("| Make A Selection");
            System.out.println("| ");
            System.out.println("| 1 Show Bank Information");
            System.out.println("| 2 Print All Checking Accounts");
            System.out.println("| 3 Deposit Money");
            System.out.println("| 4 Withdraw Money");
            System.out.println("| 5 Print All Loan Accounts");
            System.out.println("| 6 Make New Loan");
            System.out.println("| 7 Make Loan Payment");
            System.out.println("| 8 Add Customer");
            System.out.println("| 9 Delete Customer");
            System.out.println("| 0 Exit System");
            System.out.println("====================================================");
            System.out.print("| Selection >> ");
            selection = in.nextInt();
            System.out.println();
            // Show bank info.
            if (selection == 1) {
                System.out.println("====================================================");
                System.out.println("| Show Bank Information");
                System.out.println("| ");
                System.out.println("| Total Bank Balance " + Check.get(0).BankBalance);
                System.out.println("| Total Bank Customers " + Check.get(0).NumberCustomers);
                System.out.println("====================================================");
            // Print all checking accounts.
            } else if (selection == 2) {
                // TODO: Fix table alignment.
                System.out.println("====================================================");
                System.out.println("| Show All Checking Accounts");
                System.out.println("| ");
                System.out.println("| Rec\tName\tBalance\tTransactions");
                System.out.println("------------------------------------------------");
                for (int i=0; i<Check.size(); i++)
                {
                    System.out.println ("| " + i + "\t" + Check.get(i).GetLName() + ", " + Check.get(i).GetFName() + "\t" + Check.get(i).getCheckingBalance() + "\t" + Check.get(i).CustomerTransactions);
                }
                System.out.println("====================================================");
            // Deposit money.
            } else if (selection == 3) {
                System.out.println("====================================================");
                System.out.println("| Make a Deposit");
                System.out.println("| ");
                System.out.print("| Enter Record Number >> ");
                int recNum = in.nextInt();
                System.out.print("| Enter Deposit Amount >> ");
                double depositAmount = in.nextDouble();
                Check.get(recNum).Deposit(depositAmount);
                System.out.println("| ");
                System.out.println("| Deposit Successful");
                System.out.println("| " + Check.get(recNum).GetLName() + ", " + Check.get(recNum).GetFName() + " now has $" + Check.get(recNum).getCheckingBalance());
                System.out.println("====================================================");
            // Withdraw money.
            } else if (selection == 4) {
                System.out.println("====================================================");
                System.out.println("| Make a Withdraw");
                System.out.println("| ");
                System.out.print("| Enter Record Number >> ");
                int recNum = in.nextInt();
                System.out.print("| Enter Withdraw Amount >> ");
                double withdrawAmount = in.nextDouble();
                System.out.println("| ");
                System.out.println("| Withdraw Successful");
                Check.get(recNum).Withdraw(withdrawAmount);
                System.out.println("| Amount Withdrawn is $" + withdrawAmount);
                System.out.println("| " + Check.get(recNum).GetLName() + ", " + Check.get(recNum).GetFName() + " now has $" + Check.get(recNum).getCheckingBalance());
                System.out.println("====================================================");
            // Print all loan accounts.
            } else if (selection == 5) {
                // TODO: Fix table alignment.
                System.out.println("====================================================");
                System.out.println("| Show All Loan Accounts");
                System.out.println("| ");
                System.out.println("| Rec\tName\tBalance\tTransactions");
                System.out.println("------------------------------------------------");
                for (int i=0; i<Loan.size(); i++)
                {
                    System.out.println ("| " + i + "\t" + Loan.get(i).GetLName() + ", " + Loan.get(i).GetFName() + "\t" + Loan.get(i).getLoanBalance() + "\t" + Loan.get(i).CustomerTransactions);
                }
                System.out.println("====================================================");
            // Make new loan.
            } else if (selection == 6) {
                System.out.println("====================================================");
                System.out.println("| Make New Loan");
                System.out.println("| ");
                System.out.print("| Enter Record Number >> ");
                int recNum = in.nextInt();
                System.out.print("| Enter Loan Amount >> ");
                double loanAmount = in.nextDouble();
                Loan.get(recNum).MakeLoan(loanAmount);
                System.out.println("| ");
                System.out.println("| Loan Creation Successful");
                System.out.println("| " + Loan.get(recNum).GetLName() + ", " + Loan.get(recNum).GetFName() + " loan balance is now $" + Loan.get(recNum).getLoanBalance());
                System.out.println("====================================================");
            // Make loan payment.
            } else if (selection == 7) {
                System.out.println("====================================================");
                System.out.println("| Make Loan Payment");
                System.out.println("| ");
                System.out.print("| Enter Record Number >> ");
                int recNum = in.nextInt();
                System.out.print("| Enter Payment Amount >> ");
                double paymentAmount = in.nextDouble();
                System.out.println("| ");
                System.out.println("| Payment Successful");
                Loan.get(recNum).MakePayment(paymentAmount);
                System.out.println("| Payment Amount is $" + paymentAmount);
                System.out.println("| " + Loan.get(recNum).GetLName() + ", " + Loan.get(recNum).GetFName() + " loan balance is now $" + Loan.get(recNum).getLoanBalance());
                System.out.println("====================================================");
            // Add customer.
            } else if (selection == 8) {
                int innerSelection = 0;
                System.out.println("====================================================");
                System.out.println("| Add Customer");
                System.out.println("| Make A Selection");
                System.out.println("| ");
                System.out.println("| 1 Checking Customer");
                System.out.println("| 2 Loan Customer");
                System.out.println("====================================================");
                System.out.print("| Selection >> ");
                innerSelection = in.nextInt();
                System.out.println();
                if (innerSelection == 1) {
                    System.out.println("====================================================");
                    System.out.println("| Add Checking Customer");
                    System.out.println("| ");
                    System.out.print("| Enter Last Name >> ");
                    String lastName = sscanner.nextLine();
                    System.out.print("| Enter First Name >> ");
                    String firstName = sscanner.nextLine();
                    System.out.print("| Enter Email >> ");
                    String email = sscanner.nextLine();
                    System.out.print("| Enter Opening Amount >> ");
                    double openingAmount = sscanner.nextDouble();
                    System.out.println("| ");
                    Check.add(new CheckingAccount(lastName, firstName, email, openingAmount));
                    System.out.println("| Account Creation Successful");
                    System.out.println("| Checking Record Number " + (Check.size() - 1));
                    System.out.println("| Customer " + Check.get(Check.size() - 1).GetLName() + ", " + Check.get(Check.size() - 1).GetFName());
                    System.out.println("| Email " + Check.get(Check.size() - 1).GetEmail());
                    System.out.println("| Balance $" + Check.get(Check.size() - 1).getCheckingBalance());
                    System.out.println("====================================================");
                }
                if (innerSelection == 2) {
                    System.out.println("====================================================");
                    System.out.println("| Add Loan Customer");
                    System.out.println("| ");
                    System.out.print("| Enter Last Name >> ");
                    String lastName = sscanner.nextLine();
                    System.out.print("| Enter First Name >> ");
                    String firstName = sscanner.nextLine();
                    System.out.print("| Enter Email >> ");
                    String email = sscanner.nextLine();
                    System.out.print("| Enter Opening Amount >> ");
                    double openingAmount = sscanner.nextDouble();
                    System.out.println("| ");
                    Loan.add(new LoanAccount(lastName, firstName, email, openingAmount));
                    System.out.println("| Account Creation Successful");
                    System.out.println("| Account Details Below");
                    System.out.println("| Loan Record Number " + (Loan.size() - 1) + " for customer " + Loan.get(Loan.size() - 1).GetLName() + ", " + Loan.get(Loan.size() - 1).GetFName() + " with email " + Loan.get(Loan.size() - 1).GetEmail() + " and balance $" + Loan.get(Loan.size() - 1).getLoanBalance());
                    System.out.println("====================================================");
                }
            // Delete customer.
            } else if (selection == 9) {
                int innerSelection = 0;
                System.out.println("====================================================");
                System.out.println("| Delete Customer");
                System.out.println("| Make A Selection");
                System.out.println("| ");
                System.out.println("| 1 Checking Customer");
                System.out.println("| 2 Loan Customer");
                System.out.println("====================================================");
                System.out.print("| Selection >> ");
                innerSelection = in.nextInt();
                System.out.println();
                if (innerSelection == 1) {
                    System.out.println("====================================================");
                    System.out.println("| Delete Checking Customer");
                    System.out.println("| ");
                    System.out.print("| Enter Record Number >> ");
                    int recNum = iscanner.nextInt();
                    System.out.println("| ");
                    System.out.println("| Account Information");
                    System.out.println("| Checking Record Number " + recNum);
                    System.out.println("| Customer " + Check.get(recNum).GetLName() + ", " + Check.get(recNum).GetFName());
                    System.out.println("| Email " + Check.get(recNum).GetEmail());
                    System.out.println("| Balance $" + Check.get(recNum).getCheckingBalance());
                    System.out.println("| ");
                    System.out.print("| Confirm Account Deletion Y/N >> ");
                    String delete = sscanner.nextLine().toUpperCase();
                    if (delete.equals("Y")) {
                        Check.remove(recNum);
                        System.out.println("| ");
                        System.out.println("| Account Deletion Successful");
                    } else {
                        System.out.println("| ");
                        System.out.println("| Account Deletion Failed");
                    }
                    System.out.println("====================================================");
                }
                if (innerSelection == 2) {
                    System.out.println("====================================================");
                    System.out.println("| Delete Loan Customer");
                    System.out.println("| ");
                    System.out.print("| Enter Record Number >> ");
                    int recNum = iscanner.nextInt();
                    System.out.println("| ");
                    System.out.println("| Account Information");
                    System.out.println("| Loan Record Number " + recNum);
                    System.out.println("| Customer " + Loan.get(recNum).GetLName() + ", " + Loan.get(recNum).GetFName());
                    System.out.println("| Email " + Loan.get(recNum).GetEmail());
                    System.out.println("| Balance $" + Loan.get(recNum).getLoanBalance());
                    System.out.println("| ");
                    System.out.print("| Confirm Account Deletion Y/N >> ");
                    String delete = sscanner.nextLine().toUpperCase();
                    if (delete.equals("Y")) {
                        Loan.remove(recNum);
                        System.out.println("| ");
                        System.out.println("| Account Deletion Successful");
                    } else {
                        System.out.println("| ");
                        System.out.println("| Account Deletion Failed");
                    }
                    System.out.println("====================================================");
                }
            // Exit system.
            } else if (selection == 0) {
                System.out.println("====================================================");
                System.out.println("| System Exit Successful");
                System.out.println("====================================================");
            // Prints error message if selection invalid.
            } else {
                System.out.println("====================================================");
                System.out.println("| Invalid Selection");
                System.out.println("| ");
                System.out.println("| Please Make A Valid Selection");
                System.out.println("====================================================");
                System.out.println();
            // Waits for user before returning to main menu.
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

   // Getters
    public double getCheckingBalance() {
        return CheckingBalance;
    }

    public String GetFName() {
        return FName;
    }

    public String GetLName() {
        return LName;
    }

    public String GetEmail() {
        return Email;
    }

    // Adds deposit to customer account, total bank balance, transaction up by 1.
    void Deposit(double Amount) {
        CheckingBalance += Amount;
        CustomerTransactions++;
        BankBalance += Amount;
    }

    // Deducts deposit from customer account, total bank balance, transaction up by 1.
    void Withdraw(double Amount) {
        // If customer does not have sufficient balance, $25 fee and notifies user.
        if (CheckingBalance - Amount < 0.00) {
            CheckingBalance -= 25;
            System.out.println("| Overdraft fee of $25.0 Assessed");
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

    // Getters
    public double getLoanBalance() {
        return LoanBalance;
    }

    public String GetFName() {
        return FName;
    }

    public String GetLName() {
        return LName;
    }

    public String GetEmail() {
        return Email;
    }

    // Adds loan to customer account, total bank balance, transaction up by 1.
    void MakeLoan(double Amount) {
        LoanBalance += Amount * 1.25;
        CustomerTransactions++;
        BankBalance -= Amount * 1.25;
    }

    // Adds deducts loan from customer account, total bank balance, transaction up by 1.
    void MakePayment(double Amount) {
        LoanBalance -= Amount;
        // If loan balance zero, notify user.
        if (LoanBalance <= 0) {
            System.out.println("| Loan fully paid off. No further payments required.");
        }
        CustomerTransactions++;
        BankBalance += Amount;
    }
}