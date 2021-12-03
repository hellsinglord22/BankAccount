package BankAccount.Moataz2051710628;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    protected Account targetAccount;
    protected float amount;
    protected String status;
    private final LocalDateTime created_at;
    private final DateTimeFormatter dtf;

    public Transaction(Account targetAccount, float amount) {
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        created_at = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Amount: " + this.amount + "\n" +
               "Status: " + this.status + "\n" +
               "Created at: " + dtf.format(created_at);
    }

    public void setStatus(boolean transactionSucceeded) {
        if (transactionSucceeded) {
            this.status = "SUCCESS";
        } else {
            this.status = "FAIL";
        }
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

}
