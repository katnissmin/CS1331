/**
 * Creates a new ComputerScience class which is an implementation of Course.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class ComputerScience extends Course {
    private String language;

    /**
     * Creates a new ComputerScience with the courseName, id, and professorName.
     * @param courseName    the name of the course
     * @param id            the course identification number
     * @param professorName the name of the professor teaching the course
     * @param language      the language in which the course is taught
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);

        if (language == null || language.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.language = language;
    }

    @Override
    /**
     * Creates a method which overrides Course's toString method.
     * @return a string in a specific format
     */
    public String toString() {
        return "ComputerScience," + super.toString() + "," + language;
    }

    @Override
    /**
     * Creates a method which overrides Course's equals method.
     * @return true if 2 course objects have the same courseName, id, professorName, and language
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof ComputerScience) {
            ComputerScience otherCourse = (ComputerScience) other;
            return super.equals(otherCourse) && this.language.equals(otherCourse.language);
        } else {
            return false;
        }
    }
}
