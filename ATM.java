import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATM(String accountNumber, String pin) {
        this.balance = 0.0;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("current balance = $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + "new balance = $" + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + "Your new balance is $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        ATM atm = new ATM(accountNumber, pin);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter your PIN: ");
                String enteredPin = scanner.next();

                if (enteredPin.equals(atm.pin)) {
                    System.out.println("Login successful!");
                    while (true) {
                        atm.displayMenu();
                        System.out.print("Enter your choice: ");
                        int option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                atm.checkBalance();
                                break;
                            case 2:
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmount = scanner.nextDouble();
                                atm.withdraw(withdrawAmount);
                                break;
                            case 3:
                                System.out.print("Enter amount to deposit: ");
                                double depositAmount = scanner.nextDouble();
                                atm.deposit(depositAmount);
                                break;
                            case 4:
                                System.out.println("Thank you");
                                System.exit(0);
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                } else {
                    System.out.println("Invalid PIN.");
                }
            } else if (choice == 2) {
                System.out.println("Thank you");
                System.exit(0);
            } else {
                System.out.println("Invalid choice,try again.");
            }
        }
    }
}
