// Javadoc what the class represents and what each constructor/method does

/**
 * Creates a new PaperProduct class.
 */
/**
 * @author Katniss
 * @version 1.0
 */
public class PaperProduct {
    // should be accessible everywhere = public?
    // cannot be changed once set = final?
    public static final double COST_PER_GRAM = 0.025;
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    // static because it should be "shared across multiple instances"
    private static int totalProductsToShip = 10;

    /**
     * Creates a new PaperProduct with the name, number of sheets, and weight of a unit sheet.
     *
     * @param name              if empty or null, defaulted to A4
     * @param numberOfSheets    if below 0, defaulted to 500
     * @param weightOfUnitSheet if below 0, defaulted to 0.25
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name == null || name.isEmpty()) {
            this.name = "A4";
        } else {
            this.name = name;
        }
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
        if (weightOfUnitSheet < 0) {
            this.weightOfUnitSheet = 0.25;
        } else {
            this.weightOfUnitSheet = weightOfUnitSheet;
        }
    }

    /**
     * Creates a new PaperProduct with the name, number of sheets, and a default weight of a unit sheet.
     *
     * @param name              the name of the paper product
     * @param numberOfSheets    the number of sheets in the paper product
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }

    /**
     * Creates a new PaperProduct with the name, a default number of sheets, and a default weight of a unit sheet.
     *
     * @param name the name of the paper product
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * Creates a new PaperProduct as a deep copy of all instance fields from the old object to the new object.
     * @param other creating the deep copy
     */
    public PaperProduct(PaperProduct other) {
        this.name = other.name;
        this.numberOfSheets = other.numberOfSheets;
        this.weightOfUnitSheet = other.weightOfUnitSheet;
    }

    /**
     * Creates a method which returns the total weight of the PaperProduct.
     *
     * @return totalWeight = the number of sheets x weight of each single sheet
     */
    public double totalWeight() {
        return numberOfSheets * weightOfUnitSheet;
    }

    /**
     * Creates a method which returns the total cost of the PaperProduct.
     *
     * @return totalCost = the totalWeight x cost per gram
     */
    public double totalCost() {
        return totalWeight() * COST_PER_GRAM;
    }

    /**
     * Creates a method which returns a string about the PaperProduct.
     *
     * @return a String representation of the PaperProduct
     */
    public String paperString() {
        return totalWeight() + "g of " + name + " for $" + totalCost();
    }

    /**
     * Creates a method which returns a string about items being shipped.
     * @param company    takes in the name of the company to ship
     * @return a String representation of whether an item is shipped or not & how much it is
     */
    public String ship(String company) {
        if (totalProductsToShip != 0) {
            totalProductsToShip--;
            return "Shipped " + totalWeight() + "g of " + name + " for $" + totalCost() + " to " + company + ".";
        } else {
            return "Cannot ship any items, Warehouse is empty!";
        }
    }

    /**
     * Creates a getter which returns the name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a getter which returns the number of sheets.
     * @return numberOfSheets
     */
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    /**
     * Creates a getter which returns the weight of one sheet.
     * @return weightOfUnitSheet
     */
    public double getWeightOfUnitSheet() {
        return weightOfUnitSheet;
    }

    /**
     * Creates a getter which returns the total number of products to ship.
     * @return totalProductsToShip
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }

    /**
     * Creates a setter which sets the number of sheets.
     * @param numberOfSheets sets the number of sheets to 500 if less than 0
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
    }
}
