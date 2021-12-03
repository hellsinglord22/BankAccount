package BankAccount.Moataz2051710628;

public class Withdraw extends Transaction {

    public Withdraw(Account target, float amount) {
        super(target, amount);
        if (target.canWithdraw(amount)) {
            target.withdrawAmount(amount);
            super.setStatus(true);
        } else {
            super.setStatus(false);
        }
    }

    @Override
    public String toString() {
        return "Withdraw from: " + super.targetAccount.getAccountId() + "\n" +
               super.toString() + "\n" +
               "Type: WITHDRAW";
    }
}
