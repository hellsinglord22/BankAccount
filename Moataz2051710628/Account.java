package BankAccount.Moataz2051710628;

public class Account {

    private Holder customer;
    private float balance;

    public Account(Holder customer, float balance) {
        this.customer = customer;
        this.balance = balance;
    }

    public void depositAmount (float amount) {
       this.balance += amount;
    }

    public boolean canWithdraw (float amount) {
        return balance - amount >= 0;
    }

    public void withdrawAmount (float amount) {
        this.balance -= amount;
    }

    public String getAccountId() {
        return "ac_" + this.customer.getClientId();
    }

    public boolean isEqualTo (String id) {
        return getAccountId().equals("ac_" + id);
    }

    @Override
    public String toString() {
        return "account number = " + this.getAccountId() + "\n" +
               "name = " + customer.getName() + "\n" +
               "age  = " + customer.getAge() + "\n" +
               "balance = " + balance;
    }
}
