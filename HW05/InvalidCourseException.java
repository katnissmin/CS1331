/**
 * Creates a new InvalidCourseException class which describes an unchecked exception.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class InvalidCourseException extends RuntimeException {
    /**
     * Creates a new InvalidCourseException with message.
     * @param message    "Invalid course type!"
     */
    public InvalidCourseException(String message) {
        super(message);
    }

    /**
     * Creates a new InvalidCourseException.
     */
    public InvalidCourseException() {
        super("Invalid course type!");
    }
}
