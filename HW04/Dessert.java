/**
 * Creates a new Dessert class which is the superclass for other dessert.
 * Implements the Comparable interface to use generics.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

     /**
     * Creates a new Dessert with the flavor and sweetness.
     * @param flavor        the flavor of the cake
     * @param sweetness     the sweetness of the cake
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * Creates a new Dessert with no arguments.
     */
    public Dessert() {
        this.flavor = "vanilla";
        this.sweetness = 25.0;
    }

    /**
     * Creates a getter which gets the 'flavor'.
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Creates a setter which sets the 'flavor'.
     * @param flavor    the flavor of the cake
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Creates a getter which gets the 'sweetness'.
     * @return sweetness
     */
    public double getSweetness() {
        return sweetness;
    }

    /**
     * Creates a setter which sets the 'sweetness'.
     * @param sweetness the sweetness of the cake
     */
    public void setSweetness(double sweetness) {
        this.sweetness = sweetness;
    }

    /**
     * Creates a method which overrides Object's toString method.
     * @return a string in a specific format
     */
    @Override
    public String toString() {
        return "This is a " + flavor + " dessert with a sweetness of " + sweetness + ".";
    }

    /**
     * Creates a method which overrides Object's equal method.
     * @return true if 2 desserts ahve the same flavor and sweetness
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dessert other = (Dessert) obj;
        return (other.sweetness == this.sweetness) && (other.flavor == this.flavor);
    }

    /**
     * Creates a method which implements the compareTo method.
     * @return greater if sweetness is greater
     */
    @Override
    public int compareTo(Dessert other) {
        if (other.sweetness == this.sweetness) {
            return this.flavor.compareTo(other.flavor);
        } else if (this.sweetness < other.sweetness) {
            return -1;
        } else {
            return 1;
        }
    }
}
