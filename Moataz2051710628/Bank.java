package BankAccount.Moataz2051710628;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {

    private static final Account [] accounts = new Account[100];
    private static int accountIndex = 0;

    private static final Transaction [] transactions = new Transaction[600];
    private static int transactionIndex = 0;

    public static void createAccount(BufferedReader br) throws IOException {

        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        // check the account is not created
        if (findAccountById(clientId) != null) {
            System.err.println("This account is already created!");
        } else {
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            // Create new holder customer
            Holder customer = new Holder(clientId, name, age);
            Account newAccount = new Account(customer, 0);
            saveAccount(newAccount);

            // Print account
            System.out.println("\n" + newAccount);
        }
    }

    public static void depositToAccount(BufferedReader br) throws IOException {
        // get holder national id
        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        // find account by id
        Account target = findAccountById(clientId);

        // check if target account found
        if (target != null) {

            // get amount
            System.out.print("Enter amount: ");
            float amount = (float) Double.parseDouble(br.readLine());

            // save transaction to our collection
            Transaction newTransaction = new Deposit(target, amount);
            saveTransaction(newTransaction);

            // print result
            System.out.println(newTransaction);

        } else {
            System.err.println("Account not found!");
        }
    }

    public static void withdrawFromAccount(BufferedReader br) throws IOException {
        // get holder national id
        System.out.print("Enter your national id: ");
        String clientId = br.readLine();

        // find account by id
        Account target = findAccountById(clientId);
        if (target != null) {
            // Read amount from user
            System.out.print("Enter amount: ");
            float amount = (float) Double.parseDouble(br.readLine());

            // create withdraw transaction
            Transaction newTransaction = new Withdraw(target, amount);
            saveTransaction(newTransaction);

            //print transaction information
            System.out.println("\n" + newTransaction);
        } else {
            System.err.println("Account not found");
        }
    }

    public static void transferBetweenAccounts(BufferedReader br) throws IOException {
        // get source account id and validate it
        System.out.print("Enter source account social id: ");
        String sourceAccountId = br.readLine();
        Account sourceAccount = findAccountById(sourceAccountId);
        if (sourceAccount == null) {
            System.err.println("Account not found!!");
            return;
        }

        // get target account and validate it
        System.out.print("Enter target account social id: ");
        String targetAccountId = br.readLine();
        Account targetAccount = findAccountById(targetAccountId);
        if (targetAccount == null) {
            System.err.println("Account not found!!");
            return;
        }

        // get amount
        System.out.print("Enter the amount: ");
        int amount = Integer.parseInt(br.readLine());

        // create transaction
        Transaction newTransaction = new Transfer(sourceAccount, targetAccount, amount);
        saveTransaction(newTransaction);

        // print transaction
        System.out.println("\n" + newTransaction);
    }

    public static void printAccount(BufferedReader br) throws IOException {
        // read national id
        System.out.print("Enter account national id: ");
        String nationalId = br.readLine();

        Account account = findAccountById(nationalId);

        if (account != null) {
            System.out.println("\n" + account);
        } else {
            System.err.println("Account not found!");
        }
    }

    public static void printAccountTransactions (BufferedReader br) throws IOException {
        System.out.print("Enter national id: ");
        String nationalId = br.readLine();
        Account account = findAccountById(nationalId);
        if (account == null) {
            System.err.println("Account not found!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < transactionIndex; i++) {
            if (transactions[i].getTargetAccount().isEqualTo(nationalId)) {
                found = true;
                System.out.println(transactions[i]);
            }
        }
        if (!found) {
            System.err.println("No Transactions Found!");
        }
    }


    public static void printToFile() {
        FileWriter writer;
        try {
            writer = new FileWriter("data.txt", false);
        } catch(IOException error) {
            System.err.println("Error creating connection to data file");
            return;
        }
        try {
            // write accounts
            writer.write("ACCOUNTS\n");
            writer.write("========\n");
            for (int i = 0; i < accountIndex; i++) {
                writer.write(accounts[i].toString() + "\n");
                writer.write("------------\n");
            }
            writer.write("\n");
            writer.write("TRANSACTIONS\n");
            writer.write("============\n");
            for (int i = 0; i < transactionIndex; i++) {
                writer.write(transactions[i].toString() + "\n");
                writer.write("------------\n");
            }
            writer.close();

            System.out.println("DONE WRITING TO data.txt");
        }
        catch (IOException error) {
            System.err.println("Error writing!");
        }
    }


    // find account by id
    private static Account findAccountById (String nationalId) {
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].isEqualTo(nationalId)) {
                return accounts[i];
            }
        }
        return null;
    }

    //save account to accounts
    private static void saveAccount(Account newAccount) {
        if (accountIndex == 100) {
            System.err.println("Max account reached");
        }
        accounts[accountIndex] = newAccount;
        accountIndex++;
    }

    //save transaction to transactions
    private static void saveTransaction(Transaction newTransaction) {
        if (transactionIndex == 600) {
            System.err.println("Max transactions reached");
        }
        transactions[transactionIndex] = newTransaction;
        transactionIndex++;
    }

}
