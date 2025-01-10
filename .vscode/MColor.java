//package Game3;

public enum MColor {
    YELLOW("Yellow"),
    BLUE("Blue"),
    ORANGE("Orange"),
    PURPLE("Purple");

    private String colorText;

    // Constructor
    private MColor(String colorText) {
        this.colorText = colorText;
    }

    // Public method
    public String printColor() {
        return colorText;
    }
}
