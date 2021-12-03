package BankAccount.Moataz2051710628;

import java.io.BufferedReader;
import java.io.IOException;

public class Bank {

    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private static Account [] accounts = new Account[100];
    private static int currentAccount = 0;

    private static Transaction [] transactions = new Transaction[600];
    private static int currentTransaction = 0;

    public static void createAccount(BufferedReader br) throws IOException {

        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        // check the account is not created //
        for (int i = 0; i < currentAccount ; i++) {
            if (accounts[i].isEqualTo(clientId) ) {
                System.err.println("This account is already created !");
                return;
            }
        }

        System.out.print("Enter your name: ");
        String name = br.readLine();

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(br.readLine());

        // Create new holder customer
        Holder customer = new Holder(clientId, name, age);
        Account newAccount = new Account(customer, 0);
        saveAccount(newAccount);

        System.out.println();
        System.out.println("\n" + ANSI_CYAN + newAccount + ANSI_CYAN + "\n");
        System.out.println(ANSI_RESET);

    }

    public static void depositToAccount(BufferedReader br) throws IOException {

        // get holder national id
        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        Account target;
        for (int i = 0; i < currentAccount; i++) {
            if (accounts[i].isEqualTo(clientId)) {
                target = accounts[i];

                // Read amount from user
                System.out.print("Enter amount: ");
                float amount = (float) Double.parseDouble(br.readLine());

                Transaction newTransaction = new Deposit(target, amount);
                saveTransaction(newTransaction);

                System.out.println();
                System.out.println("\n" + ANSI_GREEN + newTransaction + ANSI_GREEN + "\n");
                System.out.println(ANSI_RESET);

                return;
            }
        }
        System.err.println("Account not found");
    }

    public static void withdrawFromAccount(BufferedReader br) throws IOException {
        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        Account target;
        for (int i = 0; i < currentAccount; i++) {
            if (accounts[i].isEqualTo(clientId)) {
                target = accounts[i];

                // Read amount from user
                System.out.print("Enter amount: ");
                float amount = (float) Double.parseDouble(br.readLine());

                Transaction newTransaction = new Withdraw(target, amount);
                saveTransaction(newTransaction);

                System.out.println();
                System.out.println("\n" + ANSI_GREEN + newTransaction + ANSI_GREEN + "\n");
                System.out.println(ANSI_RESET);

                return;
            }
        }
        System.err.println("Account not found");
    }

    private static void saveAccount(Account newAccount) {
        if (currentAccount == 100) {
            System.err.println("Max account reached");
        }
        accounts[currentAccount] = newAccount;
        currentAccount++;
    }

    private static void saveTransaction(Transaction newTransaction) {
        if (currentTransaction == 600) {
            System.err.println("Max transactions reached");
        }
        transactions[currentTransaction] = newTransaction;
        currentTransaction++;
    }

}
