/**
 * Creates a new IceCream class which is a subclass of Dessert.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * Creates a new IceCream with the flavor, sweeteness, scoops and cone.
     * @param flavor        the flavor of the cake
     * @param sweetness     the sweetness of the cake
     * @param scoops        the number of scoops of the ice cream
     * @param cone          whether the ice cream has a cone
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * Creates a new IceCream with the scoops and cone.
     * @param scoops        the number of scoops of the ice cream
     * @param cone          whether the ice cream has a cone
     */
    public IceCream(int scoops, boolean cone) {
        super("vanilla", 45.0);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * Creates a new IceCream with no arguments.
     */
    public IceCream() {
        super("vanilla", 45.0);
        this.scoops = 1;
        this.cone = false;
    }

    /**
     * Creates a getter which gets the 'scoops'.
     * @return scoops
     */
    public int getScoops() {
        return scoops;
    }

    /**
     * Creates a setter which sets the 'scoops'.
     * @param scoops    the number of scoops of the ice cream
     */
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

    /**
     * Creates a getter which gets the 'cone'.
     * @return cone
     */
    public boolean hasCone() {
        return cone;
    }

    /**
     * Creates a setter which sets the 'cone'.
     * @param cone  whether the ice cream has a cone
     */
    public void setCone(boolean cone) {
        this.cone = cone;
    }

    /**
     * Creates a method which overrides Dessert's toString method.
     * @return a string in a specific format
     */
    @Override
    public String toString() {
        if (this.cone) {
            return "This is a " + getFlavor() + " ice cream with " + scoops + " scoops and has a cone.";
        } else {
            return "This is a " + getFlavor() + " ice cream with " + scoops + " scoops and does not have a cone.";
        }
    }

    /**
     * Creates a method which overrides Dessert's equal method.
     * @return true if 2 ice creams have the same flavor, sweetness, scoops and cone.
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
        IceCream other = (IceCream) obj;
        return scoops == other.scoops && cone == other.cone;
    }
}
