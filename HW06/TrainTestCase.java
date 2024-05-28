import java.util.Iterator;

/**
 * Testing class for LinkedList 1331.
 * Adapted from previous semester.
 */

public class Driver {
    public static void main(String[] args) {
        Train emptyTrain = new Train();
        String cargo1 = "a";
        System.out.println("==========Empty Train Tests==========\n");
        System.out.println("Empty Train:");
        System.out.printf("%s\n\n", emptyTrain);

        System.out.println("Person 1 added to end of list:");
        emptyTrain.add(cargo1);
        System.out.printf("%s\n\n", emptyTrain);
        emptyTrain.remove();

        System.out.println("Person 1 added to front using index:");
        emptyTrain.add(0, cargo1);
        System.out.printf("%s\n\n", emptyTrain);
        emptyTrain.remove(0);

        System.out.println("Empty train contains:");
        System.out.printf("%s\n\n", emptyTrain.contains(cargo1));

        System.out.println("Clearing an empty train:");
        System.out.printf("%s\n\n", emptyTrain);

        // EMPTY LIST SPECIFIC EXCEPTION TESTING:
        // COMMENT OUT ONE GROUP OF LINES
        // AT A TIME FOR EACH EXCEPTION

        //emptyTrain.remove(); // should throw NoSuchElementException

        // emptyTrain.remove(10000); // should throw NoSuchElementException

        // emptyTrain.set(0, parcel1); // should throw IndexOutOfBoundsException

        // emptyTrain.get(0); // should throw IndexOutOfBoundsException

        String[] cargoArray = new String[]{"A", "B", "C", "D", "E"};
        Train train = new Train(cargoArray);
        System.out.println("==========Basic Train Tests==========\n");
        System.out.println("Printing train:");
        System.out.printf("%s\n\n", train);

        System.out.println("=====Add tests=====\n");
        System.out.println("Appending an element:");
        train.add("F");
        System.out.printf("%s\n\n", train);

        System.out.println("Inserting an element into the middle:");
        train.add(2, "F");
        System.out.printf("%s\n\n", train);

        System.out.println("Appending an element with index:");
        train.add(train.size(), "FF");
        System.out.printf("%s\n\n", train);

        System.out.println("Adding to the front:");
        train.add(0, "AA");
        System.out.printf("%s\n\n", train);

        System.out.println("=====Remove Tests=====\n");
        System.out.println("Removing the first 'F':");
        System.out.printf("Returns: %s\n", train.remove("F"));
        System.out.printf("%s\n\n", train);

        System.out.println("Removing an element from the middle:");
        System.out.printf("Returns: %s\n", train.remove(4));
        System.out.printf("%s\n\n", train);

        System.out.println("Removing the first element:");
        System.out.printf("Returns: %s\n", train.remove());
        System.out.printf("%s\n\n", train);

        System.out.println("Removing the first element with index:");
        System.out.printf("Returns: %s\n", train.remove(0));
        System.out.printf("%s\n\n", train);

        System.out.println("Removing the last index:");
        System.out.printf("Returns: %s\n", train.remove(train.size() - 1));
        System.out.printf("%s\n\n", train);

        System.out.println("Resetted train:");
        train.add(0, "A");
        train.add(3, "D");
        System.out.printf("%s\n\n", train);

        System.out.println("=====Set Tests=====\n");
        System.out.println("Set 'A' to 'a':");
        System.out.printf("Returns: %s\n", train.set(0, "a"));
        System.out.printf("%s\n\n", train);
        train.set(0, "A");

        System.out.println("Set 'D' to 'd':");
        System.out.printf("Returns: %s\n", train.set(3, "d"));
        System.out.printf("%s\n\n", train);
        train.set(3, "D");

        System.out.println("Set 'F' to 'f':");
        System.out.printf("Returns: %s\n", train.set(train.size() - 1, "f"));
        System.out.printf("%s\n\n", train);
        train.set(train.size() - 1, "F");

        System.out.println("=====Get Tests=====\n");
        System.out.println("Get first element:");
        System.out.printf("First element: %s\n\n", train.get(0));

        System.out.println("Get middle element:");
        System.out.printf("Middle element: %s\n\n", train.get(3));

        System.out.println("Get last element:");
        System.out.printf("Last element: %s\n\n", train.get(train.size() - 1));

        System.out.println("=====Contains Tests=====\n");
        System.out.println("Check for first element:");
        System.out.printf("Train contains first element: %b\n\n", train.contains("A"));

        System.out.println("Check for middle element:");
        System.out.printf("Train contains middle element: %b\n\n", train.contains("C"));

        System.out.println("Check for last element:");
        System.out.printf("Train contains last element: %b\n\n", train.contains("F"));

        System.out.println("Check for element it doesn't contain:");
        System.out.printf("Train contains element it doesn't contain: %b\n\n", train.contains("Z"));

        System.out.println("Cleared train:");
        train.clear();
        System.out.printf("%s\n", train);

        train.add("A");
        train.add("B");
        train.add("C");
        train.add("D");
        train.add("E");
        train.add("F");
        // ALL REMAINING EXCEPTIONS TESTS:
        // COMMENT OUT ONE GROUP OF TRAINS
        // AT A TIME FOR EACH EXCEPTION

        //String[] nullArray = null;
        //Train nullLine = new Train(nullArray); // should throw IllegalArgumentException

        //String[] nullArray = new String[]{"A", null};
        //Train nullLine = new Train(nullArray); // should throw IllegalArgumentException

        //train.add(null); // should throw IllegalArgumentException

        // train.add(-1, "A"); // should throw IndexOutOfBoundsException

        // train.add(10000, "A"); // should throw IndexOutOfBoundsException

        // train.add(2, null); // should throw IllegalArgumentException

        // train.add(train.size() + 1, null); // should throw IndexOutOfBoundsException

        // train.remove(train.size()); // should throw IndexOutOfBoundsException

        // train.remove(-5); // should throw IndexOutOfBoundsException

        // train.remove(null); // should throw IllegalArgumentException

        //train.remove("Z"); // should throw NoSuchElementException

        //train.set(train.size(), "L"); // should throw IndexOutOfBoundsException

        //train.set(-2, "K"); // should throw IndexOutOfBoundsException

        // train.set(-3, null); // should throw IndexOutOfBoundsException

        // train.set(3, null); // should throw IllegalArgumentException

        // train.get(train.size()); // should throw IndexOutOfBoundsException

        //train.get(-5); // should throw IndexOutOfBoundsException

        //train.contains(null); // should throw IllegalArgumentException

        // ALL OTHER CLASSES EXCEPTIONS TESTS:
        // COMMENT OUT ONE GROUP OF LINES
        // AT A TIME FOR EACH EXCEPTION

        // TrainCar trainIllegal = new TrainCar(null); // should throw IllegalArgumentException

        // TrainIterator iterator = new TrainIterator(null); // should throw IllegalArgumentException

        // TrainIterator iterator = new TrainIterator(train);
        //while (true) {
        //    iterator.next(); // should eventually throw a NoSuchElementException
        //}
    }
}