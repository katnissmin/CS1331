/**
 * Creates a new Sugar which represents the valuable cash crop sugar as loot.
 * Is a child class of Loot.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Sugar extends Loot {
    private double amount;
    private double sweetness;

    /**
     * Creates a new Sugar with the amount and sweetness.
     *
     * @param amount        the amount of sugar
     * @param sweetness     the swetness of sugar
     */
    public Sugar(double amount, double sweetness) {
        super();
        this.amount = amount;
        if (sweetness >= 0 && sweetness <= 100) {
            this.sweetness = sweetness;
        } else {
            this.sweetness = 0;
        }
        this.setValue(amount * sweetness);
    }

    /**
     * Creates a method which overrides Loot's toString method.
     * @return string in a fixed format
     */
    @Override
    public String toString() {
        return String.format("A pile of sugar of size %.2f and sweetness %.2f.", this.amount, this.sweetness);
    }

    /**
     * Creates a method which overrides Loots's equals method.
     * @return string in a fixed format
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Sugar other = (Sugar) obj;
            return (other.getValue() == this.getValue()) && (other.amount == this.amount)
                && (other.sweetness == this.sweetness);
        }
    }

}
