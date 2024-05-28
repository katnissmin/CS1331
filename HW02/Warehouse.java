/**
 * Creates a Warehouse class which is the Driver file.
 */
/**
 * @author Katniss
 * @version 1.0
 */
public class Warehouse {
    /**
     * Creates a main method.
     * @param args takes in a parameter of args
     */
    public static void main(String[] args) {
        // create 2 PaperProduct
        // create 2 PhotoPaper
        // create 2 DiscountedPaper
        // create GoldenTicket instance
        // call ship methods on PaperProduct & print results
        // test botherAccounting method
        // test deep copy

        // create 2 PaperProduct
        PaperProduct paper1 = new PaperProduct("A3", 1000, 0.45);
        PaperProduct paper2 = new PaperProduct("", -200, -0.45);
        PaperProduct paper3 = new PaperProduct(paper1);  //test deep copy

        // create 2 PhotoPaper
        PhotoPaper photo1 = new PhotoPaper("", 500, 0.75, 80);
        PhotoPaper photo2 = new PhotoPaper("glosssssy", 20000);
        PhotoPaper photo3 = new PhotoPaper(photo1);  //test deep copy

        // create 2 DiscountedPaper
        DiscountedPaper discounted1 = new DiscountedPaper("name", 500, 0.3, 25.0, null);
        DiscountedPaper discounted2 = new DiscountedPaper("", 560, 46, -5, null);
        // DiscountedPaper discounted3 = new DiscountedPaper(discounted1);

        // create GoldenTicket instance
        GoldenTicket ticket = new GoldenTicket("46% off everything", 46.0);

        // call ship methods on PaperProduct & print results
        System.out.println(paper1.ship("company 1"));
        System.out.println(photo1.shipPhoto("company 2"));
        System.out.println(discounted1.shipDiscounted("company 3"));

        System.out.println(paper2.ship("company 4"));
        System.out.println(photo2.shipPhoto("company 5"));
        System.out.println(discounted2.shipDiscounted("company 6"));

        System.out.println(paper3.ship("company 7"));
        System.out.println(photo3.shipPhoto("company 8"));
        // System.out.println(discounted3.shipDiscounted("company 9"));

        // test botherAccounting method
        System.out.println(discounted1.botherAccounting());
        System.out.println(discounted2.botherAccounting());
        // System.out.println(discounted3.botherAccounting());


    }
}
