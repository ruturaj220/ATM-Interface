import java.util.*;

public class Atm
{
    private static double balance = 1000.0; // Initial account balance
    private static final int uid=4321;// Userid
    private static final int pi=1234;// User PIN

    private static String transactionHistory = "";

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the User id");
        int id=scanner.nextInt();
        System.out.println("Enter the Secret PIN");
        int pins=scanner.nextInt();

        if(uid==id && pi==pins)
        {
            while (true)
            {
                System.out.println("ATM Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Transfer");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println(transactionHistory);
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        else
        {
            System.out.println("Invalid UserID or PIN");
        }
    }

    private static void deposit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the Secret Pin");
        int pin = scanner.nextInt();
        if(pin==pi)
        {
            if (amount > 0)
            {
                balance += amount;
                System.out.println("Deposit successful. Current balance: Rs" + balance);
                transactionHistory += "Deposit successful. Current balance: Rs" + balance +"\n";
            }
            else
            {
                System.out.println("Invalid amount. Please enter a positive amount.");
                transactionHistory += "Invalid amount. Please enter a positive amount.\n";
            }
        }
        else
        {
            System.out.println("invalid pin");
        }
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the Secret Pin");
        int pin = scanner.nextInt();
        if(pin==pi)
        {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Current balance: Rs" + balance);
                transactionHistory += "Withdrawal successful. Current balance: Rs" + balance +"\n";
            } else if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive amount.");
            } else {
                System.out.println("Insufficient balance. Current balance: Rs" + balance);
            }
        }
        else
        {
            System.out.println("invalid pin");
        }
        // scanner.close();
    }

    private static void checkBalance()
    {
        System.out.println("Current balance: Rs" + balance);
    }
    private static void transfer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the account number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the amount ");
        double amount=scanner.nextDouble();
        System.out.print("Enter the Secret Pin");
        int pin = scanner.nextInt();
        if(pin==pi)
        {
            if (amount > 0 && amount <= balance)
            {
                balance -= amount;
                System.out.println("Transfer successful.Account No.:"+a+ "Current balance: Rs" + balance);
            }
            else if (amount <= 0)
            {
                System.out.println("Invalid amount. Please enter a positive amount.");
            }
            else
            {
                System.out.println("Insufficient balance. Current balance: Rs" + balance);
            }
        }
        else
        {
            System.out.println("invalid pin");
        }
    }
}
