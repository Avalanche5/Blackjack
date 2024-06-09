package main;

import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {

    List<Card> hand = new ArrayList<>();

    @Override
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public void addCards(Card[] cards) {
        int i;
        for (i = 0; i < cards.length; i++){
            hand.add(cards[i]);
        }
    }

    @Override
    public int getTotalValue() {
        int value = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            value += currentCard.value;

        }
        if (value > 21) {
            for (int i = 0; i < hand.size(); i++) {
                Card currentCard = hand.get(i);
                if (currentCard.value == 11 && value > 21) {
                    currentCard.value = 1;
                    value -= 10;
                }
            }
        }
        return value;
    }

    @Override
    public List<Card> getCards() {
        return hand;
    }
}