package BankAccount.Moataz2051710628;

public class Transfer extends Transaction{
    Account sourceAccount;

    public Transfer(Account sourceAccount, Account targetAccount, float amount) {
        // create transaction
        super(targetAccount, amount);
        this.sourceAccount = sourceAccount;

        // transfer from one account to another
        if (sourceAccount.canWithdraw(amount)) {
            sourceAccount.withdrawAmount(amount);
            targetAccount.depositAmount(amount);
            super.setStatus(true);
        } else {
            super.setStatus(false);
        }
    }

    @Override
    public String toString() {
        return "Withdraw from: " + sourceAccount.getAccountId() + "\n" +
               "Deposit from: " + super.targetAccount.getAccountId() + "\n" +
               super.toString() + "\n" +
               "Type: TRANSFER";
    }


}
