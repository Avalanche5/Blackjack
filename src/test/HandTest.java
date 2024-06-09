package test;

import main.Card;
import main.Hand;
import main.HandImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

        private Hand hand;

        @BeforeEach
        public void setUp() {
            hand = new HandImpl();
        }

        @Test
        public void testAddCard() {
            Card card = new Card("Hearts", "Ace", 11);
            hand.addCard(card);
            List<Card> cards = hand.getCards();
            assertEquals(1, cards.size());
            assertEquals(card, cards.get(0));
        }

        @Test
        public void testGetTotalValueWithoutAce() {
            hand.addCard(new Card("Hearts", "Four", 4));
            hand.addCard(new Card("Diamonds", "Seven", 7));
            assertEquals(11, hand.getTotalValue());
        }

        @Test
        public void testGetTotalValueWithAce() {
            hand.addCard(new Card("Hearts", "Ace", 11));
            hand.addCard(new Card("Diamonds", "Eight", 8));
            assertEquals(19, hand.getTotalValue());
        }

        @Test
        public void testGetTotalValueWithAceAsOne() {
            hand.addCard(new Card("Hearts", "Ace", 11));
            hand.addCard(new Card("Diamonds", "King", 10));
            assertEquals(21, hand.getTotalValue());
        }
    }
