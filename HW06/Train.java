import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a new Train class which is a generic class representing a train.
 * @param <T>   the type of cargo this train carries
 * @author Katniss
 * @version 1.0
 */
public class Train<T> implements List<T> {
    private TrainCar<T> engine;
    private int size;

    /**
     * Creates a new Train which takes in an array of cargo of type T.
     * @param cargoArray   an array of cargo type T
     */
    public Train(T[] cargoArray) {
        for (T cargo : cargoArray) {
            add(cargo); // keep adding to end
        }
    }

    /**
     * Creates a new Train with no arguments that intialized an empty Train.
     */
    public Train() {
        engine = null;
        size = 0;
    }

    /**
     * Creates a TrainCar with no arguments.
     * @return engine
     */
    public TrainCar<T> getEngine() {
        return engine;
    }

    /**
     * Creates a method which returns the cargo that this train carries in an array.
     * @return an array
     */
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        int index = 0;
        TrainIterator<T> iterator = new TrainIterator<>(this);
        while (iterator.hasNext()) {
            arr[index++] = iterator.next();
        }
        return arr;
    }

    /**
     * Creates a method which returns the cargo that this train carries in an array.
     * @return an string in a specific format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== TRAIN %d =====\nisEmpty: %s\nsize: %d\nengine: %s\nCHOO CHOO: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (engine == null ? "null" : engine.getCargo())));

        T[] cargo = toArray();
        if (cargo == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < cargo.length - 1; ++i) {
                sb.append(String.format("%s, ", cargo[i])); // append all but last value
            }
            if (cargo.length > 0) {
                sb.append(String.format("%s", cargo[cargo.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    /**
     * Inserts the element at the end of the list.
     * @param element the element we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        TrainCar<T> newCar = new TrainCar<>(element);
        if (isEmpty()) {
            engine = newCar;
        } else {
            TrainCar<T> currentCar = engine;
            while (currentCar.getNextCar() != null) {
                currentCar = currentCar.getNextCar();
            }
            currentCar.setNextCar(newCar);
        }
        size++;
    }

    /**
     * Inserts the element at the specified index of the list.
     * If an element exists at that index, that element in the list should come after the new element being added.
     * @param index   the index to add the element at
     * @param element the element we are adding to the list
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == size() is valid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (index == size) {
            add(element);
        } else {
            TrainCar<T> newCar = new TrainCar<>(element);
            if (index == 0) {
                newCar.setNextCar(engine);
                engine = newCar;
            } else {
                TrainCar<T> currentCar = engine;
                for (int i = 0; i < index - 1; i++) {
                    currentCar = currentCar.getNextCar();
                }
                newCar.setNextCar(currentCar.getNextCar());
                currentCar.setNextCar(newCar);
            }
            size++;
        }
    }

    /**
     * Removes the element at the front of the list and returns it.
     * @return the removed element from the front of the list
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T cargo = engine.getCargo();
        engine = engine.getNextCar();
        size--;
        return cargo;
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index the index of the element to be removed
     * @return the removed element at the specified index of the list
     * @throws NoSuchElementException    if the list is empty. In the event that the list is empty and
     *                                   the passed in index is invalid, this exception should be thrown.
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return remove();
        } else {
            TrainCar<T> currentCar = engine;
            for (int i = 0; i < index - 1; i++) {
                currentCar = currentCar.getNextCar();
            }
            T cargo = currentCar.getNextCar().getCargo();
            currentCar.setNextCar(currentCar.getNextCar().getNextCar());
            size--;
            return cargo;
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list and returns it.
     * The first occurrence of the specified element is the first element in the list
     * that is equal to the passed in element according to how the equals method is defined.
     *
     * @param element the element to be removed
     * @return the element that is removed from the list. Do not return the passed in element!
     * @throws IllegalArgumentException if the passed in element is null
     * @throws NoSuchElementException   if the passed in element is not in the list. If the passed in element
     *                                  is null, an IllegalArgumentException should be thrown instead.
     */
    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (element.equals(engine.getCargo())) {
            return remove();
        } else {
            TrainCar<T> currentCar = engine;
            while (currentCar.getNextCar() != null) {
                if (element.equals(currentCar.getNextCar().getCargo())) {
                    T cargo = currentCar.getNextCar().getCargo();
                    currentCar.setNextCar(currentCar.getNextCar().getNextCar());
                    size--;
                    return cargo;
                }
                currentCar = currentCar.getNextCar();
            }
            throw new NoSuchElementException();
        }
    }

    /**
     * Replaces the element at a specific index with the passed in element.
     *
     * @param index   the index of the element to be replaced
     * @param element the element that should replace the existing element at the passed in index
     * @return the element that was replaced
     * @throws IndexOutOfBoundsException if the passed in index is invalid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException  if the passed in element is null
     */
    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new IllegalArgumentException();
        }
        TrainCar<T> currentCar = engine;
        for (int i = 0; i < index; i++) {
            currentCar = currentCar.getNextCar();
        }
        T cargo = currentCar.getCargo();
        currentCar.setCargo(element);
        return cargo;
    }

    /**
     * Returns the element at the specified index.
     * You must implement this method by explicitly using an iterator.  - i.e., by explicitly
     * utilizing Iterator's hasNext() and next() methods. Do not use a for-each loop.
     *
     * @param index the index of the element to get
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        TrainCar<T> currentCar = engine;
        for (int i = 0; i < index; i++) {
            currentCar = currentCar.getNextCar();
        }
        return currentCar.getCargo();
    }

    /**
     * Checks if the list contains the specified element.
     * The list contains the specified element if there exists at least one element in the list
     * that is equal to the passed in element according to how the equals method is defined.
     * You must implement this method by explicitly using an iterator - i.e., by explicitly
     * utilizing Iterator's hasNext() and next() methods. Do not use a for-each loop.
     *
     * @param element the element to search for in the list
     * @return whether the list contains the element
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        TrainCar<T> currentCar = engine;
        while (currentCar != null) {
            if (element.equals(currentCar.getCargo())) {
                return true;
            }
            currentCar = currentCar.getNextCar();
        }
        return false;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        engine = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     * @return whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new TrainIterator<>(this);
    }
}