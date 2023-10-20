public class Card {

    public enum Colour {
        BLUE, RED, GREEN, YELLOW
    }

    public enum Type {
         DRAW_ONE, SKIP, REVERSE, WILD, WILD_DRAW_TWO
    }

    public enum Number{
        ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE
    }

    private Colour colour;
    private Type type;
    private Number number;

    public Card(Colour colour, Number number) {
        this.colour = colour;
        this.number = number;

    }

    public Card(Colour colour, Type type) {
        this.colour = colour;
        this.type = type;
    }

    public Colour getColour() {
        return colour;
    }

    public Type getType() {
        return type;
    }

    // Display the card, EX (RED SKIP)
    public String toString() {
        return colour + " " + type;
    }
}
