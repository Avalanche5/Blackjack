package main;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1 = new HandImpl();
        makePlayer(player1, deck);
        System.out.println("total value: " + player1.getTotalValue());
        System.out.println("hand: " + player1.getCards());

        Scanner sc = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("HIT (h) or STAND (s)?");
            String choice = sc.nextLine();
            if (choice.equals("h")) {
                Card cardDrawn = deck.draw();
                player1.addCard(cardDrawn);
                System.out.println("you chose to hit and drew a " + cardDrawn + "!");
                System.out.println("total value: " + player1.getTotalValue());
                System.out.println("hand: " + player1.getCards());
                System.out.println();

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
            }

//            if (choice.equals("s")) {
            else if (choice.equals("s")) {
                System.out.println("you chose to stand!");
                System.out.println("total value: " + player1.getTotalValue());
                System.out.println("hand: " + player1.getCards());
                System.out.println();
                loop = false;
            }

//            if (!choice.equals("s") && !choice.equals("h")) {
            else {
                System.out.println("invalid response...");
            }
        }


//        player1.addCard(deck.draw());

//        main.HandImpl player2 = new main.HandImpl();

    }
    public static void makePlayer(Hand player, Deck deck){
        player.addCards(deck.draw(2));


//        Card ace1 = new Card("hearts", "Ace", 11);
//        main.Card ace1 = new main.Card("hearts", "Ace", 11);
//        player.addCard(ace1);
//        main.Card ace2 = new main.Card("diamonds", "Ace", 11);
//        player.addCard(ace2);
    }

}