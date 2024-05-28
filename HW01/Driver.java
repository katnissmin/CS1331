public class Driver {
    public static void main(String[] args) {
        // Create a GarageOwner object
        GarageOwner owner = new GarageOwner("John Doe", 40);

        // Create a Garage object with an empty array of at least 3 cars
        Garage garage = new Garage(new GarageOwner("Jane Smith", 35), new Car[3]);

        // Create 3 Car objects and add them to the Garage
        Car car1 = garage.addCar(2022, "Toyota", "Camry", "Red", 95);
        Car car2 = garage.addCar(2015, "Honda", "Accord", "Blue", 85);
        Car car3 = garage.addCar(2010, "Ford", "Mustang", "Yellow", 75);

        // Remove 1 car object from the Garage
        Car soldCar = garage.sellCar(1);

        // Print the number of cars owned by the GarageOwner
        System.out.println("Number of cars owned by " + owner.getName() + ": " + owner.getCarsOwned());

        // Call showCertainCars() with a condition category
        System.out.println("Cars with condition category greater than 80:");
        garage.showCertainCars(80);
    }
}
