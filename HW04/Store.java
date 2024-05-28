import java.util.ArrayList;

/**
 * Creates a new Store class which sells all desserts.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * Creates a new Store with the name.
     * @param name    the name of the store
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }

    /**
     * Creates a method which adds it back to dessert.
     * @param dessert  a valid Dessert object
     */
    public void addDessert(Dessert dessert) {
        this.desserts.add(dessert);
        // desserts.add(dessert);
    }

    /**
     * Creates a method which removes the first equal dessert from desserts.
     * @param dessert   a valid Dessert object
     * @return null or removed desserts
     */
    public Dessert removeDessert(Dessert dessert) {
        int index = desserts.indexOf(dessert);
        if (index != -1) {
            return desserts.remove(index);
        }
        return null;
    }

    /**
     * Creates a method which finds the dessert with equal sweetness and flavour.
     * @param dessert  a valid Dessert object
     * @return null or removed desserts
     */
    public Dessert findDessert(Dessert dessert) {
        int left = 0;
        int right = desserts.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = desserts.get(mid).compareTo(dessert);

            if (comparison == 0) {
                return desserts.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // this runs in O(n), so nope
    // public Dessert findDessert(Dessert dessert) {
    //     int index = desserts.indexOf(dessert);
    //     if (index != -1) {
    //         return desserts.get(index);
    //     }
    //     return null;
    // }

    /**
     * Creates a method which sorts desserts in ascending order.
     */
    public void sortStore() {
        for (int i = 0; i < desserts.size() - 1; i++) {
            for (int j = 0; j < desserts.size() - i - 1; j++) {
                if (desserts.get(j).compareTo(desserts.get(j + 1)) > 0) {
                    Dessert temp = desserts.get(j);
                    desserts.set(j, desserts.get(j + 1));
                    desserts.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Creates a method which returns the number of desserts compared to param.
     * @param dessert a valid Dessert object
     * @return number of desserts in the store that is greater than or equal to param
     */
    public int checkStore(Dessert dessert) {
        int count = 0;
        for (int i = 0; i < desserts.size(); i++) {
            Dessert d = desserts.get(i);
            if (d.compareTo(dessert) >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Creates a getter which gets the 'name'.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a setter which sets the 'name'.
     * @param name  name of the store
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a getter which gets the 'desserts'.
     * @return desserts
     */
    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    /**
     * Creates a setter which sets the 'desserts'.
     * @param desserts  the desserts the store sets
     */
    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }
}
