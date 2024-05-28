/**
 * Creates a new Course class which represents a course in general.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * Creates a new IceCream with the courseName, id, and professorName.
     * @param courseName    the name of the course
     * @param id            the course identification number
     * @param professorName the name of the professor teaching the course
     */
    public Course(String courseName, int id, String professorName) {
        if (courseName == null || courseName.isEmpty() || professorName == null
                 || professorName.isEmpty() || id < 0 || id < 10000 || id > 99999) {
            throw new IllegalArgumentException();
        }
        this.courseName = courseName;
        this.id = id;
        this.professorName = professorName;
    }

    @Override
    /**
     * Creates a method which overrides Object's toString method.
     * @return a string in a specific format
     */
    public String toString() {
        return courseName + "," + id + "," + professorName;
    }

    @Override
    /**
     * Creates a method which overrides Object's equals method.
     * @return true if 2 course objects have the same courseName, id and professorName
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Course) {
            Course otherCourse = (Course) other;
            return courseName.equals(otherCourse.courseName) && id == otherCourse.id
                && professorName.equals(otherCourse.professorName);
        } else {
            return false;
        }
    }
}
