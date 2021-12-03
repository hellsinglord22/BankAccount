package Moataz2051710628;

import java.io.BufferedReader;
import java.io.IOException;

public class Bank {

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
        System.out.println(newAccount);
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

    public static void depositIntoAccount(BufferedReader br) throws IOException {

        System.out.print("Enter your national id: ");
        String holderId = br.readLine();

        // search for the account
        // if there is an account
        // check the count of the transactions related to that account if 3 print an error
        // if not create transaction then add it to the transactions array

    }
}
