package main;

import main.types.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        refreshDeck();
    }

    // todo: this method needs testing
    public void refreshDeck() {
        Suit[] suits = {Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, Suit.CLUBS};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        //        todo: make rank enum
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
        for (Suit suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {    // if cards list (deck) has at least 1 card in it...
            refreshDeck();
        }
        return cards.remove(0);
    }
    public Card[] draw(int numOfCards) {
        int i;
        Card[] cardsDrawn = new Card[numOfCards];
        for (i = 0; i < numOfCards; i++){
            if (cards.isEmpty()) {    // if cards list (deck) has at least 1 card in it...
                refreshDeck();
            }
            cardsDrawn[i] = cards.remove(i);
        }
        return cardsDrawn;
    }

}