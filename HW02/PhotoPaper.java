// Javadoc what the class represents and what each constructor/method does

/**
 * Creates a new PhotoPaper class which is a child class of PaperProduct.
 */
/**
 * @author Katniss
 * @version 1.0
 */
public class PhotoPaper extends PaperProduct {
    private double glossiness;

    /**
     * Creates a new PhotoPaper with the name, number of sheets, weight of a unit sheet, and glossiness of a sheet.
     *
     * @param name              is from PaperProduct
     * @param numberOfSheets    is from PaperProduct
     * @param weightOfUnitSheet is from PaperProduct
     * @param glossiness        if not between 0 and 100, defaulted to 70
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (glossiness <= 0 || glossiness >= 100) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }

    /**
     * Creates a new PhotoPaper with the name, number of sheets, and glossiness of a sheet.
     *
     * @param name              is from PaperProduct
     * @param numberOfSheets    is from PaperProduct
     */
    public PhotoPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.glossiness = 70;
    }

    /**
     * Creates a new PhotoPaper with the name, and defaults glossiness to 70.
     *
     * @param name              is from PaperProduct
     */
    public PhotoPaper(String name) {
        super(name);
        this.glossiness = 70;
    }

    /**
     * Creates a new PhotoPaper as a deep copy of all instance fields from the old object to the new object.
     * @param other creating the deep copy
     */
    public PhotoPaper(PhotoPaper other) {
        super(other);
        this.glossiness = other.glossiness;
    }

    /**
     * Creates a method which returns the glossiness and total weight of the PhotoPaper.
     *
     * @return string representation of PhotoPaper
     */
    public String photoString() {
        return glossiness + "% glossy and " + totalWeight() + "g of " + getName() + " for $" + totalCost();
    }

    /**
     * Creates a method which returns whether the paper is shipped.
     *
     * @param company takes in the name of the company to ship
     * @return string representation of whether paper is shipped or not depending on value of totalProductsToShip
     */
    public String shipPhoto(String company) {
        if (getTotalProductsToShip() != 0) {
            getTotalProductsToShip();
            return "Paper is " + glossiness + "% glossy. " + super.ship(company);
        } else {
            return "Paper is " + glossiness + "% glossy. Cannot ship any items, Warehouse is empty!";
        }
    }

    /**
     * Creates a getter which gets the glossiness of the paper.
     *
     * @return glossiness
     */
    public double getGlossiness() {
        return glossiness;
    }

    /**
     * Creates a setter which sets the glossiness of the paper.
     *
     * @param glossiness        if not between 0 and 100, defaulted to 70
     */
    public void setGlossiness(double glossiness) {
        if (glossiness <= 0 || glossiness >= 100) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }
}
