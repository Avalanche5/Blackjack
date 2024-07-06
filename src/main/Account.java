package main;

public class Account {
    private int balance = 10;

    public int gain(int amt) {
        balance += amt;
        return balance;
    }
    public int lose(int amt) {
        balance -= amt;
        return balance;
    }
}
