import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a new TrainIterator class which represents an iterator to iterate over a Train.
 * @param <T>  the type of cargo carried by the train that this iterator iterates over
 * @author Katniss
 * @version 1.0
 */
public class TrainIterator<T> implements Iterator<T> {
    private TrainCar<T> nextCar;

    /**
     * Creates a new TrainIterator which takes the Train this iterator will iterate over.
     * @param train    the Train this iterator will iterate over
     */
    public TrainIterator(Train<T> train) throws IllegalArgumentException {
        if (train == null) {
            throw new IllegalArgumentException();
        }
        this.nextCar = train.getEngine();
    }

    /**
     * Creates a method which overrides the hasNext method by Iterator.
     * @return boolean specifying if there are more train cars to iterate over
     */
    @Override
    public boolean hasNext() {
        return nextCar != null;
    }

    /**
     * Creates a method which overrides the next method by Iterator.
     * @return cargo in the next train car and advances iterator to the next train car
     */
    @Override
    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            T cargo = nextCar.getCargo();
            nextCar = nextCar.getNextCar();
            return cargo;
        }
    }
}
