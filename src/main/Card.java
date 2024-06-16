package main;

import main.types.Suit;

public class Card {
    final Suit SUIT;
    final String RANK;
    int value;

    public Card(Suit _suit, String _rank, int _value){
        SUIT = _suit;
        RANK = _rank;
        value = _value;
    }

    @Override
    public String toString(){
        if (RANK.equals("" + value)) {
            return RANK + " of " + SUIT;
        }
        else {
            return RANK + " (" + value + ") of " + SUIT;
        }

    }
}
