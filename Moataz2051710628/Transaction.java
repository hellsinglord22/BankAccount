package BankAccount.Moataz2051710628;

public class Transaction {

    protected Account targetAccount;
    protected float amount;
    protected String status;

    public Transaction(Account targetAccount, float amount) {
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount: " + this.amount + "\n" +
               "Status: " + this.status;
    }

    public void setStatus(boolean transactionSucceeded) {
        if (transactionSucceeded) {
            this.status = "SUCCESS";
        } else {
            this.status = "FAIL";
        }
    }
}
