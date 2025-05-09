package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void testPointValue_numberCard() {
        Card card = new Card("Hearts", "7");
        assertEquals(7, card.getPointValue());
    }

    @Test
    public void testPointValue_faceCard() {
        Card card = new Card("Spades", "Q");
        assertEquals(10, card.getPointValue());
    }

    @Test
    public void testPointValue_aceCard() {
        Card card = new Card("Diamonds", "A");
        assertEquals(11, card.getPointValue());
    }

    @Test
    public void testFlipAndVisibility() {
        Card card = new Card("Clubs", "10");
        assertFalse(card.isFaceUp());
        assertEquals("#", card.getSuit());
        card.flip();
        assertTrue(card.isFaceUp());
        assertEquals("Clubs", card.getSuit());
    }
}