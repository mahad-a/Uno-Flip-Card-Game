package org.example.uno.cards;
import static org.junit.Assert.*;
import org.example.uno.game.Player;
import org.example.uno.game.UnoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseCardTest {

    private ReverseCard reverseCard;
    private UnoGame game;

    @Before
    public void setUp() {
        // Create an instance of ReverseCard with a specific color for testing
        reverseCard = new ReverseCard(Card.Colour.BLUE);

        // Create an UnoGame instance (you may need to adapt this based on your project)
        game = new UnoGame(true);
        game.setCurrentCard(reverseCard); // Set the current card to the reverse card
    }

    @Test
    public void testGetValue() {
        assertEquals(20, reverseCard.getValue());
    }

    @Test
    public void testPlayCard() {
        // Test whether the card can be played
        assertTrue(reverseCard.playCard(game));

        // Ensure that the order of players has been reversed
        ArrayList<Player> originalPlayers = game.getPlayers();
        ArrayList<Player> reversedPlayers = new ArrayList<>(originalPlayers);
        Collections.reverse(reversedPlayers);
        assertEquals(reversedPlayers, game.getPlayers());
    }

    @Test
    public void testToString() {
        assertEquals("BLUE REVERSE_CARD", reverseCard.toString());
    }
}