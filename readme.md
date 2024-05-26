# Blackjack Game in Java

## Overview

This repository contains a simple command-line Blackjack game implemented in Java. The game allows you to play a single round of Blackjack against a dealer. The objective is to have a hand value closer to 21 than the dealer without exceeding 21.

## Instructions

### Game Rules

1. **Card Values**:
   - Number cards (2-10) are worth their face value.
   - Face cards (Jack, Queen, King) are worth 10 points.
   - Aces can be worth 1 or 11 points, whichever is more favorable for the hand.

2. **Gameplay**:
   - Both the player and the dealer are initially dealt two cards.
   - The player's cards are both face-up, while the dealer has one card face-up and one face-down.
   - The player can choose to "hit" (draw another card) or "stand" (end their turn).
   - If the player's hand exceeds 21, they bust and lose the game.
   - Once the player stands, the dealer reveals their face-down card and must hit until their hand value is 17 or higher.
   - If the dealer busts, the player wins.
   - The hand closest to 21 without exceeding it wins. If both hands are equal, it's a tie.

EG:

Your hand: [7 of Hearts, King of Diamonds] (Total value: 17)
Dealer's visible card: 5 of Spades
Do you want to hit or stand? (h/s): h
Your hand: [7 of Hearts, King of Diamonds, 3 of Clubs] (Total value: 20)
Do you want to hit or stand? (h/s): s
Dealer's hand: [5 of Spades, 9 of Hearts] (Total value: 14)
Dealer hits: [5 of Spades, 9 of Hearts, 6 of Clubs] (Total value: 20)
It's a tie!


### Code Structure

- `Card.java`: Represents a single card with a suit, rank, and value.
- `Deck.java`: Represents a deck of cards, providing methods to shuffle and deal cards.
- `Hand.java`: Represents a player's hand, including methods to add cards and calculate the hand's total value.
- `Blackjack.java`: Manages the game flow, including dealing cards, handling user input, and determining the winner.



