package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void deal(Card card) {
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }

    public int getValue() {
        int total = 0;
        int aces = 0;
        for (Card card : cards) {
            total += card.getPointValue();
            if (card.getValue().equals("A")) {
                aces++;
            }
        }
        while (total > 21 && aces > 0) {
            total -= 10; // downgrade Ace from 11 to 1
            aces--;
        }
        return total;
    }

    public String displayHand() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(", ");
        }
        return sb.toString();
    }
}
