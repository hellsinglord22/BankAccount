package BankAccount.Moataz2051710628;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //  Create buffer reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // print the command to the screen
        do {

            try {
                printCommands();

                System.out.print("Choose an option: ");
                int commandId = Integer.parseInt(br.readLine());

                // Switch between commands
                if (commandId == 1) {
                    Bank.createAccount(br);
                } else if (commandId == 2) {
                    Bank.depositToAccount(br);
                } else if (commandId == 3) {
                    Bank.withdrawFromAccount(br);
                } else if (commandId == 4) {
                    Bank.transferBetweenAccounts(br);
                } else if (commandId == 5) {
                    Bank.printAccount(br);
                } else if (commandId == 6) {
                    Bank.printAccountTransactions(br);
                } else if (commandId == 7) {
                    Bank.printToFile();
                } else {
                    break;
                }

                // Enter to continue
                br.readLine();

            } catch (IOException error) {

                // If error close the program
                break;
            }

        } while (true);

        //  close buffer reader
        br.close();

    }

    private static void printCommands() {
        System.out.println("Please choose an option");
        System.out.println("=========================");
        System.out.println("1: Create new account");
        System.out.println("2: Deposit money into account");
        System.out.println("3: Withdraw money from account");
        System.out.println("4: Transfer money between accounts");
        System.out.println("5: Print details of a account");
        System.out.println("6: Print account transactions");
        System.out.println("7: Saving all accounts and transactions");
        System.out.println("8: Exist");
    }

}
