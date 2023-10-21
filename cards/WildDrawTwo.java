package cards;

import cards.Card;
import game.*;

import java.util.Scanner;

public class WildDrawTwo extends Card {


    public WildDrawTwo(){
        super();
    }

    @Override
    public void playCard(UnoGame game) {
        String input;

        do {
            input = UnoGame.promptText("Enter a color of your choice: ").toUpperCase();

            switch (input) {
                case "BLUE":
                    this.setColour(Colour.BLUE);
                    break;
                case "RED":
                    this.setColour(Colour.RED);
                    break;
                case "YELLOW":
                    this.setColour(Colour.YELLOW);
                    break;
                case "GREEN":
                    this.setColour(Colour.GREEN);
                    break;
                default:
                    System.out.println("Please enter a card with either matching colors or number:");
                    // Continue the loop to prompt the user again.
                    continue;
            }

            System.out.println(game.getCurrentPlayer().getName() + " has changed color to: " + input + "!");
            this.setColour(Colour.valueOf(input));
            break; // Exit the loop if a valid color is chosen.

        } while (true);

        game.setCurrentCard(this);
        game.getCurrentPlayer().discardCard(this);

        game.nextPlayer(1);
        game.drawOne(game.getCurrentPlayer());
        game.drawOne(game.getCurrentPlayer());
        game.nextPlayer(1);

    }

    @Override
    public String toString() {
        if (this.getColour() == null) {
            return "WILD-CARD-DRAW-TWO";
        } else {
            return "WILD-CARD-DRAW-TWO (" + this.getColour() + ")";
        }
    }
}
    