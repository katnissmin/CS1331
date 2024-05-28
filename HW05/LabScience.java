/**
 * Creates a new LabScience class which is an implementation of Course.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class LabScience extends Course {
    private boolean labCoatRequired;

    /**
     * Creates a new ComputerScience with the courseName, id, and professorName.
     * @param courseName    the name of the course
     * @param id            the course identification number
     * @param professorName the name of the professor teaching the course
     * @param labCoatRequired   whether a lab coat is needed
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }

    @Override
    /**
     * Creates a method which overrides Course's toString method.
     * @return a string in a specific format
     */
    public String toString() {
        return "LabScience," + super.toString() + "," + labCoatRequired;
    }

    @Override
    /**
     * Creates a method which overrides Course's equals method.
     * @return true if 2 course objects have the same courseName, id, professorName, and labCoatRequired
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof LabScience) {
            LabScience otherCourse = (LabScience) other;
            return super.equals(otherCourse) && this.labCoatRequired == otherCourse.labCoatRequired;
        } else {
            return false;
        }
    }
}
