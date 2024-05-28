/**
 * Creates a new Cake class which is a subclass of Dessert.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Cake extends Dessert {
    private String frosting;

    /**
     * Creates a new Cake with the flavor, sweeteness and frosting.
     * @param flavor        the flavor of the cake
     * @param sweetness     the sweetness of the cake
     * @param frosting      the frositng on the cake
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * Creates a new Cake with the flavor.
     * @param flavor        the flavor of the cake
     */
    public Cake(String flavor) {
        super(flavor, 45.0);
        this.frosting = "vanilla";
    }

    /**
     * Creates a getter which gets the 'frosting'.
     * @return frosting
     */
    public String getFrosting() {
        return frosting;
    }

    /**
     * Creates a setter which sets the 'frosting'.
     * @param frosting  the frosting of the cake
     */
    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }

    /**
     * Creates a method which overrides Dessert's toString method.
     * @return a string in a specific format
     */
    @Override
    public String toString() {
        return "This is a " + getFlavor() + " cake with a " + frosting
                + " frosting and has a sweetness of " + getSweetness() + ".";
    }

    /**
     * Creates a method which overrides Dessert's equal method.
     * @return true if 2 cakes have the same flavor, sweetness and frosting
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Cake other = (Cake) obj;
        return frosting.equals(other.frosting);
    }
}
