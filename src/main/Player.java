package main;

public class Player {
    public String name;
    public Hand hand = new HandImpl();
    public int bet;
    private Account account = new Account();

    public Player(String _name) {
        name = _name;
    }

    public int doubleDown() {
        bet *= 2;
        return bet;
    }
    public int surrender() {
        bet *= 0.5;
        account.lose(bet);
        return bet;
    }
}
