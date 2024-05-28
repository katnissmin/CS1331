/**
 * Creates a new Bob class which defines Bob's behaviors.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Bob {
    /**
     * Creates a method which compares 2 Store objects.
     * @param store1 first valid Store object
     * @param store2 second valid Store object
     * @return true or false
     */
    public static boolean compareStores(Store store1, Store store2) {
        for (Dessert dessert : store1.getDesserts()) {
            if (store2.findDessert(dessert) == null) {
                return false;
            }
        }
        return true;
    }


    /**
     * Creates a method which sorts the Store object and a Dessert object.
     * @param store one valid Store object
     * @param dessert one valid Dessert object
     * @return true or false
     */
    public static boolean shop(Store store, Dessert dessert) {
        store.sortStore(); // need to sort desserts in the store?
        return store.findDessert(dessert) != null;
    }
}
