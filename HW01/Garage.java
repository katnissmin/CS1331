public class Garage {
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4];
    }

    public Car addCar(int index, Car car) {
        if (index < 0 || index >= carCatalogue.length || car == null) {
            System.out.println("Cannot add a car to this spot.");
            return null;
        }

        Car oldCar = carCatalogue[index];

        if (oldCar != null) {
            System.out.println("There was a " + oldCar.getColor() + " " + oldCar.getYear() + " "
                + oldCar.getMake() + " " + oldCar.getModel() + " here before.");
            carCatalogue[index] = car;
            return oldCar;
        } else {
            System.out.println("A " + car.getColor() + " " + car.getYear() + " "
                + car.getMake() + " " + car.getModel() + " was just parked here.");
            carCatalogue[index] = car;
            return null;
        }
    }

    public Car sellCar(int index) {
        if (index < 0 || index >= carCatalogue.length || carCatalogue[index] == null) {
            System.out.println("There was no car to sell!");
            return null;
        }

        Car sellingCar = carCatalogue[index];

        if (sellingCar != null) {
            System.out.println(theOwner.getName() + " just sold a " + sellingCar.getColor() + " "
                + sellingCar.getYear() + " " + sellingCar.getMake() + " " + sellingCar.getModel() + ".");
            carCatalogue[index] = null;
            theOwner.setCarsOwned(theOwner.getCarsOwned() - 1);
            return sellingCar;
        } else {
            System.out.println("There was no car to sell!");
            return null;
        }
    }

    public void showCertainCars(int conditionCategory) {
        for (int i = 0; i < carCatalogue.length; i += 1) {
            if (carCatalogue[i].getConditionCategory() > conditionCategory) {
                System.out.println("A " + carCatalogue[i].getColor() + " " + carCatalogue[i].getYear()
                    + " " + carCatalogue[i].getMake() + " " + carCatalogue[i].getModel()
                    + " with a condition category of " + carCatalogue[i].getConditionCategory() + ".");
            }
        }
    }

    public GarageOwner getTheOwner() {
        return theOwner;
    }

    public void setTheOwner(GarageOwner theOwner) {
        this.theOwner = theOwner;
    }

    public Car[] getCarCatalogue() {
        return carCatalogue;
    }

    public void setCarCatalogue(Car[] carCatalogue) {
        this.carCatalogue = carCatalogue;
    }

    // public int getYear() {
    //     return theOwner.year();
    // }

    // public String getName() {
    //     return theOwner.name();
    // }

    // public String getColor() {
    //     return theOwner.color();
    // }

    // public String getMake() {
    //     return theOwner.make();
    // }

    // public String getModel() {
    //     return theOwner.model();
    // }

    // public int getAge() {
    //     return theOwner.age();
    // }

    // public int getCarsOwned() {
    //     return theOwner.getCarsOwned();
    // }


}