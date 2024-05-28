/**
 * Creates a new GoldenTicket class which stores details about
 golden tickets that customers can use with the discounted paper stock.
 */
/**
 * @author Katniss
 * @version 1.0
 */
public class GoldenTicket {
    private String catchphrase;
    private double discount;

    /**
     * Creates a new GoldenTicket with the name, number of sheets, weight of a unit sheet, and glossiness of a sheet.
     *
     * @param catchphrase    represents the catchphrase on the ticket
     * @param discount       the discount offered by the ticket, between 0 and 25
     */
    public GoldenTicket(String catchphrase, double discount) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
        if (discount < 0 || discount >= 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * Creates a method which returns the discount rate of the ticket with its catchphrase.
     *
     * @return string representation of GoldenTicket
     */
    public String ticketString() {
        return "Golden Ticket with a " + discount + "° discount! " + catchphrase;
    }

    /**
     * Creates a getter which gets the catchphrase of the golden ticket.
     *
     * @return catchphrase
     */
    public String getCatchphrase() {
        return catchphrase;
    }

    /**
     * Creates a setter which sets the catchphrase of the golden ticket.
     *
     * @param catchphrase represents the catchphrase on the ticket
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
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
     * @param discount the discount offered by the ticket, between 0 and 25
     */
    public void setDiscount(double discount) {
        if (discount < 0 || discount >= 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }
}
