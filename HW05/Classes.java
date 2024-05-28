import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Creates a new Classes class which holds various public static methods.
 */
/**
 * @author Katniss
 * @version 1.0
 */

public class Classes {
    /**
     * Creates a method which takes the fileName.
     * @param fileName  String representing the name of the file to read from
     * @return a string in a specific format
     */
    public static ArrayList<Course> outputCourses(String fileName)
        throws FileNotFoundException, InvalidCourseException {
        if (fileName == null) {
            throw new FileNotFoundException();
        }

        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        String line = "";
        ArrayList<Course> courses = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] values = line.split(",");

            if (values[0].equals("ComputerScience")) {
                int id = Integer.parseInt(values[2]);
                ComputerScience cs = new ComputerScience(values[1], id, values[3], values[4]);
                courses.add(cs);
            } else if (values[0].equals("LabScience")) {
                int id = Integer.parseInt(values[2]);
                boolean labCoatRequired = Boolean.parseBoolean(values[4]);
                LabScience ls  = new LabScience(values[1], id, values[3], labCoatRequired);
                courses.add(ls);
            } else {
                scanner.close();
                throw new InvalidCourseException();
            }
        }
        scanner.close();
        return courses;
    }


    /**
     * Creates a method which takes the fileName.
     * @param fileName  String representing the name of the file to read from
     * @param courseList   takes the courses in the arraylist
     * @return a boolean value whether the write was successful
     */
    public static boolean writeCourses(String fileName, ArrayList<Course> courseList) {
        PrintWriter printWriter = null;
        try {
            File outFile = new File(fileName);
            if (outFile.exists() && !outFile.isDirectory()) {
                ArrayList<Course> existingCoursefile = outputCourses(fileName);
                printWriter = new PrintWriter(outFile);
                for (Course course : existingCoursefile) {
                    printWriter.println(course.toString());
                }
                for (Course course : courseList) {
                    printWriter.println(course.toString());
                }
            } else {
                printWriter = new PrintWriter(outFile);
                for (Course course : courseList) {
                    printWriter.println(course.toString());
                }
            }
            printWriter.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            printWriter.close();
            return false;
        }
    }

    /**
     * Creates a method which takes the fileName.
     * @param fileName  String representing the name of the file to read from
     * @param course    a course object
     * @return an ArrayList of Integers
     */
    public static ArrayList<Integer> readCourses(String fileName, Course course)
        throws FileNotFoundException, InvalidCourseException {

        Integer index = 1;
        ArrayList<Integer> courseIndex = new ArrayList<>();
        ArrayList<Course> fileCourses = outputCourses(fileName);
        for (Course fileCourse : fileCourses) {
            if (course.equals(fileCourse)) {
                courseIndex.add(index);
            }
            index++;
        }
        return courseIndex;
    }

    /**
     * Creates a method which takes the fileName.
     * @param args  the arguments
     */
    public static void main(String[] args) {
        // Create ComputerScience and LabScience objects
        ComputerScience cs1 = new ComputerScience("IntroCS", 13010, "McDaniel", "Python");
        ComputerScience cs2 = new ComputerScience("IntroOOP", 13310, "Landry", "Java");
        ComputerScience cs3 = new ComputerScience("CompOrg", 21100, "Southern", "C++");

        LabScience ls1 = new LabScience("Chemistry", 12110, "Zhang", true);
        LabScience ls2 = new LabScience("Biology", 11070, "Kerr", true);
        LabScience ls3 = new LabScience("Physics", 22110, "Greco", false);

        // Write the objects to a file
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(cs1);
        courses.add(cs2);
        courses.add(cs3);
        courses.add(ls1);
        courses.add(ls2);
        courses.add(ls3);

        String fileName = "TestCourses.csv";

        // Add another ComputerScience object to the file, do not overwrite?
        ComputerScience cs4 = new ComputerScience("CogSci", 37900, "McGreggor", "Writing");
        ArrayList<Course> addcourse = new ArrayList<>();
        addcourse.add(cs4);

        // Read the file and print each object
        try {
            ArrayList<Course> readfile = outputCourses(fileName);
            for (Course course : readfile) {
                System.out.println(course.toString());
            }
        } catch (FileNotFoundException | InvalidCourseException e) {
            e.printStackTrace();
        }
    }
}
