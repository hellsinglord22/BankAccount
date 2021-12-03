package Moataz2051710628;

public class Account {

    private Holder customer;
    private float balance;

    public Account(Holder customer, float balance) {
        this.customer = customer;
        this.balance = balance;
    }

    public String getAccountId() {
        return "ac_" + this.customer.getClientId();
    }

    public boolean isEqualTo (String id) {
        return getAccountId().equals("ac_" + id);
    }

    @Override
    public String toString() {
        return "Account: {\n" +
                "\tcustomer = " + customer + ",\n" +
                "\tbalance = " + balance + ",\n" +
                "\taccount number = " + this.getAccountId() + ",\n" +
                '}';
    }
}
