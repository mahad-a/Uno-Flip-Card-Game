package org.example.uno.cards;

import org.example.uno.game.UnoGame;

public class DrawOneCard extends Card{
    private final int value;

    public DrawOneCard(Card.Colour colour){
        super(colour);
        this.value = 10;
    }

    /**
     * Gets the score value of the draw one card.
     *
     * @return The value of the draw one card (10).
     */
    public int getValue(){
        return this.value;
    }



    @Override
    public boolean playCard(UnoGame game) {
        Card currCard = game.getCurrentCard();
        if(super.isCardPlaceable(game, this)){

            super.placeCard(game, this);
            // makes the next person pick up a card and skips their turn
            Card c1 = game.takeFromDeck(game.getCurrentPlayer());
            System.out.println(game.getCurrentPlayer().getName() + " has to draw two due to Draw One Card: " + c1);
            game.nextPlayer(); // skip the player
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of number value and colour of the draw one card.
     *
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        return super.toString() + "DRAW_ONE_CARD";
    }
}

