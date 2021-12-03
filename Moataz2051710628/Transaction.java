package moataz2051710628;

public class Transaction {
    private Account from;
    private Account to;
    private float amount;
    private String type;
    private String state;

    public Transaction(Account from, Account to, float amount, String type, String state) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.type = type;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "From=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
