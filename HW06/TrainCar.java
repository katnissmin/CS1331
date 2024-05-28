/**
 * Creates a new TrainCar class which represents an individual train car.
 * @param <T>    the type of cargo this train car carries
 * @author Katniss
 * @version 1.0
 */
public class TrainCar<T> {
    private T cargo;
    private TrainCar<T> nextCar;

    /**
     * Creates a new TrainCar which takes the cargo and nextCar.
     * @param cargo    the cargo this train car carries
     * @param nextCar  reference to the next train car
     */
    public TrainCar(T cargo, TrainCar<T> nextCar) throws IllegalArgumentException {
        if (cargo == null) {
            throw new IllegalArgumentException();
        }
        this.cargo = cargo;
        this.nextCar = nextCar;
    }

    /**
     * Creates a new TrainCar which takes the cargo and nextCar.
     * @param cargo    the cargo this train car carries
     */
    public TrainCar(T cargo) throws IllegalArgumentException {
        if (cargo == null) {
            throw new IllegalArgumentException();
        }
        this.cargo = cargo;
        this.nextCar = null;
    }

    /**
     * Creates a getter which gets the 'cargo'.
     * @return cargo
     */
    public T getCargo() {
        return cargo;
    }

    /**
     * Creates a setter which sets the 'cargo'.
     * @param cargo  the cargo this train car carries
     */
    public void setCargo(T cargo) throws IllegalArgumentException {
        if (cargo == null) {
            throw new IllegalArgumentException();
        }
        this.cargo = cargo;
    }

    /**
     * Creates a setter which gets the 'nextCar'.
     * @return nextCar
     */
    public TrainCar<T> getNextCar() {
        return nextCar;
    }

    /**
     * Creates a setter which sets the 'nextCar'.
     * @param nextCar  reference to the next train car
     */
    public void setNextCar(TrainCar<T> nextCar) {
        this.nextCar = nextCar;
    }
}
