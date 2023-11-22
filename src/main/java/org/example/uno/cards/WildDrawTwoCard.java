package org.example.uno.cards;

import org.example.uno.game.*;

/**
 * The WildDrawTwoCard class represents a special type of UNO card, The wild draw two card.
 * This card allows a player to choose a color and forces the next player to draw two cards.
 *
 * @author Mahad Ahmed
 * @author Firas El-Ezzi
 * @author Hasib Khodayar
 * @author Hajar Assim
 * @author Yusuf Ibrahim
 *
 * @version 1.2
 */
public class WildDrawTwoCard extends Card {
    private int value;
    public static final int LIGHTVALUE = 50;
    public static final int DARKVALUE = 60;
    private boolean challenged;
    private String message;

    /**
     * Constructs a wild draw two card.
     */
    public WildDrawTwoCard(){
        super();
    }

    /**
     * Plays the wild draw two card in the UNO game. The player of the card gets to choose the colour and the next
     * player must draw two cards.
     *
     * @param game The UNO game in which the card is being played.
     * @return {@code true} if the card was successfully played, {@code false} otherwise.
     */
    @Override
    public boolean playCard(UnoGame game) {

        if (game.isDarkGame()) {
            setValue(DARKVALUE);
            if (challenged){
                if(! super.isCardPlaceable(game,this)){
                    Card c;
                    do { c = game.takeFromDeck(game.getCurrentPlayer(), false, "");}
                    while (c.getColour() != game.getCurrentCard().getColour());
                    Card c1 = game.takeFromDeck(game.getCurrentPlayer(),false,"" );
                    Card c2 = game.takeFromDeck(game.getCurrentPlayer(),false,"" );
                    this.message = " was chosen.\n" + game.getCurrentPlayer().getName()
                            + " was found GUILTY!\nDraw cards until colour +2";
                }
                else{
                    Card c;
                    do { c = game.takeFromDeck(game.getNextPlayer(), false, "");}
                    while (c.getColour() != game.getCurrentCard().getColour());
                    Card c1 = game.takeFromDeck(game.getNextPlayer(), true, "");
                    Card c2 = game.takeFromDeck(game.getNextPlayer(), true, "");
                    this.message = " was chosen.\n" + game.getNextPlayer().getName()
                            + " must draw cards until \ncolour +2 \n Wild Draw Colour.";
                }
            }
            else {
                Card c;
                do { c = game.takeFromDeck(game.getCurrentPlayer(), false, "");}
                while (c.getColour() != game.getCurrentCard().getColour());
                this.message =" was chosen.\n" + game.getNextPlayer().getName()
                        + " must draw until colour \ndue to Wild Draw colour.";
            }
        }
        else {
            setValue(LIGHTVALUE);
            if(challenged){
                if(! super.isCardPlaceable(game,this)){
                    Card c1 = game.takeFromDeck(game.getCurrentPlayer(),false,"" );
                    Card c2 = game.takeFromDeck(game.getCurrentPlayer(),false,"" );
                    this.message =" was chosen.\n" + game.getCurrentPlayer().getName()
                            + " was found GUILTY!\nDraw two cards";
                }
                else{
                    Card c1 = game.takeFromDeck(game.getNextPlayer(), true, "");
                    Card c2 = game.takeFromDeck(game.getNextPlayer(), true, "");
                    this.message =" was chosen.\n" + game.getNextPlayer().getName()
                            + " must draw 2 cards\ndue to Wild Draw Two.";
                }
            }
            else {
                Card c1 = game.takeFromDeck(game.getNextPlayer(), true, "");
                Card c2 = game.takeFromDeck(game.getNextPlayer(), true, "");
                this.message =" was chosen.\n" + game.getNextPlayer().getName()
                        + " must draw 2 cards\ndue to Wild Draw Two.";
            }
        }
        super.placeCard(game, this);

        return true;
    }

    /**
     * Gets the score value of the wild draw two card.
     *
     * @return The value of the card (50).
     */
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    /**
     * Sets the player's decision to challenge or not challenge the WildDrawTwoCard.
     *
     * @param in The decision to challenge or not challenge.
     */
    public void setChallenged(String in){
        this.challenged = in.equals("YES");
    }

    /**
     * Retrieves a string representation of the message.
     *
     * @return A String message.
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * A string representation of the card and the chosen colour.
     *
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        if (this.getColour() == null) {
            return "WILD_DRAW_TWO_CARD";
        } else {
            return "WILD_DRAW_TWO_CARD (" + this.getColour() + ")";
        }
    }
}

