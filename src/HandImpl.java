import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {

    List<Card> hand = new ArrayList<>();

    @Override
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public int getTotalValue() {
        int value = 0;
        for (int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            value += currentCard.VALUE;
        }
        return value;

    }

    @Override
    public List<Card> getCards() {
        return hand;
    }
}