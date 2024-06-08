public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1 = new HandImpl();
        makePlayer(player1, deck);
        System.out.println("hand: " + player1.getCards());
        System.out.println("total value: " + player1.getTotalValue());

//        HandImpl player2 = new HandImpl();

    }
    public static void makePlayer(Hand player, Deck deck){
//        player.addCard(deck.draw());
//        player.addCard(deck.draw());
        Card ace = new Card("hearts", "Ace", 11);
        player.addCard(ace);
        player.addCard(ace);
    }

}