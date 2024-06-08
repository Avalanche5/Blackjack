import java.util.List;

public interface Hand {
    void addCard(Card card);
    void addCards(Card[] card);
    int getTotalValue();
    List<Card> getCards();
}