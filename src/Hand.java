import java.util.List;

public interface Hand {
    void addCard(Card card);
    int getTotalValue();
    List<Card> getCards();
}

