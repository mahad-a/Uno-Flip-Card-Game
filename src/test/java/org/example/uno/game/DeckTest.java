package org.example.uno.game;
import org.example.uno.cards.Card;
import org.example.uno.game.Deck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;
    private Card drawnCard;

    @Before
    public void createDeck() {
        deck = new Deck();
    }

    @Test
    public void testDeckSize() {

        assertEquals(112, deck.getDeckSize());
    }

    @Test
    public void testDrawCard() {
        int initialDeck = deck.getDeckSize();
        Card drawnCard = deck.drawCard();
        int newDeck = deck.getDeckSize();


        assertNotNull(drawnCard);

        assertEquals(initialDeck - 1, newDeck);
    }

    @Test
    public void testShuffle() {
        Deck originalDeck = new Deck();
        deck.shuffle();

        assertNotEquals(originalDeck, deck);
    }
}
