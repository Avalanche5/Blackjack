public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1 = new HandImpl();
        makePlayer(player1, deck);
        System.out.println("total value: " + player1.getTotalValue());
        System.out.println("hand: " + player1.getCards());
        System.out.println("HIT (h) or STAND (s)?");
//        player1.addCard(deck.draw());

//        HandImpl player2 = new HandImpl();

    }
    public static void makePlayer(Hand player, Deck deck){
        player.addCards(deck.draw(2));

//        player.addCard(deck.draw());
//        Card ace1 = new Card("hearts", "Ace", 11);
//        player.addCard(ace1);
//        Card ace2 = new Card("diamonds", "Ace", 11);
//        player.addCard(ace2);
    }

}