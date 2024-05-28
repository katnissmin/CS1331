/**
 * Creates a new Ship on the high seas with cargo on board, implementing Plunderable.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Ship implements Plunderable {
    private Loot[] cargo;
    private double totalCargoValue;
    private String name;

    /**
     * Creates a new Ship with the name and cargo's length.
     *
     * @param name        the name of the cargo
     */
    public Ship(String name) {
        this.name = name;
        this.cargo = new Loot[10];
        this.totalCargoValue = 0.0;
    }

    /**
     * Creates a new Ship with no arguments and defaults name to "Black Pearl".
     */
    public Ship() {
        this.name = "Black Pearl";
        this.cargo = new Loot[10];
        this.totalCargoValue = 0.0;
    }

    /**
     * Creates a method which overrides Object's toString method.
     * @return string in a fixed format
     */
    @Override
     public String toString() {
        String cargoString = "A ship called " + name + " with cargo ";
        boolean isFirstItem = true;
        for (Loot item : cargo) {
            if (item != null) {
                if (!isFirstItem) {
                    cargoString += ", ";
                }
                cargoString += item.toString();
                isFirstItem = false;
            }
        }
        cargoString += ", which has a total value of " + String.format("%.2f", totalCargoValue);
        return cargoString;
    }

    /**
     * Creates a method which adds cargo to the first available slot in the array.
     * @param loot  the Loot item taken in by the method
     */
    public void addCargo(Loot loot) {
        int occupiedSlots = 0;

        for (int i = 0; i < cargo.length; i++) {
            Loot item = cargo[i];
            if (item != null) {
                occupiedSlots++;
            } else {
                item = loot;
                totalCargoValue += loot.getValue();
                return;
            }
        }

        if (occupiedSlots == cargo.length) {
            Loot[] newCargo = new Loot[cargo.length * 2];
            for (int i = 0; i < cargo.length; i++) {
                newCargo[i] = cargo[i];
            }
            newCargo[cargo.length] = loot;
            cargo = newCargo;
            totalCargoValue += loot.getValue();
        }
    }


    /**
     * Creates method that removes and returns a specific value in Loot.
     * @return item    the Loot in the first occupied slot in the array.
     */
    public Loot removeCargo() {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                Loot removedItem = cargo[i];
                cargo[i] = null;
                totalCargoValue -= removedItem.getValue();
                return removedItem;
            }
        }
        return null;
    }

    /**
     * Creates method that takes in a Loot and iterates through the array.
     * @param item  the Loot that is taken in by the method
     * @return removedItem
     */
    public Loot removeCargo(Loot item) {
        if (item == null) {
            return null;
        }

        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null && cargo[i].equals(item)) {
                Loot removedItem = cargo[i];
                cargo[i] = null;
                totalCargoValue -= removedItem.getValue();
                return removedItem;
            }
        }
        return null;
    }

   /**
     * Creates method that overrides bePlundered from the Plunderable.
     * @return array of the Loot objects in the ship's cargo
     */
    @Override
    public Loot[] bePlundered() {
        int count = 0;
        for (int i = 0; i < this.cargo.length; i++) {
            if (this.cargo[i] != null) {
                count += 1;
            }
        }

        Loot[] plunderedItems = new Loot[count];
        int index = 0;
        for (int i = 0; i < this.cargo.length; i++) {
            if (this.cargo[i] != null) {
                plunderedItems[index] = this.cargo[i];
                this.totalCargoValue -= this.cargo[i].getValue();
                this.cargo[i] = null;
                index++;
            }
        }
        totalCargoValue = 0.0;
        return plunderedItems;
    }
}

