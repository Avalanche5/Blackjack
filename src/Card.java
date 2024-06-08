public class Card {
    final String SUIT;
    final String RANK;
    int value;

    public Card(String _suit, String _rank, int _value){
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
