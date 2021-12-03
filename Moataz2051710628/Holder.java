package BankAccount.Moataz2051710628;

public class Holder {
    private String clientId;
    private String name;
    private int age;

    public Holder(String clientId, String name, int age) {
        this.clientId = clientId;
        this.name = name;
        this.age = age;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Holder {" + "\n" +
                "\tclientId = " + clientId + ",\n" +
                "\tname = " + name + ",\n" +
                "\tage = " + age + ",\n" +
                "\t}";
    }
}
