/**
 * Creates a new DiscountedPaper class which is a child class of PaperProduct.
 */
/**
 * @author Katniss
 * @version 1.0
 */
public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket;

    /**
     * Creates a new DiscountedPaper with the name, number of sheets, weight of a unit sheet, discount rate
     and whether there is a golden ticket attached or not.
     *
     * @param name              is from PaperProduct
     * @param numberOfSheets    is from PaperProduct
     * @param weightOfUnitSheet is from PaperProduct
     * @param discount          is from GoldenTicket
     * @param ticket            is a GoldenTicket object
     */
    public DiscountedPaper(String name, int numberOfSheets,
        double weightOfUnitSheet, double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        if (discount < 0 || discount >= 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
        this.ticket = ticket;
    }

    /**
     * Creates a new DiscountedPaper with the name, number of sheets,
     * defaults discount to 15 and ticket to null.
     * @param name              is from PaperProduct
     * @param numberOfSheets    is from PaperProduct
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.discount = 15.0;
        this.ticket = null;
    }

    /**
     * Creates a new DiscountedPaper with the name, defaults discount to 15 and ticket to null.
     * @param name is from PaperProduct
     */
    public DiscountedPaper(String name) {
        super(name);
        this.discount = 15.0;
        this.ticket = null;
    }

    /**
     * Creates a new DiscountedPaper as a deep copy of all instance fields from the old object to the new object.
     * @param other creating the deep copy
     */
    public DiscountedPaper(DiscountedPaper other) {
        super(other.getName(), other.getNumberOfSheets(), other.getWeightOfUnitSheet());
        this.discount = other.discount;
        this.ticket = new GoldenTicket(other.ticket.getCatchphrase(), other.ticket.getDiscount());
        // this.ticket = other.ticket; -> this doesn't deep copy :<
    }

    /**
     * Creates a method which returns the total cost after the discount.
     * Will also apply GoldenTicket's discount if ticket is not null
     * @return discountedCost
     */
    public double discountedCost() {
        double originalCost = totalCost();
        double discountedCost = originalCost - (originalCost * (discount / 100));
        if (ticket != null) {
            double goldenTicketDiscount = ticket.getDiscount();
            discountedCost -= (discountedCost * (goldenTicketDiscount / 100));
        }
        return discountedCost;
    }

    /**
     * Creates a method which tells whether the item is shipped or not depending on totalProductsToShip.
     * Ship from PaperProduct.java has to be used here.
     * @param company takes in the name of the company to ship
     * @return string about whether the item is shipped or not
     */
    public String shipDiscounted(String company) {
        if (getTotalProductsToShip() != 0) {
            return String.format("%s. The total cost after the discount is %.2f.",
                // "Shipped %.2fg of %s for $%.2f to %s."
                // // totalWeight(), getName(), totalCost(),
                super.ship(company), discountedCost());
            // return "Shipped " + totalWeight() + "g of " + getName() + " for $" + totalCost()
            //         + " to " + company + ". The total cost after the discount is " + discountedCost() + ".";
        } else {
            return String.format("Cannot ship any items, Warehouse is empty!"
                + "The total cost after the discount is %.2f.",
                discountedCost());
            // return "Cannot ship any items, Warehouse is empty! The total cost after the discount is "
            //         + discountedCost() + ".";
        }
    }

    /**
     * Creates a method which returns a string representation of the discounting of the product.
     * @return string in a fixed format
     */
    public String botherAccounting() {
        double originalCost = totalCost();
        double finalCost = discountedCost();
        double originalDiscount = discount;
        double goldenTicketDiscount;
        if (ticket != null) {
            goldenTicketDiscount = ticket.getDiscount();
        } else {
            goldenTicketDiscount = 0.0;
        }
        // return "Discounted Paper Product:\nOriginal Cost: " + originalCost
        //         + "\nFinal Cost: " + finalCost
        //         + "\nOriginal Discount: " + originalDiscount + "%"
        //         + "\nGolden Ticket Discount: " + goldenTicketDiscount + "%";

        return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\nFinal Cost: %.2f"
            + "\nOriginal Discount: %.2f%%\nGolden Ticket Discount: %.2f%%",
            originalCost, finalCost, originalDiscount, goldenTicketDiscount);
    }

    /**
     * Creates a getter which gets the discount rate of the golden ticket.
     *
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Creates a setter which sets the discount rate of the golden ticket.
     *
     * @param discount is set to 15 if not between range 0 and 25.
     */
    public void setDiscount(double discount) {
        if (discount < 0 || discount >= 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * Creates a getter which gets whether there is a golden ticket attached or not.
     *
     * @return ticket
     */
    public GoldenTicket getTicket() {
        return ticket;
    }

    /**
     * Creates a setter which sets whether there is a golden ticket attached or not.
     *
     * @param ticket has a defauly value of null
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }
}
