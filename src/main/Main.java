package main;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1 = new HandImpl();
        makePlayer(player1, deck);
        System.out.println("total value: " + player1.getTotalValue());
        System.out.println("hand: " + player1.getCards());
        System.out.println("HIT (h) or STAND (s)?");
//        player1.addCard(deck.draw());

//        main.HandImpl player2 = new main.HandImpl();

    }
    public static void makePlayer(Hand player, Deck deck){
        player.addCards(deck.draw(2));

<<<<<<< HEAD:src/Main.java
//        player.addCard(deck.draw());
//        Card ace1 = new Card("hearts", "Ace", 11);
=======
//        main.Card ace1 = new main.Card("hearts", "Ace", 11);
>>>>>>> ea475b4 (restructured folders and added JUnit tests):src/main/Main.java
//        player.addCard(ace1);
//        main.Card ace2 = new main.Card("diamonds", "Ace", 11);
//        player.addCard(ace2);
    }

}