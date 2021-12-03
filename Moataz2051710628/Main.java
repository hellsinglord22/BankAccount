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

                if (commandId == 1) {
                    Bank.createAccount(br);
                } else if (commandId == 2) {
                    Bank.depositIntoAccount(br);
                }

                String continueRunning = br.readLine();
            } catch (IOException error) {
                break;
            }

        } while (true);


    }

    private static void printCommands() {
        System.out.println("Please choose an option");
        System.out.println("=========================");
        System.out.println("1: Create new account");
        System.out.println("2: Deposit money into account");
        System.out.println("3: Withdraw money from account");
        System.out.println("4: Transfer money between accounts");
        System.out.println("5: Print details of a transactions");
        System.out.println("5: Print details of a transactions");
        System.out.println("5: Saving all accounts and transactions");
    }

}
