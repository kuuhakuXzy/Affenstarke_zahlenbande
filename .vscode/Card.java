//package Game3;

public class Card {

    public enum MColor {
        YELLOW, BLUE, ORANGE, PURPLE;
    }

    private final MColor color;
    private final int value;

    // constructor
    public Card(final MColor color, final int value) {
        this.color = color;
        this.value = value;
    }

    public MColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return color + "" + value;
    }
}
