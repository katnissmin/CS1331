/**
 * Creates a new Coin class which represents a piece of loot in the form of a coin.
 * Is a child class of Loot.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Coin extends Loot {
    private boolean heads;
    private int yearMade;
    private String material;

    /**
     * Creates a new Coin with the value, heads, yearMade and material.
     *
     * @param value             is from Loot
     * @param heads             a boolean whether the coin is heads up
     * @param yearMade          the year the coin was manufactured
     * @param material          the material the coin is made of
     */
    public Coin(double value, boolean heads, int yearMade, String material) {
        super(value);
        this.heads = heads;
        // double check if statements if necessary
        if (yearMade >= 0 && yearMade <= 1700) {
            this.yearMade = yearMade;
        } else {
            this.yearMade = 1700;
        }
        this.material = material;
    }

    /**
     * Creates a new Coin with the heads and yearMade.
     * Value and material have a default value.
     *
     * @param heads             a boolean whether the coin is heads up
     * @param yearMade          the year the coin was manufactured
     */
    public Coin(boolean heads, int yearMade) {
        super();
        this.heads = heads;
        if (yearMade >= 0 && yearMade <= 1700) {
            this.yearMade = yearMade;
        } else {
            this.yearMade = 1700;
        }
        this.setValue((3000 - (double) yearMade) / 100);
        this.material = "Gold";
    }

    /**
     * Creates a method which overrides Loot's toString method.
     * @return string in a fixed format
     */
    @Override
    public String toString() {
        return String.format("A %s coin made in %d. Heads side is up: %b.", this.material, this.yearMade, this.heads);
    }

    /**
     * Creates a method which overrides Loots's equals method.
     * @return true if two coin objects have equal value, yearMade and material
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Coin other = (Coin) object;
        return (this.getValue() == other.getValue())
                && (this.yearMade == other.yearMade)
                && (this.material.equals(other.material));
    }

}
