public class Card {
    final String SUIT;
    final String RANK;
    final int VALUE;

    public Card(String _suit, String _rank, int _value){
        SUIT = _suit;
        RANK = _rank;
        VALUE = _value;
    }

    @Override
    public String toString(){
        if (RANK.equals("" + VALUE)) {
            return RANK + " of " + SUIT;
        }
        else {
            return RANK + " (" + VALUE + ") of " + SUIT;
        }

    }
}
