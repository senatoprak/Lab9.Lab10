class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amount) throws NotEnoughMoneyException {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            throw new NotEnoughMoneyException("Not enough funds in the account.");
        }
    }
}

class Main {
    public static void main(String[] args) {

        Account account1 = new Account("Maciej Majewski", 100, "099043");

        try {
            account1.withdrawal(150);
        }
        catch (NotEnoughMoneyException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        }
        finally {
            System.out.println("Final balance: " + account1.getBalance());
        }
    }
}
