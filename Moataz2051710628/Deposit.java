package BankAccount.Moataz2051710628;

public class Deposit extends Transaction {

    public Deposit(Account target, float amount) {
        super(target, amount);
        target.depositAmount(amount);
        super.setStatus(true);
    }

    @Override
    public String toString() {
        return "Deposit to: " + super.targetAccount.getAccountId() + "\n" +
               super.toString() + "\n" +
               "Type: DEPOSIT";
    }
}
