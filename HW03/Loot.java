/**
 * Creates a new abstract Loot class which represents the spoils gained from plundering a ship/fort.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public abstract class Loot {
    private double value;

    // Constructor that takes in value and ensures that the value of the item is greater than 0.
    // Otherwise, value should be set to the default amount.
    /**
     * Creates a new Loot with the variable valus, ensure value > 0.
     *
     * @param value             the monetary value of an item
     */
    public Loot(double value) {
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    /**
     * Creates a new Loot that takes in no arguments and sets value = 0.
     */
    public Loot() {
        this.value = 0;
    }

    /**
     * Creates a getter which gets the 'value'.
     *
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Creates a setter which sets the 'value'.
     *
     * @param value  is the monetary value of an item
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Creates a method which overrides Object's toString method.
     * @return string in a fixed format
     */
    @Override
    public String toString() {
        return String.format("A piece of loot worth %.2f", this.value);
    }

    /**
     * Creates a method which overrides Object's equals method.
     * @return true if two Loot objects have the same value
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Loot obj2 = (Loot) obj;
            return obj2.value == this.value;
        }
    }

}
