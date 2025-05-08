package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        if (isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if (isFaceUp) {
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
      /*  switch (value) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11;
            default:
                return Integer.parseInt(value);
        }
        different way of writing switch down there
        */
        return switch (value) {
            case "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> Integer.parseInt(value);
        };
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
