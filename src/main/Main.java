package main;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;

import java.io.InputStream;
import java.util.Scanner;

// todo: give option of playing again
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1 = new HandImpl();
        Hand dealer = new HandImpl();
        dealHand(player1, deck);     //deals a player 2 cards
        dealHand(dealer, deck);

        Card faceUpCard = dealer.getCards().get(0);

        System.out.println("total value: " + player1.getTotalValue());
        System.out.println("hand: " + player1.getCards());
        System.out.println("dealer: " + faceUpCard);
//        System.out.println("dealer total cards: " + dealer.getCards());
//        System.out.println("dealer total value: " + dealer.getTotalValue());
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        boolean busted = false;

        while (loop) {
            System.out.println("HIT (h) or STAND (s)?");
            String choice = sc.nextLine();
            if (choice.equals("h")) {
                Card cardDrawn = deck.draw();
                player1.addCard(cardDrawn);
                System.out.println("you chose to hit and drew a " + cardDrawn + "!");
                System.out.println("total value: " + player1.getTotalValue());
                System.out.println("hand: " + player1.getCards());
                if (player1.getTotalValue() > 21) {
                    System.out.println("you busted, you lose!");
                    loop = false;
                    busted = true;
                } else {
                    System.out.println();
                }
            } else if (choice.equals("s")) {
                System.out.println("you chose to stand!");
                System.out.println("total value: " + player1.getTotalValue());
                System.out.println("hand: " + player1.getCards());
                System.out.println();
                loop = false;
            } else {
                System.out.println("invalid response...");
            }
        }

        if (!busted) {
            System.out.println("dealer reveals hidden card: " + dealer.getCards());
            System.out.println("dealer total value: " + dealer.getTotalValue());
            while (dealer.getTotalValue() < 17) {
                Card cardDrawn = deck.draw();
                dealer.addCard(cardDrawn);
                System.out.println("dealer draws a " + cardDrawn);
                System.out.println("dealer total value: " + dealer.getTotalValue());
                if (dealer.getTotalValue() > 21) {
                    System.out.println("dealer busts!");
                }
            }
            int dealerFinalValue = dealer.getTotalValue();
            int playerFinalValue = player1.getTotalValue();

            if (dealerFinalValue > playerFinalValue && dealerFinalValue <= 21) {
                System.out.println();
                System.out.println("you lose!");
            }

            else if (dealerFinalValue == playerFinalValue && dealerFinalValue <= 21) {
                System.out.println();
                System.out.println("it's a draw!");
            }

            else {
                System.out.println();
                System.out.println("you win!");
            }
        }
    }
    public static void dealHand(Hand player, Deck deck){
        player.addCards(deck.draw(2));
    }
}



//        Card ace1 = new Card("hearts", "Ace", 11);
//        main.Card ace1 = new main.Card("hearts", "Ace", 11);
//        player.addCard(ace1);
//        main.Card ace2 = new main.Card("diamonds", "Ace", 11);
//        player.addCard(ace2);

/** NOTE: using StringBuilder is more efficient because it is mutable
 * Strings, however, are immutable,
 * so each '+' results in a new string creation
 *
 * StringBuilder sb = new StringBuilder();
 * sb.append("you chose to hit and drew a ").append(cardDrawn).append("!\n");
 * sb.append("total value: ").append(player1.getTotalValue()).append("\n");
 * sb.append("hand: ").append(player1.getCards()).append("\n");
 * sb.append("\n");
 * System.out.println(sb.toString());
 * */