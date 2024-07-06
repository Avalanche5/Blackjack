package main;

import main.types.UserResponse;

import java.util.Scanner;

// todo: give option of playing again
// todo: add player class, wagers, etc
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("What is your name?");
        String answer = sc.nextLine();
        Player player1 = new Player(answer);

        Player dealer = new Player("dealer");
        dealHand(player1.hand, deck);     // deals a player 2 cards
        dealHand(dealer.hand, deck);

        Card faceUpCard = dealer.hand.getCards().get(0);

        System.out.println("total value: " + player1.hand.getTotalValue());
        System.out.println("hand: " + player1.hand.getCards());
        System.out.println("dealer: " + faceUpCard);
//        System.out.println("dealer total cards: " + dealer.getCards());
//        System.out.println("dealer total value: " + dealer.getTotalValue());
        System.out.println();

        boolean busted = false;
        boolean loop = true;

        while (loop) {
            UserResponse decision = getDecision();
            String outcome = playYourTurn(player1.hand, deck, decision);
            // if the outcome is hit or invalid, the variables 'busted' and 'loop' dpn't change
            if (outcome.equals("stand")) {
                loop = false;
            } else if (outcome.equals("bust")) {
                loop = false;
                busted = true;
            }
        }

        if (!busted) {
            System.out.println("dealer reveals hidden card: " + dealer.hand.getCards());
            System.out.println("dealer total value: " + dealer.hand.getTotalValue());
            while (dealer.hand.getTotalValue() < 17) {
                Card cardDrawn = deck.draw();
                dealer.hand.addCard(cardDrawn);
                System.out.println("dealer draws a " + cardDrawn);
                System.out.println("dealer total value: " + dealer.hand.getTotalValue());
                if (dealer.hand.getTotalValue() > 21) {
                    System.out.println("dealer busts!");
                }
            }
            int dealerFinalValue = dealer.hand.getTotalValue();
            int playerFinalValue = player1.hand.getTotalValue();

            if (dealerFinalValue > playerFinalValue && dealerFinalValue <= 21) {
                System.out.println();
                System.out.println("you lose!");
            } else if (dealerFinalValue == playerFinalValue && dealerFinalValue <= 21) {
                System.out.println();
                System.out.println("it's a draw!");
            } else {
                System.out.println();
                System.out.println("you win!");
            }
        }
    }

    private static UserResponse getDecision() {
        System.out.println("HIT (h) or STAND (s)?");
        String answer = sc.nextLine();
        return switch (answer) {
            case "h" -> UserResponse.HIT;
            case "s" -> UserResponse.STAND;
            default -> UserResponse.INVALID;
        };
    }

    private static String playYourTurn(Hand player, Deck deck, UserResponse decision) {
//        System.out.println(print the players name);
        if (decision == UserResponse.HIT) {
            Card cardDrawn = deck.draw();
            player.addCard(cardDrawn);
            System.out.println("you chose to hit and drew a " + cardDrawn + "!");
            System.out.println("total value: " + player.getTotalValue());
            System.out.println("hand: " + player.getCards());
            if (player.getTotalValue() > 21) {
                System.out.println("you busted, you lose!");
                return "bust";
//                    loop = false;
//                    busted = true;
            } else {
                System.out.println();
                return "hit";
            }
        } else if (decision == UserResponse.STAND) {
            System.out.println("you chose to stand!");
            System.out.println("total value: " + player.getTotalValue());
            System.out.println("hand: " + player.getCards());
            System.out.println();
            return "stand";
//                loop = false;
        } else {
            System.out.println("invalid response...");
            return "invalid";
        }
    }

    public static void dealHand(Hand hand, Deck deck) {
        hand.addCards(deck.draw(2));
    }
}


//        Card ace1 = new Card("hearts", "Ace", 11);
//        main.Card ace1 = new main.Card("hearts", "Ace", 11);
//        player.addCard(ace1);
//        main.Card ace2 = new main.Card("diamonds", "Ace", 11);
//        player.addCard(ace2);

/**
 * NOTE: using StringBuilder is more efficient because it is mutable
 * Strings, however, are immutable,
 * so each '+' results in a new string creation
 * <p>
 * StringBuilder sb = new StringBuilder();
 * sb.append("you chose to hit and drew a ").append(cardDrawn).append("!\n");
 * sb.append("total value: ").append(player1.getTotalValue()).append("\n");
 * sb.append("hand: ").append(player1.getCards()).append("\n");
 * sb.append("\n");
 * System.out.println(sb.toString());
 */